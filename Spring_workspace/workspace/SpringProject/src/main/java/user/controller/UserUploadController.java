package user.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserUploadDTO;
import user.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserUploadController {
	
	@RequestMapping(value="uploadForm")
	public String uploadForm() {
		return "/upload/uploadForm";
	}
	
	@RequestMapping(value="uploadAJaxForm")
	public String uploadAJaxForm() {
		return "/upload/uploadAJaxForm";
	}
	
	@RequestMapping(value="uploadList")
	public String uploadList() {
		return "/upload/uploadList";
	}
	
	// 1개의 데이터를 업로드 할 때
	/*
	@RequestMapping(value="upload", method=RequestMethod.POST)
	@ResponseBody
	public String upload(@ModelAttribute UserUploadDTO userUploadDTO,
						 @RequestParam MultipartFile img,
						 HttpSession session) {
		// 실제 폴더
		// String filePath = 세션
		String filePath = session.getServletContext().getRealPath("WEB-INF/storage");
		System.out.println("실제 폴더 = " + filePath);
		// D:\Spring\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringProject\WEB-INF\storage
		String imageOriginalFileName;
		File file;
		
		imageOriginalFileName = img.getOriginalFilename();
		
		file = new File(filePath, imageOriginalFileName);
		
		try {
			img.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String result = "<span>"
						+ "<img src='/spring/storage/" + imageOriginalFileName + "' width='200' height='200'>"
						+ "</span>";
		// url : '/spring/storage/' 은 가상의 위치이다.

		System.out.println(userUploadDTO.getImageName() + ", "
							+ userUploadDTO.getImageContent() + ", "
							+ userUploadDTO.getImageFileName() + ", "
							+ userUploadDTO.getImageOriginalFileName());
		userUploadDTO.setImageOriginalFileName(imageOriginalFileName);

		//"/upload/uploadForm"
		return result;
	}
	*/
	
	/*
	// 2개 이상의 데이터를 업로드할 때
	@RequestMapping(value="upload", method=RequestMethod.POST)
	@ResponseBody
	public String upload(@ModelAttribute UserUploadDTO userUploadDTO,
						 @RequestParam MultipartFile[] img,
						 HttpSession session) {
		// 실제 폴더
		// String filePath = 세션
		String filePath = session.getServletContext().getRealPath("WEB-INF/storage");
		System.out.println("실제 폴더 = " + filePath);
		// D:\Spring\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringProject\WEB-INF\storage
		String imageOriginalFileName;
		File file;
		String result;
		
		// --------------------------------------
		imageOriginalFileName = img[0].getOriginalFilename();
		file = new File(filePath, imageOriginalFileName);
		
		try {
			img[0].transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		result = "<span>"
						+ "<img src='/spring/storage/" + imageOriginalFileName + "' width='200' height='200'>"
						+ "</span>";
		// --------------------------------------
		imageOriginalFileName = img[1].getOriginalFilename();
		file = new File(filePath, imageOriginalFileName);
		
		try {
			img[1].transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		result += "<span>"
			   + "<img src='/spring/storage/" + imageOriginalFileName + "' width='200' height='200'>"
			   + "</span>";
		// --------------------------------------
		// url : '/spring/storage/' 은 가상의 위치이다.

		System.out.println(userUploadDTO.getImageName() + ", "
							+ userUploadDTO.getImageContent() + ", "
							+ userUploadDTO.getImageFileName() + ", "
							+ userUploadDTO.getImageOriginalFileName());
		userUploadDTO.setImageOriginalFileName(imageOriginalFileName);
		
		//"/upload/uploadForm"
		return result;
	}
	*/
	
	// 1개 또는 여러개(드래그)
	// 파일명에 한글 또는 공백이 있어도 업로드가 가능하다. ( produces = "text/html; charset=UTF-8" )
	@RequestMapping(value="upload", method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String upload(@ModelAttribute UserUploadDTO userUploadDTO,
						 @RequestParam("img[]") List<MultipartFile> list,
						 HttpSession session) {
		// 실제 폴더
		// String filePath = 세션
		String filePath = session.getServletContext().getRealPath("WEB-INF/storage");
		System.out.println("실제 폴더 = " + filePath);
		// D:\Spring\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringProject\WEB-INF\storage
		String imageOriginalFileName;
		File file;
		String result = "";
		
		// 파일들을 모아서 DB로 보내기
		List<UserUploadDTO> imageUploadList = new ArrayList<>();

			for (MultipartFile img : list) {
				imageOriginalFileName = img.getOriginalFilename();
				file = new File(filePath, imageOriginalFileName);
				
				try {
					img.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
//					try {
						result += "<span>"
								+ "<img src='/spring/storage/"
								//+ URLEncoder.encode(imageOriginalFileName, "UTF-8") => 파일명에 공백이 있으면 안된다.
								+ imageOriginalFileName
								+ "' width='200' height='200'>"
								+ "</span>";
//					} catch (UnsupportedEncodingException e) {
//						e.printStackTrace();
//					}
					// url : '/spring/storage/' 은 가상의 위치이다.
				
				UserUploadDTO dto = new UserUploadDTO();
				dto.setImageName(userUploadDTO.getImageName());
				dto.setImageContent(userUploadDTO.getImageContent());
				dto.setImageFileName("");
				dto.setImageOriginalFileName(imageOriginalFileName);
				
				imageUploadList.add(dto);
				
			} // for
			
			// DB 로 저장 !
			
			
			System.out.println(userUploadDTO.getImageName() + ", "
					+ userUploadDTO.getImageContent() + ", "
					+ userUploadDTO.getImageFileName() + ", "
					+ userUploadDTO.getImageOriginalFileName());
		
		return result;
	}
	
	
}

/*
@ResponseBody ?
 
 
 */
