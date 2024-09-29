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
	    // 요청 파라미터로부터 'pg' 값을 받아 페이지 정보를 가져옵니다.
	    int pg = 1; // 기본 페이지는 1로 설정
	    if (request.getParameter("pg") != null) {
	        pg = Integer.parseInt(request.getParameter("pg")); // 페이지 정보가 있으면 해당 값을 pg에 할당
	    }
	    // System.out.println("pg: " + pg); // [콘솔결과] pg: 1 (pg 값을 제대로 가져오는지 디버깅용으로 확인)
		
	    // MySQL - 한 페이지당 10개씩 영화 데이터를 가져옵니다.
	    int endNum = 10; // 한 페이지에 표시할 영화의 개수를 10으로 설정
	    int startNum = pg * 10 - 10; // 시작 위치는 0부터 시작. 페이지 번호에 따라 데이터의 시작 위치 계산
	                                // 예: 1페이지는 0부터 시작, 2페이지는 10부터 시작, 3페이지는 20부터 시작

	    // 2. DB와의 상호작용
	    MovieDAO movieDAO = MovieDAO.getInstance(); // MovieDAO의 싱글톤 인스턴스를 가져옴
	    List<MovieDTO> list = movieDAO.movieList(startNum, endNum); // startNum부터 endNum까지의 영화 리스트를 가져옴
	    int totalA = movieDAO.getTotalA(); // 전체 영화의 개수를 가져옴
	    
	    // 페이징 처리를 위한 MoviePaging 객체 설정
	    MoviePaging moviePaging = new MoviePaging(); // 페이징 처리를 담당할 객체 생성
	    moviePaging.setCurrentPage(pg); // 현재 페이지 번호 설정
	    moviePaging.setPageBlock(5); // 한 번에 보여줄 페이지 블록 수를 5로 설정 (예: [이전] 1 2 3 4 5 [다음])
	    moviePaging.setPageSize(10); // 한 페이지에 보여줄 영화 개수 설정
	    moviePaging.setTotalA(totalA); // 전체 영화 개수 설정
	    moviePaging.makePagingHTML(); // 페이징 HTML을 생성하여 MoviePaging 객체에 저장
		
	    // 3. Response 처리
	    // JSP로 넘겨줄 데이터를 request 객체에 저장
	    request.setAttribute("pg", pg); // 현재 페이지 번호를 request에 저장
	    request.setAttribute("list", list); // 영화 리스트를 request에 저장
	    request.setAttribute("moviePaging", moviePaging); // 페이징 정보를 request에 저장
	    
	    // /admin/movieList.jsp로 포워딩하여 영화 목록 페이지로 이동
		return "/admin/movieList.jsp";
	}

}
