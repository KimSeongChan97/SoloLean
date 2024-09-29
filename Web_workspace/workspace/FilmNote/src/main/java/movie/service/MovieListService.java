// FilmNote/src/main/java/movie.service.MovieListService.java
package movie.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import movie.bean.MovieDTO;
import movie.bean.MoviePaging;
import movie.dao.MovieDAO;

public class MovieListService implements CommandProcess {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

	    // 1. Data 받기
	    int pg = 1; // 기본값 설정
	    if (request.getParameter("pg") != null) {
	        pg = Integer.parseInt(request.getParameter("pg"));
	    }
	    // System.out.println("pg: " + pg); // [콘솔결과] pg: 1 (잘 가져옴)
		
	    // MySQL - 한 페이지당 10개씩
	    int endNum = 10; // 개수
	    int startNum = pg * 10 - 10; // 시작위치, 0부터 시작 - 0, 5, 10, 15, ... // pg * endNum - endNum
	
	    // 2. DB
	    MovieDAO movieDAO = MovieDAO.getInstance();
	    List<MovieDTO> list = movieDAO.movieList(startNum, endNum);
	    int totalA = movieDAO.getTotalA();
	    
	    // 페이징 처리
	    MoviePaging moviePaging = new MoviePaging();
	    moviePaging.setCurrentPage(pg);
	    moviePaging.setPageBlock(5);
	    moviePaging.setPageSize(10);
	    moviePaging.setTotalA(totalA);
	    moviePaging.makePagingHTML();		
	    
		// 3. Response
	    request.setAttribute("pg", pg);
	    request.setAttribute("list", list);
	    request.setAttribute("moviePaging", moviePaging);
	    
		return "/admin/movieList.jsp";
	}

}
