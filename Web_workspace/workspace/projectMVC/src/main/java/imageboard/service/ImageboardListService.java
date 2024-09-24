package imageboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.bean.ImageboardDTO;
import imageboard.bean.ImageboardPaging;
import imageboard.dao.ImageboardDAO;

public class ImageboardListService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
    	// 데이터
        int pg = 1;
        // **추가 설명**: 요청 파라미터로 넘어온 "pg" 값(페이지 번호)을 받아옵니다. 
        // 이 값이 null이 아닐 경우에만 해당 값을 정수로 변환하여 페이지 번호로 사용하고, 
        // 그렇지 않으면 기본값으로 1을 사용하여 첫 페이지를 의미합니다.
		if(request.getParameter("pg") != null) pg = Integer.parseInt(request.getParameter("pg"));
		// **추가 설명**: request.getParameter() 메서드를 통해 사용자가 전달한 "pg" 파라미터 값을 가져옵니다. 
		// 이 파라미터는 사용자가 보고 싶은 페이지 번호를 의미하며, null이면 기본적으로 첫 페이지인 1로 설정됩니다.
		
		// Oracle
        // 1페이지당 3개씩
        //int endNum = pg * 3;
        // **추가 설명**: 현재 페이지 번호(pg)에 따라 마지막 항목 번호(endNum)를 계산합니다. 
        // 예를 들어, 1페이지라면 3개의 항목을 가져오므로 3이 됩니다. 2페이지라면 6이 됩니다.
        //int startNum = endNum - 2;
        // **추가 설명**: 시작 항목 번호(startNum)를 계산합니다. 각 페이지는 3개의 항목을 포함하므로, 
        // 첫 번째 페이지의 시작 번호는 1, 두 번째 페이지는 4, 세 번째 페이지는 7이 됩니다. 
        // 따라서 마지막 항목 번호에서 2를 뺀 값이 시작 번호가 됩니다.
        
		// MySQL
		int endNum = 3;
		int startNum = pg * endNum - endNum;
		
        //DB
        Map<String, Integer> map = new HashMap<>();
        map.put("startNum",  startNum);
        map.put("endNum",  endNum);
        // **추가 설명**: 시작 번호와 끝 번호를 Map에 담아 데이터베이스 쿼리로 전달합니다. 
        // MyBatis 쿼리에서 이 맵에 담긴 값들을 활용하여 특정 범위의 데이터를 조회할 수 있게 됩니다.
        
        ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
        // **추가 설명**: ImageboardDAO의 인스턴스를 싱글톤 패턴으로 가져옵니다. DAO는 데이터베이스와의 상호작용을 담당하는 클래스입니다.
        List<ImageboardDTO> list = imageboardDAO.imageboardList(map);
        // **추가 설명**: DAO의 imageboardList() 메서드를 호출하여, 시작 번호와 끝 번호에 해당하는 데이터를 조회합니다. 
        // 이 메서드는 조회된 ImageboardDTO 객체들의 리스트를 반환합니다.

        // 페이징 처리
        int totalA = imageboardDAO.getTotalA();
        // **추가 설명**: 전체 데이터의 개수를 가져오기 위해 DAO의 getTotalA() 메서드를 호출합니다. 
        // 전체 데이터 개수는 페이징 처리를 위한 중요한 정보입니다.

        ImageboardPaging imageboardPaging = new ImageboardPaging();
        imageboardPaging.setCurrentPage(pg);
        imageboardPaging.setPageBlock(3);
        imageboardPaging.setPageSize(3);
        imageboardPaging.setTotalA(totalA);
        // **추가 설명**: 페이징 처리를 위한 ImageboardPaging 객체를 생성하고, 
        // 현재 페이지, 한 번에 보여줄 페이지 수(PageBlock), 한 페이지당 게시물 수(PageSize), 전체 게시물 수(TotalA)를 설정합니다. 
        // 이 정보를 바탕으로 페이징 처리 로직을 수행합니다.

        imageboardPaging.makePagingHTML();
        // **추가 설명**: 페이지 HTML을 생성합니다. 
        // 이 메서드는 설정된 페이징 정보를 바탕으로 다음 페이지, 이전 페이지 등의 링크가 포함된 HTML 코드를 생성합니다.

        request.setAttribute("pg", pg);
        request.setAttribute("list", list);
        request.setAttribute("imageboardPaging", imageboardPaging);
        // **추가 설명**: JSP 페이지로 넘겨줄 데이터를 request 객체에 저장합니다. 
        // "pg"는 현재 페이지 번호, "list"는 현재 페이지에 해당하는 게시물 리스트, 
        // "imageboardPaging"은 페이징 처리를 위한 정보를 담고 있습니다.
        
        // forward
        return "/imageboard/imageboardList.jsp";
        // **추가 설명**: "/imageboard/imageboardList.jsp"로 포워딩하여, 
        // 요청에 대한 응답으로 해당 JSP 페이지를 클라이언트에게 보여줍니다. 
        // JSP 페이지에서는 앞서 설정한 request 속성들을 사용하여 데이터를 출력합니다.
    }
}
