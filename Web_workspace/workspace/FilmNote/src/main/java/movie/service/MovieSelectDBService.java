// FilmNote/src/main/java/movie.service.MovieSelectDBService.java
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
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			int pg = 1; // 기본값 설정
		    if (request.getParameter("pg") != null) {
		        pg = Integer.parseInt(request.getParameter("pg"));
		    }
		    
		    // MySQL - 한 페이지당 10개씩
		    int endNum = 10; // 개수
		    int startNum = pg * 10 - 10;
			
	        // 1. Data
	        String opt = request.getParameter("searchOpt");
	        String value = request.getParameter("searchValue");
	        
	        // 검색 결과를 저장할 리스트
	        List<MovieDTO> searchList = null;
	        
	        // 검색 기준에 따라 value와 type 설정
	        String type = "";
	        switch (opt) {
	            case "movie-code": // 영화 코드
	                type = "mcode";
	                break;
	            case "movie-director": // 영화 감독
	                type = "director";
	                break;
	            case "movie-title": // 영화 제목
	                type = "title";
	                break;
	            default:
	            	type = "title";
	                break;
	        }
	        
	        
	        // 2. DB
	        // DAO를 호출하여 검색 결과 가져오기
	        MovieDAO movieDAO = MovieDAO.getInstance();
	        
	        searchList = movieDAO.selectMovie(value, type, startNum, endNum); 
	        int selectTotal = movieDAO.getSelectTotal(value, type); // 검색된 총 개수
	        
	//        System.out.println("value : " + value);
	//        System.out.println("type : " + type);
	//        System.out.println("startNum : " + startNum);
	//        System.out.println("endNum : " + endNum);
	//        System.out.println("selectTotal : " + selectTotal);
	//        System.out.println("searchList : " + searchList);
	        
	        
		    // 3. 페이징 처리
		    MoviePaging selectMoviePaging = new MoviePaging();
		    selectMoviePaging.setCurrentPage(pg);
		    selectMoviePaging.setPageBlock(5);
		    selectMoviePaging.setPageSize(10);
		    selectMoviePaging.setSelectTotal(selectTotal);
		    selectMoviePaging.makePagingHTML();
		    
		    // 4. JSON 변환
		    StringBuilder jsonBuilder = new StringBuilder();
		    jsonBuilder.append("{"); // JSON 객체 시작
		    jsonBuilder.append("\"movies\":[");
		    for (int i = 0; i < searchList.size(); i++) {
		        MovieDTO movie = searchList.get(i);
		        jsonBuilder.append("{")
		                   .append("\"mcode\":").append(movie.getMcode()).append(",")
		                   .append("\"title\":\"").append(movie.getTitle().replace("\"", "\\\"")).append("\",")
		                   .append("\"director\":\"").append(movie.getDirector().replace("\"", "\\\"")).append("\",")
		                   .append("\"genre\":\"").append(movie.getGenre().replace("\"", "\\\"")).append("\",")
		                   .append("\"release_date\":\"").append(movie.getRelease_date().replace("\"", "\\\"")).append("\",")
		                   .append("\"rating\":").append(movie.getRating()).append(",")
		                   .append("\"score\":").append(movie.getScore()).append(",")
		                   .append("\"synopsis\":\"").append(movie.getSynopsis().replace("\"", "\\\"")).append("\",")
		                   .append("\"poster\":\"").append(movie.getPoster().replace("\"", "\\\"")).append("\"")
		                   .append("}");
		        if (i < searchList.size() - 1) {
		            jsonBuilder.append(",");
		        }
		    }
		    jsonBuilder.append("],");
		    jsonBuilder.append("\"selectPagingHTML\":\"").append(selectMoviePaging.getSelectPagingHTML().toString().replace("\"", "\\\"")).append("\"");
		    jsonBuilder.append("}"); // JSON 객체 끝
	
		    // JSON 문자열 생성
		    String jsonResponse = jsonBuilder.toString();
		    // System.out.println("JSON 응답: " + jsonResponse);
	
	
	        // 5. Response
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	
	        PrintWriter out = response.getWriter();
	        out.print(jsonResponse); // JSON 응답 전송
	        out.flush(); // 버퍼를 플러시하여 응답을 보냄
	        
		    request.setAttribute("pg", pg);
	        // request.setAttribute("searchList", searchList);
	        // request.setAttribute("selectMoviePaging", selectMoviePaging);
	        
	        System.out.println("selectMoviePaging : " + selectMoviePaging);
			
			return "none";
		}
		
	    // AJAX 요청이 아닐 경우 일반 JSP 페이지로 처리
	    return "movieList.do"; 	
	}

}
