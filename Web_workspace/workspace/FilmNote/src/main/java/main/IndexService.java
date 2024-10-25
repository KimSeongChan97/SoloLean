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

        // 영화 목록 데이터를 가져오기 위해 IndexDAO의 getMovieBoardList() 메서드를 호출
        List<MovieDTO> movieDTOList = IndexDAO.getInstance().getMovieBoardList();

        // 한 행에 출력될 영화의 수를 정의
        int movieInRowCount = 4; // 1행에 4개의 영화 출력
        // 전체 영화 목록에서 몇 개의 행을 출력할 것인지 계산
        int rowCount = movieDTOList.size() / movieInRowCount; // 행의 개수는 영화 개수를 4로 나눈 몫

        // 영화 개수가 4로 나누어 떨어지지 않을 경우, 마지막 행에 남는 영화들이 있으므로 추가 행을 계산
        if (movieDTOList.size() % 4 != 0) rowCount++; // 나머지가 있을 경우 행을 하나 더 추가

        // request 객체에 영화 목록, 한 행당 영화 개수, 전체 행 개수를 저장하여 JSP로 전달
        request.setAttribute("movieDTOList", movieDTOList); // 영화 목록
        request.setAttribute("movieInRowCount", movieInRowCount); // 1행에 출력될 영화 수
        request.setAttribute("rowCount", rowCount); // 전체 행 개수

        // "/index.jsp" 페이지로 포워딩
        return "/index.jsp";
    }
}
