package user.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import spring.conf.NaverLoginConfiguration;
import user.bean.UserDTO;
import user.service.UserNaverLoginService;

@Service  // 이 클래스가 Spring의 서비스 계층으로 동작하며, 비즈니스 로직을 처리
public class UserNaverLoginServiceImpl implements UserNaverLoginService {
    @Autowired
    NaverLoginConfiguration naverLoginConf;  // NaverLoginConfiguration 설정 주입
    @Autowired
    UserDTO userDTO;  // UserDTO 객체 주입 (로그인된 사용자 정보 저장)

    @Override
    public String naverLogin(HttpSession session) { // 네이버 로그인 인증 요청
        String redirectURI = null;
        String apiURL = null;
        
        try {
            // 리다이렉트 URI를 인코딩하여 네이버 로그인 인증 요청 URL 생성
            redirectURI = URLEncoder.encode(naverLoginConf.getRedirectURI(), "UTF-8");
            SecureRandom random = new SecureRandom();
            String state = new BigInteger(130, random).toString();  // 상태 토큰 생성 (보안용)
            
            // 네이버 로그인 인증 요청 URL 구성
            apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
            apiURL += "&client_id=" + naverLoginConf.getClientID();  // 클라이언트 ID 설정
            apiURL += "&redirect_uri=" + redirectURI;  // 리다이렉트 URI 설정
            apiURL += "&state=" + state;  // 상태 토큰 설정
            session.setAttribute("state", state);  // 상태 토큰을 세션에 저장
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        System.out.println(apiURL);  // 생성된 네이버 로그인 인증 URL 출력
        
        return apiURL;  // 네이버 로그인 인증 URL 반환
    }

    @Override
    public UserDTO loginNaver(Map<String, String> map, HttpSession session) {
        String code = map.get("code");  // 네이버 로그인 인증 코드
        String state = map.get("state");  // 상태 토큰
        System.out.println("1. userDTO: " + userDTO.toString());  // 디버깅용: 초기 userDTO 출력
        
        // 1. 네이버로부터 접근 토큰 발급
        String access_token = getAccessToken(code, state); 
        
        // 2. 발급된 접근 토큰을 사용하여 사용자 정보 요청
        JSONObject userInfoJSON = getUserInfo(access_token);
        
        // 3. 받아온 사용자 정보를 DTO에 저장
        setNaverUserDTO(userInfoJSON);
        System.out.println("2. userDTO: " + userDTO.toString());  // 디버깅용: 사용자 정보 저장 후 출력
        
        return userDTO;  // 사용자 정보가 저장된 userDTO 반환
    }

    // 접근 토큰 발급 요청
    private String getAccessToken(String code, String state) {
        // 토큰 발급 요청 URL 생성
        String tokenUrl = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
        tokenUrl += "client_id=" + naverLoginConf.getClientID();  // 클라이언트 ID
        tokenUrl += "&client_secret=" + naverLoginConf.getClientSecret();  // 클라이언트 시크릿
        tokenUrl += "&redirect_uri=" + naverLoginConf.getRedirectURI();  // 리다이렉트 URI
        tokenUrl += "&code=" + code;  // 인증 코드
        tokenUrl += "&state=" + state;  // 상태 토큰

        System.out.println("getAccessToken() tokenUrl: " + tokenUrl);  // 디버깅용: 토큰 요청 URL 출력
        RestTemplate restTemplate = new RestTemplate();  // RestTemplate을 사용해 API 요청
        ResponseEntity<String> response = restTemplate.getForEntity(tokenUrl, String.class);  // API 호출

        try {
            JSONObject jsonObject = new JSONObject(response.getBody());  // 응답 본문을 JSON 객체로 변환
            System.out.println("getAccessToken() resultcode: " + jsonObject);
            System.out.println("getAccessToken() access_token: " + jsonObject.getString("access_token"));
            return jsonObject.getString("access_token");  // 접근 토큰 반환
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;  // 실패 시 null 반환
    }
    
    // 사용자 정보 요청
    private JSONObject getUserInfo(String access_token) {
        String apiUrl = "https://openapi.naver.com/v1/nid/me";  // 사용자 정보 요청 URL
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();  // 요청 헤더 설정
        headers.add("Authorization", "Bearer " + access_token);  // 인증 토큰 설정
        headers.setContentType(MediaType.APPLICATION_JSON);  // 응답 형식 설정
        
        HttpEntity<String> entity = new HttpEntity<>(headers);  // 요청 엔티티 생성
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        try {
            JSONObject jsonObject = new JSONObject(response.getBody());  // 응답 본문을 JSON 객체로 변환
            System.out.println("json: " + jsonObject.getJSONObject("response"));  // 사용자 정보 출력
            return jsonObject.getJSONObject("response");  // 사용자 정보 반환
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;  // 실패 시 null 반환
    }
    
    // 네이버에서 가져온 사용자 정보를 UserDTO에 저장
    private void setNaverUserDTO(JSONObject userInfoJSON) {
        // seq, pwd, emailCheck, grade 등의 정보는 저장하지 않음
        
        // 사용자 ID, 이름, 성별, 이메일, 로그인 타입 저장
        userDTO.setUserId(userInfoJSON.get("id").toString());
        userDTO.setName(userInfoJSON.get("name").toString());
        userDTO.setGender(userInfoJSON.get("gender").toString());
        userDTO.setEmail(userInfoJSON.get("email").toString());
        userDTO.setLogintype("NAVER");  // 로그인 타입을 "NAVER"로 설정

        // 생년월일 설정
        userDTO.setBirth1(Integer.parseInt(userInfoJSON.get("birthyear").toString()));  // 출생년도
        if (!userInfoJSON.get("birthday").toString().equals("") && userInfoJSON.get("birthday").toString() != null) {
            String[] birthday = userInfoJSON.get("birthday").toString().split("-");  // 생일을 "-" 기준으로 분리
            userDTO.setBirth2(Integer.parseInt(birthday[0]));  // 생일 월
            userDTO.setBirth3(Integer.parseInt(birthday[1]));  // 생일 일
        }

        // 전화번호 설정
        if (!userInfoJSON.get("mobile").toString().equals("") && userInfoJSON.get("mobile").toString() != null) {
            String[] mobileArr = userInfoJSON.get("mobile").toString().split("-");  // 전화번호를 "-" 기준으로 분리
            userDTO.setTel1(mobileArr[0]);  // 전화번호 앞자리
            userDTO.setTel2(mobileArr[1]);  // 전화번호 중간자리
            userDTO.setTel3(mobileArr[2]);  // 전화번호 뒷자리
        }
    }
}
