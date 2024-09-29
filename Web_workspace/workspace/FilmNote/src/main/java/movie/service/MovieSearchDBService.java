package movie.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import movie.bean.MovieDTO;
import movie.dao.MovieDAO;

public class MovieSearchDBService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 1. 페이지 번호 pg 받기. 기본값은 1로 설정
		int pg = 1; // 기본값 설정
	    if (request.getParameter("pg") != null) {
	        pg = Integer.parseInt(request.getParameter("pg")); // pg 파라미터가 있을 경우, 해당 값을 사용
	    }
	    
	    // 2. 검색 옵션과 검색 값 받기
        // searchOpt와 searchValue라는 파라미터로 검색 옵션과 검색어를 받음
        String opt = request.getParameter("searchOpt"); // 검색 기준 (영화 제목, 감독 등)
        String value = request.getParameter("searchValue"); // 검색어
        
        // 검색 결과를 저장할 리스트
        List<MovieDTO> searchList = null;
        
        // 검색 기준에 따라 'type' 값을 설정
        String type = "";
        switch (opt) {
            case "movie-director": // 사용자가 영화 감독으로 검색을 선택한 경우
                type = "director";
                break;
            case "movie-title": // 사용자가 영화 제목으로 검색을 선택한 경우
                type = "title";
                break;
            default:
            	type = "title"; // 기본값은 영화 제목
                break;
        }
        
        // 3. DB 작업
        // DAO를 통해 검색 결과를 가져옴
        MovieDAO movieDAO = MovieDAO.getInstance(); // 싱글톤으로 관리되는 MovieDAO 인스턴스 가져오기
        
        // 'value'는 검색어, 'type'은 검색 기준 (감독 또는 제목)
        searchList = movieDAO.indexSelectMovie(value, type); // 검색 결과를 가져옴
        
        System.out.println("value : " + value); // 검색어 출력
        System.out.println("type : " + type); // 검색 기준 출력
        
	    // 4. 검색 결과를 JSON 형식으로 변환
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\"movies\":["); // JSON 배열 형식으로 영화 목록을 감싸기 시작
        for (int i = 0; i < searchList.size(); i++) {
            MovieDTO movie = searchList.get(i);
            jsonBuilder.append("{")
                       .append("\"mcode\":").append(movie.getMcode()).append(",") // 영화 코드 추가
                       .append("\"title\":\"").append(movie.getTitle().replace("\"", "\\\"")).append("\",") // 영화 제목
                       .append("\"director\":\"").append(movie.getDirector().replace("\"", "\\\"")).append("\",") // 감독 이름
                       .append("\"genre\":\"").append(movie.getGenre().replace("\"", "\\\"")).append("\",") // 장르
                       .append("\"release_date\":\"").append(movie.getRelease_date().replace("\"", "\\\"")).append("\",") // 개봉일
                       .append("\"rating\":").append(movie.getRating()).append(",") // 영화 등급
                       .append("\"score\":").append(movie.getScore()).append(",") // 영화 평점
                       .append("\"synopsis\":\"").append(movie.getSynopsis().replace("\"", "\\\"")).append("\",") // 영화 줄거리
                       .append("\"poster\":\"").append(movie.getPoster().replace("\"", "\\\"")).append("\"") // 영화 포스터
                       .append("}");
            if (i < searchList.size() - 1) {
                jsonBuilder.append(","); // 마지막 항목이 아닐 경우, 콤마 추가
            }
        }
        jsonBuilder.append("]}"); // JSON 배열 닫기

	    // JSON 문자열 생성 완료
	    String jsonResponse = jsonBuilder.toString();
	    System.out.println("JSON 응답: " + jsonResponse); // 디버깅용 JSON 응답 확인

        // 5. Response 처리
        // JSON 형식으로 클라이언트에 응답 보내기
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.print(jsonResponse); // JSON 데이터를 응답으로 출력
        out.flush(); // 버퍼를 비워서 즉시 응답 전송
        
	    // JSP에서 사용할 값들 설정
	    request.setAttribute("pg", pg); // 현재 페이지 정보 설정
        request.setAttribute("searchList", searchList); // 검색 결과 리스트 설정
		
		// JSON 응답을 반환하므로 뷰로 이동할 필요가 없기 때문에 "none" 반환
		return "none";
	}

}