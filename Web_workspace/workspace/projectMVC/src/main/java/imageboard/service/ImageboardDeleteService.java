package imageboard.service;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.dao.ImageboardDAO;

public class ImageboardDeleteService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        // 선택된 seq 값들을 받아서 리스트로 변환
        String[] selectedSeq = request.getParameterValues("selectedSeq");
        
        // 디버깅 코드: selectedSeq 값 출력
        System.out.println("selectedSeq: " + Arrays.toString(selectedSeq));
        
        if (selectedSeq != null) {
            List<Integer> seqList = Arrays.asList(selectedSeq).stream()
                                         .map(Integer::parseInt)
                                         .toList();
            
            // DB에서 선택된 항목 삭제
            ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
            imageboardDAO.deleteSelected(seqList);
        }
        
        // 삭제 후 1페이지로 이동
        request.setAttribute("pg", 1);
        return "forward:/projectMVC/imageboard/imageboardList.do";
    }
}
