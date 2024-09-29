// FilmNote/src/main/java/movie.service.MovieSearchDBService.java
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
		int pg = 1; // 기본값 설정
	    if (request.getParameter("pg") != null) {
	        pg = Integer.parseInt(request.getParameter("pg"));
	    }
	    
        // 1. Data
        String opt = request.getParameter("searchOpt");
        String value = request.getParameter("searchValue");
        
        // 검색 결과를 저장할 리스트
        List<MovieDTO> searchList = null;
        
        // 검색 기준에 따라 value와 type 설정
        String type = "";
        switch (opt) {
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
        
        searchList = movieDAO.indexSelectMovie(value, type); 
        
        System.out.println("value : " + value);
        System.out.println("type : " + type);
        
	    
	    // 3. JSON 변환
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\"movies\":["); 
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
        jsonBuilder.append("]}");

	    // JSON 문자열 생성
	    String jsonResponse = jsonBuilder.toString();
	     System.out.println("JSON 응답: " + jsonResponse);


        // 5. Response
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.print(jsonResponse); // JSON 응답 전송
        out.flush(); // 버퍼를 플러시하여 응답을 보냄
        
	    request.setAttribute("pg", pg);
         request.setAttribute("searchList", searchList);
        
		
		return "none";
	}

}
