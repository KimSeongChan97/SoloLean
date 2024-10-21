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

@Service
public class UserNaverLoginServiceImpl implements UserNaverLoginService {
	@Autowired
	NaverLoginConfiguration naverLoginConf;
	@Autowired
	UserDTO userDTO;
	
	@Override
	public String naverLogin(HttpSession session) { // 네이버 로그인 인증 요청
	    String redirectURI = null;
	    String apiURL = null;
	    
		try {
			redirectURI = URLEncoder.encode(naverLoginConf.getRedirectURI(), "UTF-8");
			SecureRandom random = new SecureRandom();
		    String state = new BigInteger(130, random).toString();
		    
		    // 네이버 로그인 인증 요청 URL 생성
		    apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		    apiURL += "&client_id=" + naverLoginConf.getClientID();
		    apiURL += "&redirect_uri=" + redirectURI;
		    apiURL += "&state=" + state;
		    session.setAttribute("state", state);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println(apiURL);
		
		return apiURL;
	}

	@Override
	public UserDTO loginNaver(Map<String, String> map, HttpSession session) {
		String code = map.get("code");
	    String state = map.get("state");
	    System.out.println("1. userDTO: " + userDTO.toString());
	    
	    // 1. 접근 토큰 발급 요청
	    String access_token = getAccessToken(code, state); 
	    // 2. 사용자 정보 요청
	    JSONObject userInfoJSON = getUserInfo(access_token);
	    // 3. 사용자 정보 DTO에 저장
	    setNaverUserDTO(userInfoJSON);
	    System.out.println("2. userDTO: " + userDTO.toString());
	    
	    return userDTO;
	}

	// 접근 토큰 발급 요청
	private String getAccessToken(String code, String state) {
		// 토큰 요청 URL 생성
		String tokenUrl = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		tokenUrl += "client_id=" + naverLoginConf.getClientID();
		tokenUrl += "&client_secret=" + naverLoginConf.getClientSecret();
		tokenUrl += "&redirect_uri=" + naverLoginConf.getRedirectURI();
		tokenUrl += "&code=" + code;
		tokenUrl += "&state=" + state;

	    System.out.println("getAccessToken() tokenUrl: " + tokenUrl);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(tokenUrl, String.class);

        try {
            JSONObject jsonObject = new JSONObject(response.getBody());
            System.out.println("getAccessToken() resultcode: " + jsonObject);
            System.out.println("getAccessToken() access_token: " + jsonObject.getString("access_token"));
            return jsonObject.getString("access_token");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return null;
	}
	
	// 사용자 정보 요청
	private JSONObject getUserInfo(String access_token) {
        String apiUrl = "https://openapi.naver.com/v1/nid/me";
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + access_token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        try {
            JSONObject jsonObject = new JSONObject(response.getBody());
            System.out.println("json: " + jsonObject.getJSONObject("response"));
            return jsonObject.getJSONObject("response");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
	}
	
	private void setNaverUserDTO(JSONObject userInfoJSON) {
		// seq, pwd, emailCheck, grade 저장 X 
		
		// 이름 & 성별 & 이메일 & 로그인 타입
		userDTO.setUserId(userInfoJSON.get("id").toString());
		userDTO.setName(userInfoJSON.get("name").toString());
		userDTO.setGender(userInfoJSON.get("gender").toString());
		userDTO.setEmail(userInfoJSON.get("email").toString());
		userDTO.setLogintype("NAVER");
		
		// 생년월일 설정
		userDTO.setBirth1(Integer.parseInt(userInfoJSON.get("birthyear").toString()));
		if(!userInfoJSON.get("birthday").toString().equals("") && userInfoJSON.get("birthday").toString() != null) {
			String[] birthday = userInfoJSON.get("birthday").toString().split("-");
			userDTO.setBirth2(Integer.parseInt(birthday[0]));
			userDTO.setBirth3(Integer.parseInt(birthday[1]));
		}
		
		// 전화번호 
		if(!userInfoJSON.get("mobile").toString().equals("") && userInfoJSON.get("mobile").toString() != null) {
			String[] mobileArr = userInfoJSON.get("mobile").toString().split("-");
			userDTO.setTel1(mobileArr[0]);
			userDTO.setTel2(mobileArr[1]);
			userDTO.setTel3(mobileArr[2]);
		}
	}
	
}
