package imageboard.service;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class ImageboardWriteService implements CommandProcess {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String realFolder = request.getServletContext().getRealPath("/storage");

        MultipartRequest multi = new MultipartRequest(request, realFolder, 5 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());

        String imageId = multi.getParameter("imageId");
        String imageName = multi.getParameter("imageName");
        int imagePrice = Integer.parseInt(multi.getParameter("imagePrice"));
        int imageQty = Integer.parseInt(multi.getParameter("imageQty"));
        String imageContent = multi.getParameter("imageContent");
        String image1 = multi.getFilesystemName("image1");

        NCPObjectStorageService ncpService = new NCPObjectStorageService();
        String imageUrl = ncpService.uploadFile(new File(realFolder, image1));

        ImageboardDTO imageboardDTO = new ImageboardDTO();
        imageboardDTO.setImageId(imageId);
        imageboardDTO.setImageName(imageName);
        imageboardDTO.setImagePrice(imagePrice);
        imageboardDTO.setImageQty(imageQty);
        imageboardDTO.setImageContent(imageContent);
        imageboardDTO.setImage1(imageUrl);

        ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
        imageboardDAO.imageboardWrite(imageboardDTO);

        return "redirect:/imageboard/imageboardList.do?pg=1";
    }
}