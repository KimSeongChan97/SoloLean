// FilmNote/src/main/java/movie.service.MovieWriteDBService.java
package movie.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class MovieWriteDBService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		return "/admin/movieWriteDB.jsp";
	}
}
