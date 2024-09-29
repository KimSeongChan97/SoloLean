// FilmNote/src/main/java/movie.service.MovieEditService.java
package movie.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import movie.bean.MovieDTO;
import movie.dao.MovieDAO;

public class MovieEditService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 1. Data 받기
		int mcode = Integer.parseInt(request.getParameter("mcode"));
		int pg = Integer.parseInt(request.getParameter("pg"));	
		
		
		System.out.println("mcode :  " + mcode);
		System.out.println("pg : " + pg);
		
		// 2. DB		
		MovieDAO movieDAO = MovieDAO.getInstance();
		MovieDTO movieDTO = movieDAO.getMovie(mcode);	

		// 3. Response
		request.setAttribute("mcode", mcode);
		request.setAttribute("pg", pg);
		request.setAttribute("movieDTO", movieDTO);
		
		return "/admin/movieEdit.jsp";
	}

}
