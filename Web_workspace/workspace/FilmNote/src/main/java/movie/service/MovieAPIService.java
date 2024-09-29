package movie.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import main.dao.IndexDAO;
import movie.bean.MovieDTO;

public class MovieAPIService {
    // 참고 사이트: https://www.kmdb.or.kr/info/api/apiDetail/6
    // API 호출을 위해 사용하는 key 값
    private String apiKey = "3I4UZ7HCCR8766FMA4OM"; // KMDB에서 발급받은 API key
    private String nationStr = "대한민국"; // 국가 설정
    private String typeStr = "극영화"; // 영화 유형
    private String releaseDtEndStr = "20240931"; // 검색할 영화의 개봉 종료일 (YYYYMMDD 형식)
    private String releaseDtStartStr = "20200101"; // 검색할 영화의 개봉 시작일 (YYYYMMDD 형식)
    
    /** 특정 값이 '||'로 구분된 문자열을 처리하여 첫 번째 유효한 값을 반환 */
    public String setSplit(String splitStr) {
        // 파라미터 splitStr가 '||'로 구분된 문자열일 경우 이를 분리하고, 유효한 첫 번째 값을 반환
        String result = "none"; // 기본값 설정
        String[] splitArray = splitStr.replace("|", "@@").split("@@"); // '||'를 '@@'로 변환 후 split

        for (String data : splitArray) {
            if (!data.equals("0") && !data.equals("")) { // 유효하지 않은 값('0' 또는 빈 문자열)은 제외
                result = data.trim(); // 유효한 값 발견 시 공백 제거 후 결과값 설정
                break;
            }
        }
        return result; // 결과값 반환
    }

    /** JSON 데이터에서 영화의 개봉일 및 관람등급을 추출 */
    public HashMap<String, String> getRatingInfo(JSONObject jsonObject) {
        HashMap<String, String> result = new HashMap<String, String>();
        try {
            JSONArray ratingArray = (JSONArray) jsonObject.get("rating");

            for (Object ratingObj : ratingArray) {
                JSONObject rating = (JSONObject) ratingObj;

                // 개봉일 정보 추출
                String setdate = setSplit(rating.get("releaseDate").toString());
                String formattedDate = "none";

                // 개봉일 형식이 'YYYY-MM-DD'에 맞는지 확인 후 변환
                try {
                    if (!setdate.equals("none")) {
                        if (!setdate.substring(4, 6).equals("00") && !setdate.substring(6, 8).equals("00")) {
                            formattedDate = setdate.substring(0, 4) + "-" + setdate.substring(4, 6) + "-" + setdate.substring(6, 8);
                        }
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("MovieAPIService.getRatingInfo() >> " + setdate);
                    setdate = "none";
                }
                result.put("releaseDate", formattedDate); // 개봉일 저장

                // 관람등급 정보 추출 및 정제
                String ratingGradeStr = setSplit(rating.get("ratingGrade").toString());
                String[] replaceText = {"세이상관람가", "세관람가", "(청소년관람불가)"};
                for (String re : replaceText) ratingGradeStr = ratingGradeStr.replace(re, "");
                if (ratingGradeStr.equals("전체관람가")) ratingGradeStr = "0"; // 전체 관람가를 0으로 변환

                // 관람등급이 숫자로 변환 가능한지 확인
                try {
                    if (!ratingGradeStr.equals("none")) Integer.parseInt(ratingGradeStr);
                } catch (ClassCastException e) {
                    ratingGradeStr = "none";
                }
                result.put("ratingGrade", ratingGradeStr); // 관람등급 저장
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result; // 개봉일 및 관람등급 정보를 담은 HashMap 반환
    }

    /** 영화 줄거리를 추출하는 메서드 */
    public String getPlotsInfo(JSONObject plotsJson) {
        String result = "none";
        JSONArray plotArray = (JSONArray) plotsJson.get("plot");

        // 줄거리 정보를 배열에서 하나씩 가져와서 유효한 값만 반환
        for (Object plotObj : plotArray) {
            JSONObject plot = (JSONObject) plotObj;
            if (!plot.get("plotText").toString().equals("0") && !plot.equals("")) {
                result = plot.get("plotText").toString().trim();
                break;
            }
        }
        return result; // 줄거리 반환
    }

    /** 영화 감독 정보를 추출하는 메서드 */
    public String getDirectorInfo(JSONObject directorJson) {
        String result = "none";

        JSONArray directorArray = (JSONArray) directorJson.get("director");
        // 감독 정보를 배열에서 하나씩 가져와서 유효한 값만 반환
        for (Object directorObj : directorArray) {
            JSONObject director = (JSONObject) directorObj;
            if (!director.get("directorNm").toString().equals("0") && !director.equals("")) {
                result = director.get("directorNm").toString().trim();
                break;
            }
        }
        return result; // 감독 이름 반환
    }

    /** 영화 정보를 DB에 저장하는 메서드 */
    public void getMovieDataList(JSONArray movieInfoList) {
        IndexDAO dao = IndexDAO.getInstance(); // DAO 인스턴스 생성

        // 영화 목록을 순회하며 각 영화를 DB에 저장
        for (Object movie : movieInfoList) {
            JSONObject movieData = (JSONObject) movie;

            // 에로 장르는 제외하고 영화 데이터를 처리
            if (!movieData.get("genre").equals("에로")) {
                MovieDTO dto = null;
                Boolean isOkData = true; // 데이터 유효성 확인 플래그

                // 영화의 개봉일, 관람등급, 줄거리, 감독, 포스터 정보 추출
                HashMap<String, String> ratingsInfo = getRatingInfo((JSONObject) movieData.get("ratings"));
                String plotText = getPlotsInfo((JSONObject) movieData.get("plots"));
                String director = getDirectorInfo((JSONObject) movieData.get("directors"));
                String posterURL = setSplit(movieData.get("posters").toString());

                // 추출된 정보를 확인 후 출력
                System.out.println("영화명: " + movieData.get("title").toString().replaceAll("!HS", "").replaceAll("!HE", "").trim());
                System.out.println("개봉일: " + ratingsInfo.get("releaseDate"));
                System.out.println("장르: " + movieData.get("genre"));
                System.out.println("관람가: " + ratingsInfo.get("ratingGrade"));
                System.out.println("감독: " + director);
                System.out.println("줄거리: " + plotText);
                System.out.println("포스터: " + posterURL);

                // 영화 정보를 배열에 저장하여 유효성 확인
                String[] movieInfoArr = {
                    0+"", 
                    movieData.get("title").toString(), 
                    director,
                    movieData.get("genre").toString(),
                    ratingsInfo.get("releaseDate"),
                    ratingsInfo.get("ratingGrade"), 
                    0+"",
                    plotText,
                    posterURL
                };

                // 배열에 유효하지 않은 값이 있으면 DB에 저장하지 않음
                for (String info : movieInfoArr) {
                    if (info.equals("none")) {
                        isOkData = false;
                        break;
                    }
                }

                // 유효한 데이터만 DB에 저장
                if (isOkData) {
                    dto = new MovieDTO(
                        0, 
                        movieData.get("title").toString(), 
                        director,
                        movieData.get("genre").toString(),
                        ratingsInfo.get("releaseDate"),
                        Integer.parseInt(ratingsInfo.get("ratingGrade")), 
                        0,
                        plotText,
                        posterURL
                    );
                    System.out.println(dto.toString());
                    dao.insertMovieAPIData(dto); // 영화 데이터를 DB에 삽입
                }
                System.out.println("--------");
            }
        }
    }

    /** KMDB API를 사용하여 영화 데이터를 가져오는 메서드 */
    public void movieAPI() {
        StringBuilder result = new StringBuilder();

        try {
            // API 요청 URL 생성
            String nation = java.net.URLEncoder.encode(nationStr, "UTF-8");
            String type = java.net.URLEncoder.encode(typeStr, "UTF-8");
            String releaseDtEnd = java.net.URLEncoder.encode(releaseDtEndStr, "UTF-8");
            String releaseDtStart = java.net.URLEncoder.encode(releaseDtStartStr, "UTF-8");

            URL url = new URL(
                "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2"
                + "&ServiceKey=" + apiKey
                + "&listCount=100"
                + "&sort=RANK,1"
                + "&nation=" + nation
                + "&releaseDte=" + releaseDtEnd
                + "&releaseDts=" + releaseDtStart
                + "&type=" + type
            );

            // API 응답을 읽기 위한 BufferedReader 생성
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String line;

            // 응답 내용을 StringBuilder에 저장
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            br.close(); // BufferedReader 닫기

            // JSON 데이터 파싱
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result.toString());

            // "Data" 필드에서 영화 목록 가져오기
            JSONArray dataList = (JSONArray) jsonObject.get("Data");

            if (dataList != null && !dataList.isEmpty()) {
                JSONObject firstDataObject = (JSONObject) dataList.get(0);
                JSONArray movieInfoList = (JSONArray) firstDataObject.get("Result");

                // DB에 Movie 데이터를 저장
                getMovieDataList(movieInfoList);
            } else {
                System.out.println("검색 결과가 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MovieAPIService().movieAPI();
    }
}
