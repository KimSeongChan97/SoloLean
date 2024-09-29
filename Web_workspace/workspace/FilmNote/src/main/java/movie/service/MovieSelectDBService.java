package movie.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import movie.bean.MovieDTO;
import movie.bean.MoviePaging;
import movie.dao.MovieDAO;

public class MovieSelectDBService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 1. AJAX 요청인지 확인 (AJAX 요청은 특별한 헤더 "X-Requested-With" 값을 가짐)
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			
			// 2. 페이지 번호를 받음 (pg 파라미터가 없을 경우 기본값 1 설정)
			int pg = 1; // 기본값 설정
		    if (request.getParameter("pg") != null) {
		        pg = Integer.parseInt(request.getParameter("pg"));
		    }
		    
		    // MySQL 데이터베이스에서 1페이지당 10개의 영화 목록을 가져옴
		    int endNum = 10; // 페이지 당 표시할 영화 개수
		    int startNum = pg * 10 - 10; // 시작 위치, 예: 0, 10, 20 ...

			// 3. 검색 옵션과 검색 값 받기
	        String opt = request.getParameter("searchOpt"); // 검색 기준 옵션 (제목, 감독, 영화 코드 등)
	        String value = request.getParameter("searchValue"); // 검색어
	        
	        // 검색 결과를 저장할 리스트
	        List<MovieDTO> searchList = null;
	        
	        // 검색 기준에 따라 검색할 필드를 설정 (영화 코드, 제목, 감독 등)
	        String type = "";
	        switch (opt) {
	            case "movie-code": // 영화 코드로 검색
	                type = "mcode";
	                break;
	            case "movie-director": // 감독 이름으로 검색
	                type = "director";
	                break;
	            case "movie-title": // 영화 제목으로 검색
	                type = "title";
	                break;
	            default: // 기본적으로 제목으로 검색
	            	type = "title";
	                break;
	        }
	        
	        // 4. DB 작업
	        // MovieDAO 인스턴스를 통해 데이터베이스에서 영화 목록을 검색
	        MovieDAO movieDAO = MovieDAO.getInstance();
	        
	        searchList = movieDAO.selectMovie(value, type, startNum, endNum); // 검색 결과 영화 목록
	        int selectTotal = movieDAO.getSelectTotal(value, type); // 검색된 총 영화 개수
	        
	        // 5. 페이징 처리
		    MoviePaging selectMoviePaging = new MoviePaging();
		    selectMoviePaging.setCurrentPage(pg); // 현재 페이지 설정
		    selectMoviePaging.setPageBlock(5); // 페이지 네비게이션 블록 개수 설정
		    selectMoviePaging.setPageSize(10); // 페이지 당 영화 개수 설정
		    selectMoviePaging.setSelectTotal(selectTotal); // 검색된 영화 총 개수 설정
		    selectMoviePaging.makePagingHTML(); // 페이징 HTML 생성
		    
		    // 6. JSON 변환
		    // 검색 결과를 JSON 형식으로 변환하여 클라이언트에 전송
		    StringBuilder jsonBuilder = new StringBuilder();
		    jsonBuilder.append("{");
		    jsonBuilder.append("\"movies\":[");
		    for (int i = 0; i < searchList.size(); i++) {
		        MovieDTO movie = searchList.get(i);
		        jsonBuilder.append("{")
		                   .append("\"mcode\":").append(movie.getMcode()).append(",") // 영화 코드
		                   .append("\"title\":\"").append(movie.getTitle().replace("\"", "\\\"")).append("\",") // 영화 제목
		                   .append("\"director\":\"").append(movie.getDirector().replace("\"", "\\\"")).append("\",") // 감독
		                   .append("\"genre\":\"").append(movie.getGenre().replace("\"", "\\\"")).append("\",") // 장르
		                   .append("\"release_date\":\"").append(movie.getRelease_date().replace("\"", "\\\"")).append("\",") // 개봉일
		                   .append("\"rating\":").append(movie.getRating()).append(",") // 영화 등급
		                   .append("\"score\":").append(movie.getScore()).append(",") // 영화 평점
		                   .append("\"synopsis\":\"").append(movie.getSynopsis().replace("\"", "\\\"")).append("\",") // 줄거리
		                   .append("\"poster\":\"").append(movie.getPoster().replace("\"", "\\\"")).append("\"") // 포스터 URL
		                   .append("}");
		        if (i < searchList.size() - 1) {
		            jsonBuilder.append(","); // 마지막 항목이 아니면 콤마 추가
		        }
		    }
		    jsonBuilder.append("],");
		    jsonBuilder.append("\"selectPagingHTML\":\"").append(selectMoviePaging.getSelectPagingHTML().toString().replace("\"", "\\\"")).append("\"");
		    jsonBuilder.append("}");

		    // JSON 문자열로 변환 완료
		    String jsonResponse = jsonBuilder.toString();
		    // System.out.println("JSON 응답: " + jsonResponse); // 디버깅용 응답 확인
	
	        // 7. Response 처리
	        // JSON 형식으로 클라이언트에 응답
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	
	        PrintWriter out = response.getWriter();
	        out.print(jsonResponse); // JSON 응답 전송
	        out.flush(); // 버퍼를 플러시하여 응답을 즉시 전송
	        
		    request.setAttribute("pg", pg); // 현재 페이지 정보 설정
	        
	        return "none"; // AJAX 응답이므로 뷰로 이동할 필요가 없음
		}
		
	    // AJAX 요청이 아닐 경우 일반 JSP 페이지로 처리
	    return "movieList.do"; 	
	}

}
