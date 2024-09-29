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
	private String apiKey = "3I4UZ7HCCR8766FMA4OM"; // api key
	private String nationStr = "대한민국";
	private String typeStr = "극영화";
	private String releaseDtEndStr = "20240931"; // 개봉일 종료
	private String releaseDtStartStr = "20200101"; // 개봉일 시작
	
	// 데이터 정제
	public String setSplit(String splitStr) { // 값이 || 로 구분되어 있는 것 파싱
		// 개봉일, 관람등급, 포스터
		String result = "none";
		String[] splitArray = splitStr.replace("|", "@@").split("@@");
		
        for (String data : splitArray) {
            if (!data.equals("0") && !data.equals("")) { // 개봉일이 0인 경우는 제외
            	result = data.trim();
            	break;
            }
        }
        
		return result;
	}
	
	// 개봉일 & 관람등급 추출
	public HashMap<String, String> getRatingInfo(JSONObject jsonObject) {
		HashMap<String, String> result = new HashMap<String, String>();
		try {
            JSONArray ratingArray = (JSONArray) jsonObject.get("rating");
            
            for (Object ratingObj : ratingArray) {
            	JSONObject rating = (JSONObject) ratingObj;
                
            	// 개봉일
            	String setdate = setSplit(rating.get("releaseDate").toString());
                String formattedDate = "none";
                // YYYY-MM-DD 
                
                try {
                	if(!setdate.equals("none")) {
                		if(!setdate.substring(4, 6).equals("00") && !setdate.substring(6, 8).equals("00")) {
                			formattedDate = setdate.substring(0, 4) + "-" + setdate.substring(4, 6) + "-" + setdate.substring(6, 8);
                		}
                	}
				} catch (StringIndexOutOfBoundsException e) {
					//e.printStackTrace();
					System.out.println("MovieAPIService.getRatingInfo() >> " + setdate);
					setdate = "none";
				}
                result.put("releaseDate", formattedDate); 
                
                // 관람 등급
                String ratingGradeStr = setSplit(rating.get("ratingGrade").toString());
                String[] replaceText = {"세이상관람가", "세관람가", "(청소년관람불가)"};
                for(String re : replaceText) ratingGradeStr = ratingGradeStr.replace(re, "");
                if(ratingGradeStr.equals("전체관람가")) ratingGradeStr = "0";
                
                try {
                	if(!ratingGradeStr.equals("none")) Integer.parseInt(ratingGradeStr);
				} catch (ClassCastException e) {
					System.err.println(ratingGradeStr);
					ratingGradeStr = "none";
				}
                
                result.put("ratingGrade", ratingGradeStr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return result;
	}
	
	// 줄거리 추출
	public String getPlotsInfo(JSONObject plotsJson) {
		String result = "none";
        JSONArray plotArray = (JSONArray) plotsJson.get("plot");
        
        for (Object plotObj : plotArray) {
            JSONObject plot = (JSONObject) plotObj;
            if (!plot.get("plotText").toString().equals("0") && !plot.equals("")) {
            	result = plot.get("plotText").toString().trim();
                break;
            }
        }
        
        return result;
	}
	
	// 감독 추출
	public String getDirectorInfo(JSONObject directorJson) {
		String result = "none";
		
        JSONArray directorArray = (JSONArray) directorJson.get("director");
        for (Object directorObj : directorArray) {
            JSONObject director = (JSONObject) directorObj;
            if (!director.get("directorNm").toString().equals("0") && !director.equals("")) {
            	result = director.get("directorNm").toString().trim();
                break;
            }
        }
        return result;
	}
	
	// DB에 데이터 저장
	public void getMovieDataList(JSONArray movieInfoList) {
		IndexDAO dao = IndexDAO.getInstance();
		
		// 영화 목록을 순회하면서 데이터 출력
        for (Object movie : movieInfoList) {
            JSONObject movieData = (JSONObject) movie;
            
            if(!movieData.get("genre").equals("에로")) {
            	MovieDTO dto = null;
            	Boolean isOkData = true;
            	
            	// 개봉일 & 관람등급
                HashMap<String, String> ratingsInfo = getRatingInfo((JSONObject) movieData.get("ratings"));
                // 줄거리
                String plotText = getPlotsInfo((JSONObject) movieData.get("plots"));
                // 감독
                String director = getDirectorInfo((JSONObject) movieData.get("directors"));
                // 포스터
                String posterURL = setSplit(movieData.get("posters").toString());
                
                System.out.println("영화명: " + movieData.get("title").toString().replaceAll("!HS", "").replaceAll("!HE", "").trim());
                System.out.println("개봉일: " + ratingsInfo.get("releaseDate"));
                System.out.println("장르: " + movieData.get("genre"));
                System.out.println("관람가: " + ratingsInfo.get("ratingGrade"));
                System.out.println("감독: " + director);
                System.out.println("줄거리: " + plotText);
                System.out.println("포스터: " + posterURL);
                
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
                
                for(String info : movieInfoArr) {
                	if(info.equals("none")) {
                		isOkData = false;
                    	break;
                    }
                }
                
                if(isOkData) {
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
                	dao.insertMovieAPIData(dto);
                }
                System.out.println("--------");
            }
        }
	}
	
	// API 사용 모든 데이터 추출 
	public void movieAPI() {
		StringBuilder result = new StringBuilder();
		
		try {
            String nation = java.net.URLEncoder.encode(nationStr, "UTF-8"); // 국가
            String type = java.net.URLEncoder.encode(typeStr, "UTF-8"); // 유형
            String releaseDtEnd = java.net.URLEncoder.encode(releaseDtEndStr, "UTF-8"); // 개봉일 종료
            String releaseDtStart = java.net.URLEncoder.encode(releaseDtStartStr, "UTF-8"); // 개봉일 시작
            
            // 제작 연도 기준 내림차순으로 정렬 (최신순)
            URL url = new URL(
                "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2"
                + "&ServiceKey=" + apiKey // KMDB API 키
                + "&listCount=100" // 검색 결과 갯수 (옵션)
                + "&sort=RANK,1" // 제작 연도 기준 내림차순 정렬 (최신순)
                + "&nation=" + nation // 국가
                + "&releaseDte=" + releaseDtEnd // 개봉일 종료
                + "&releaseDts=" + releaseDtStart // 개봉일 시작
                + "&type=" + type // 유형
            );

            // BufferedReader를 통해 API 응답을 읽기
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String line;

            // 모든 줄을 StringBuilder에 저장
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            br.close(); // BufferedReader 닫기

            // JSON 데이터 파싱
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result.toString());

            // "Data" 필드가 존재하는지 확인
            JSONArray dataList = (JSONArray) jsonObject.get("Data");

            if (dataList != null && !dataList.isEmpty()) {
                // 첫 번째 결과에서 "Result" 필드 추출
                JSONObject firstDataObject = (JSONObject) dataList.get(0);
                JSONArray movieInfoList = (JSONArray) firstDataObject.get("Result");

                // DB에 Movie 데이터 저장
                getMovieDataList(movieInfoList);
            } else {
                // 데이터가 없을 경우 처리
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