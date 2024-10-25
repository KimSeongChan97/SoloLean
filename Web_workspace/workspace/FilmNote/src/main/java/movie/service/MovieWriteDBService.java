package movie.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import movie.bean.MovieDTO;
import movie.dao.MovieDAO;

public class MovieWriteDBService implements CommandProcess {
	private String bucketName = "filmnote-bucket-116"; // NCP Object Storage의 bucket 이름
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 실제 서버에 저장될 파일 경로를 가져옴
		String realFolder = request.getServletContext().getRealPath("/storage");	
		
		System.out.println("realFolder : " + realFolder);
		// 예시: D:\Web\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\FilmNote\storage
		
		// MultipartRequest 객체를 이용하여 업로드된 파일 처리
	    MultipartRequest multi = new MultipartRequest(
		        request, 
		        realFolder, // 이미지가 저장될 서버 경로
		        5 * 1024 * 1024, // 파일 최대 업로드 용량 5MB 설정
		        "UTF-8", // 인코딩 방식 설정
		        new DefaultFileRenamePolicy() // 중복 파일명을 처리할 정책
		    );
	    System.out.println("MultipartRequest initialized successfully: " + multi);
		    
	    // 1. Data 받기 - 업로드 폼에서 입력받은 영화 정보를 받아옴
	    String movieTitle = multi.getParameter("movieTitle");
	    String movieDirector = multi.getParameter("movieDirector");
	    String movieGenre = multi.getParameter("movieGenre");
	    String movieReleaseDate = multi.getParameter("movieReleaseDate");
	    int movieRating = Integer.parseInt(multi.getParameter("movieRating"));
	    float movieScore = Float.parseFloat(multi.getParameter("movieScore"));
	    String movieSynopsis = multi.getParameter("movieSynopsis");
	    
        /** 포스터 이미지 처리 */
        String moviePoster = multi.getFilesystemName("moviePoster"); // 업로드된 포스터 파일명 가져옴
        // 파일 객체 생성 (실제 파일 경로와 파일명을 결합하여 생성)
        File file = new File(realFolder, moviePoster);
	    
	    // NCP Object Storage에 포스터 파일을 업로드
        NCPObjectStorageService ncp = new NCPObjectStorageService(); // Object Storage 사용을 위한 서비스 클래스 생성
        String uploadedFileName = ncp.uploadFile(bucketName, "storage/", file); // 파일을 NCP에 업로드하고 랜덤으로 생성된 파일명 반환
        String moviePosterURL = "https://kr.object.ncloudstorage.com/filmnote-bucket-116/storage/" + uploadedFileName; // 완성된 파일 URL
        
	    System.out.println("moviePosterURL: " + moviePosterURL); // 업로드된 이미지 파일의 최종 URL 출력
		
	    // 2. DB에 데이터 저장
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setTitle(movieTitle); // 영화 제목 설정
        movieDTO.setDirector(movieDirector); // 영화 감독 설정
        movieDTO.setGenre(movieGenre); // 영화 장르 설정
        movieDTO.setRelease_date(movieReleaseDate); // 개봉일 설정
        movieDTO.setRating(movieRating); // 영화 등급 설정
        movieDTO.setScore(movieScore); // 영화 평점 설정
        movieDTO.setSynopsis(movieSynopsis); // 영화 줄거리 설정
        movieDTO.setPoster(moviePosterURL); // NCP에 저장된 포스터 URL 설정
        
        // MovieDAO를 사용하여 DB에 영화 데이터를 저장
        MovieDAO movieDAO = MovieDAO.getInstance();
        movieDAO.writeMovie(movieDTO); // DB에 영화 정보 저장
	    
		return "none"; // 결과 페이지로 이동하지 않도록 처리
	}
}

