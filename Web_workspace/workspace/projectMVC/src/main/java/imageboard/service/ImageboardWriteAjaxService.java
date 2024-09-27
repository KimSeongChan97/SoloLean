package imageboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.control.CommandProcess;
import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;
import java.io.File;

public class ImageboardWriteAjaxService implements CommandProcess {
    private NCPObjectStorageService storageService = new NCPObjectStorageService();

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String imageId = request.getParameter("imageId");
        String imageName = request.getParameter("imageName");
        int imagePrice = Integer.parseInt(request.getParameter("imagePrice"));
        int imageQty = Integer.parseInt(request.getParameter("imageQty"));
        String imageContent = request.getParameter("imageContent");

        Part filePart = request.getPart("image1");
        File tempFile = File.createTempFile("upload", ".tmp");
        filePart.write(tempFile.getAbsolutePath());
        String fileUrl = storageService.uploadFile(tempFile);

        ImageboardDTO imageboardDTO = new ImageboardDTO();
        imageboardDTO.setImageId(imageId);
        imageboardDTO.setImageName(imageName);
        imageboardDTO.setImagePrice(imagePrice);
        imageboardDTO.setImageQty(imageQty);
        imageboardDTO.setImageContent(imageContent);
        imageboardDTO.setImage1(fileUrl);

        ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
        imageboardDAO.imageboardWrite(imageboardDTO);

        response.setContentType("application/json");
        response.getWriter().write("{\"success\": true, \"fileUrl\": \"" + fileUrl + "\"}");

        return "none";
    }
}