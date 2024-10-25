package imageboard.service;

import com.control.CommandProcess;
import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class ImageboardDeleteService implements CommandProcess {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String[] seqs = request.getParameterValues("selectedSeq");
        
        if (seqs != null) {
            List<Integer> seqList = Arrays.stream(seqs).map(Integer::parseInt).toList();
            
            ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
            NCPObjectStorageService ncpService = new NCPObjectStorageService();

            for (Integer seq : seqList) {
                ImageboardDTO imageboardDTO = imageboardDAO.getImageboardBySeq(seq);
                if (imageboardDTO != null && imageboardDTO.getImage1() != null) {
                    String fileName = imageboardDTO.getImage1().substring(imageboardDTO.getImage1().lastIndexOf("/") + 1);
                    ncpService.deleteFile(fileName);
                }
            }
            imageboardDAO.deleteImages(seqList);
        }

        response.setContentType("application/json");
        response.getWriter().write("{\"success\": true}");
        return "none";
    }
}