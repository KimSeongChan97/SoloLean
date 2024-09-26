package imageboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.io.File;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;
import imageboard.service.NCPObjectStorageService; // NCP Object Storage 서비스 임포트

public class ImageboardWriteAjaxService implements CommandProcess {
	private String bucketName = "bitcamp-9th-bucket-65"; // NCP Object Storage에서 사용할 버킷 이름을 정의

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 실제 폴더의 값
		// JSP/서블릿 프로젝트에서 실제 서버 상의 파일 저장 경로를 가져오는 부분
		// storage 폴더의 실제 물리적 경로를 가져옴 (예: C:/.../webapp/storage)
		String realFolder = request.getServletContext().getRealPath("/storage");
		System.out.println("realFolder = " + realFolder); // 디버깅을 위한 실제 폴더 경로 출력
		
		//업로드
		// MultipartRequest 객체 생성 (파일 업로드 처리)
		// request: 클라이언트 요청 객체 (폼 데이터 포함)
		// realFolder: 파일이 저장될 경로
		// 5 * 1024 * 1024: 업로드할 파일 크기 제한 (5MB)
		// "UTF-8": 문자 인코딩 방식
		// DefaultFileRenamePolicy: 파일명이 중복될 경우 자동으로 다른 이름을 부여 (파일명 중복 방지)
		MultipartRequest multi = new MultipartRequest(
				request,
				realFolder, //이미지가 저장되는 위치
				5 * 1024 * 1024, //5MB
				"UTF-8",
				new DefaultFileRenamePolicy()); //똑같은 이름이 업로드되면 파일명을 변경해서 올린다.

		// 업로드된 파일 이외의 일반 데이터 처리
		// 클라이언트에서 전송된 폼 데이터로부터 필요한 값을 가져오는 부분
		String imageId = multi.getParameter("imageId"); // 이미지 게시물의 고유 ID
		String imageName = multi.getParameter("imageName"); // 이미지의 이름
		int imagePrice = Integer.parseInt(multi.getParameter("imagePrice")); // 이미지 가격 (String을 int로 변환)
		int imageQty = Integer.parseInt(multi.getParameter("imageQty")); // 이미지 수량 (String을 int로 변환)
		String imageContent = multi.getParameter("imageContent"); // 이미지 설명
		String image1 = multi.getOriginalFileName("image1"); // 사용자가 업로드한 파일의 원본 파일명
		String fileName = multi.getFilesystemName("image1"); // 실제 서버에 저장된 파일명 (중복 시 변경된 이름)
		
		// System.out.println(image1 + ", " + fileName); // 디버깅용 출력 코드
		
		// 파일 객체 생성
		// 실제 저장 경로와 파일명을 바탕으로 File 객체를 생성함 (파일 경로와 이름을 포함한 객체)
		File file = new File(realFolder, image1);
		
		// Object Storage(NCP)의 새로운 이미지 올리기
		// NCPObjectStorageService는 NCP Object Storage에 파일을 업로드하는 기능을 담당
		// bucketName: Object Storage에서 사용할 버킷 이름
		// "storage/": 버킷 내의 경로 (폴더와 유사한 개념)
		// file: 실제 업로드할 파일 객체
		NCPObjectStorageService ncp = new NCPObjectStorageService();
		image1 = ncp.uploadFile(bucketName, "storage/", file); // 업로드 후 반환된 파일명 (URL 또는 Object Name)

		// ImageboardDTO 객체 생성 후, 업로드된 데이터 저장
		// DTO(Data Transfer Object)는 데이터 전송을 위한 객체로, 각 변수에 값을 설정하여 DAO에 전달
		ImageboardDTO imageboardDTO = new ImageboardDTO();
		imageboardDTO.setImageId(imageId); // 이미지 ID 설정
		imageboardDTO.setImageName(imageName); // 이미지 이름 설정
		imageboardDTO.setImagePrice(imagePrice); // 이미지 가격 설정
		imageboardDTO.setImageQty(imageQty); // 이미지 수량 설정
		imageboardDTO.setImageContent(imageContent); // 이미지 설명 설정
		imageboardDTO.setImage1(image1); // 파일명만 DB에 저장 (Object Storage에 파일은 저장됐으므로 DB엔 파일명만 필요)

		// ImageboardDAO를 통해 DB에 데이터를 저장
		// DAO(Data Access Object)는 DB 작업을 처리하는 객체로, imageboardWrite 메소드를 통해 데이터를 삽입
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance(); // 싱글턴 패턴으로 DAO 인스턴스 얻기
		imageboardDAO.imageboardWrite(imageboardDTO); // DTO를 사용해 DB에 데이터 저장
		
		// Ajax 호출 후 화면에 보여줄 내용이 없을 때는 "none"을 리턴
		return "none"; // Ajax 호출 후 특별히 반환할 데이터가 없을 때
	}
}
