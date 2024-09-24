package imageboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;

public class ImageboardWriteAjaxService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 실제 폴더의 값
		String realFolder = request.getServletContext().getRealPath("/storage");
		System.out.println("realFolder = " + realFolder);
		
		//업로드
				/*
				MultipartRequest multi = new MultipartRequest(
						request,
						realFolder,
						5 * 1024 * 1024, //5MB
						"UTF-8");
				*/
				
				MultipartRequest multi = new MultipartRequest(
						request,
						realFolder, //이미지가 저장되는 위치
						5 * 1024 * 1024, //5MB
						"UTF-8",
						new DefaultFileRenamePolicy()); //똑같은 이름이 업로드되면 파일명을 변경해서 올린다.

		
				//데이터
				String imageId = multi.getParameter("imageId");
				String imageName = multi.getParameter("imageName");
				int imagePrice = Integer.parseInt(multi.getParameter("imagePrice"));
				int imageQty = Integer.parseInt(multi.getParameter("imageQty"));
				String imageContent = multi.getParameter("imageContent");
				String image1 = multi.getOriginalFileName("image1");
				String fileName = multi.getFilesystemName("image1");
				
				System.out.println(image1 + ", " + fileName);
				
				ImageboardDTO imageboardDTO = new ImageboardDTO();
				imageboardDTO.setImageId(imageId);
				imageboardDTO.setImageName(imageName);
				imageboardDTO.setImagePrice(imagePrice);
				imageboardDTO.setImageQty(imageQty);
				imageboardDTO.setImageContent(imageContent);
				imageboardDTO.setImage1(image1); //파일명만 DB에 저장
				
				ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
				imageboardDAO.imageboardWrite(imageboardDTO);
				
				// Ajax 호출 후 화면에 보여줄 내용이 없을 때는 "none"을 리턴
				return "none";
	}
	

}
