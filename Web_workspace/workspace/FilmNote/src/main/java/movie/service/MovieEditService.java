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
		int mcode = Integer.parseInt(request.getParameter("mcode")); // 요청에서 영화 코드(mcode) 받기
		int pg = Integer.parseInt(request.getParameter("pg")); // 요청에서 현재 페이지 번호(pg) 받기
		
		// 디버깅용 출력: 영화 코드와 페이지 번호 확인
		System.out.println("mcode :  " + mcode);
		System.out.println("pg : " + pg);
		
		// 2. DB에서 영화 정보를 가져오기
		MovieDAO movieDAO = MovieDAO.getInstance(); // MovieDAO의 싱글톤 인스턴스 가져오기
		MovieDTO movieDTO = movieDAO.getMovie(mcode); // mcode를 사용해 해당 영화의 정보를 DB에서 가져옴

		// 3. Response 처리
		// 영화 수정 페이지(movieEdit.jsp)로 넘길 데이터를 request 객체에 저장
		request.setAttribute("mcode", mcode); // 영화 코드
		request.setAttribute("pg", pg); // 현재 페이지 번호
		request.setAttribute("movieDTO", movieDTO); // 영화 정보 DTO
		
		// 해당 데이터를 가지고 영화 수정 페이지로 이동 (Forwarding)
		return "/admin/movieEdit.jsp"; // 해당 JSP 파일로 포워딩
	}

}
