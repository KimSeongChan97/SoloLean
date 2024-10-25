package movie.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import movie.bean.MovieDTO;
import movie.dao.MovieDAO;

public class MovieViewService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 1. Data 받기
		// 클라이언트로부터 영화 코드(mcode)와 현재 페이지(pg)를 파라미터로 받아서 정수형으로 변환
		int mcode = Integer.parseInt(request.getParameter("mcode"));
		int pg = Integer.parseInt(request.getParameter("pg"));		
		
		// 2. DB
		// MovieDAO 싱글톤 인스턴스를 통해 해당 영화 코드를 이용해 영화 정보를 데이터베이스에서 조회
		MovieDAO movieDAO = MovieDAO.getInstance();
		MovieDTO movieDTO = movieDAO.getMovie(mcode);		
		
		// 3. Response
		// 요청 객체에 현재 페이지(pg)와 조회한 영화 정보를 속성(attribute)으로 설정
		// 이후 View 페이지(movieView.jsp)에서 해당 데이터들을 활용할 수 있도록 넘겨줌
		request.setAttribute("pg", pg);
		request.setAttribute("movieDTO", movieDTO);
		
		// admin 폴더 내의 movieView.jsp 페이지로 포워딩
		return "/admin/movieView.jsp";
	}

}
