// FilmNote/src/main/java/main/IndexService.java
package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import main.dao.IndexDAO;
import movie.bean.MovieDTO;

public class IndexService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		System.out.println("IndexService 클래스");
		List<MovieDTO> movieDTOList = IndexDAO.getInstance().getMovieBoardList();
		int movieInRowCount = 4; // 1행에 출력되는 영화 개수
		int rowCount = movieDTOList.size()/movieInRowCount; // 행의 개수	
		if(movieDTOList.size() % 4 != 0) rowCount++;
		
		request.setAttribute("movieDTOList", movieDTOList);
		request.setAttribute("movieInRowCount", movieInRowCount);
		request.setAttribute("rowCount", rowCount);

		
		return "/index.jsp";
	}

}
