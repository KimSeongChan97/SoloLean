package imageboard.service;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class UpdateFileService implements CommandProcess {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String realFolder = request.getServletContext().getRealPath("/storage");

        MultipartRequest multi = new MultipartRequest(request, realFolder, 5 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());

        int seq = Integer.parseInt(multi.getParameter("seq"));
        String newImage = multi.getFilesystemName("image1");

        ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
        ImageboardDTO imageboardDTO = imageboardDAO.getImageboardBySeq(seq);

        NCPObjectStorageService ncpService = new NCPObjectStorageService();

        // 기존 파일 삭제
        if (imageboardDTO.getImage1() != null) {
            String oldFileName = imageboardDTO.getImage1().substring(imageboardDTO.getImage1().lastIndexOf("/") + 1);
            ncpService.deleteFile(oldFileName);
        }

        // 새 파일 업로드
        if (newImage != null) {
            String newImageUrl = ncpService.uploadFile(new File(realFolder, newImage));
            imageboardDTO.setImage1(newImageUrl);
        }

        // 다른 필드들도 업데이트
        imageboardDTO.setImageId(multi.getParameter("imageId"));
        imageboardDTO.setImageName(multi.getParameter("imageName"));
        imageboardDTO.setImagePrice(Integer.parseInt(multi.getParameter("imagePrice")));
        imageboardDTO.setImageQty(Integer.parseInt(multi.getParameter("imageQty")));
        imageboardDTO.setImageContent(multi.getParameter("imageContent"));

        // 이미지 정보 업데이트
        imageboardDAO.updateImage(imageboardDTO);

        // 수정 성공 메시지를 request에 추가
        request.setAttribute("message", "이미지가 성공적으로 수정되었습니다.");

        // 수정 후 현재 페이지로 리다이렉트
        return "redirect:/imageboard/imageboardList.do?pg=" + multi.getParameter("pg");
    }
}