// FilmNote/src/main/java/movie.service.MovieWriteDBService.java
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
	private String bucketName = "filmnote-bucket-116";

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 실제 폴더
		String realFolder = request.getServletContext().getRealPath("/storage");	
		
		System.out.println("realFolder : " + realFolder);
		// D:\Web\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\FilmNote\storage
		
		// 업로드 디버깅
		System.out.println("Before MultipartRequest initialization");
		
	    MultipartRequest multi = new MultipartRequest(
		        request, 
		        realFolder, // 이미지 저장되는 위치
		        5 * 1024 * 1024, // 5MB
		        "UTF-8",
		        new DefaultFileRenamePolicy() // 같은 이름이 업로드되면 파일명 변경
		    );
	    System.out.println("MultipartRequest initialized successfully" + multi);
		    
		    
	    // 1. Data 받기
	    String movieTitle = multi.getParameter("movieTitle");
	    String movieDirector = multi.getParameter("movieDirector");
	    String movieGenre = multi.getParameter("movieGenre");
	    String movieReleaseDate = multi.getParameter("movieReleaseDate");
	    int movieRating = Integer.parseInt(multi.getParameter("movieRating"));
	    float movieScore = Float.parseFloat(multi.getParameter("movieScore"));
	    String movieSynopsis = multi.getParameter("movieSynopsis");
	    
        /** 포스터 처리 */
        String moviePoster = multi.getFilesystemName("moviePoster");
        // 파일 객체 생성 (파일의 이름만 알고 있기 때문)
        File file = new File(realFolder, moviePoster);
	    
	    // Object Storage (NCP)에 새로운 이미지 업로드
        NCPObjectStorageService ncp = new NCPObjectStorageService();
        String uploadedFileName = ncp.uploadFile(bucketName, "storage/", file); // UUID 쓰려면 moviePoster 에 랜덤 생성된 이름을 덮어씌워 줘야함
        String moviePosterURL = "https://kr.object.ncloudstorage.com/filmnote-bucket-116/storage/" + uploadedFileName;
   
	    
	    System.out.println("moviePosterURL" + " : " + moviePosterURL);
		
		
	    // 2. DB
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setTitle(movieTitle);
        movieDTO.setDirector(movieDirector);
        movieDTO.setGenre(movieGenre);
        movieDTO.setRelease_date(movieReleaseDate);
        movieDTO.setRating(movieRating);
        movieDTO.setScore(movieScore);
        movieDTO.setSynopsis(movieSynopsis);
        movieDTO.setPoster(moviePosterURL);
        
	    // DB poster 컬럼에는 Object Storage filmnote bucket 의 file link (이미지 파일 링크) 가 들어가야함
	    
	    // movie_tb 에 영화 정보를 insert 하기 전에
	    // NCPObjectStorageService.java 의 코드로 fitlmnote-bucket-116 Object Storage 에 사진을 먼저 올려야함
	    // 이미지 url Object Storage 에서 받아오기 
	    // 이미지 파일 링크 : "https://kr.object.ncloudstorage.com/bitcamp-9th-bucket-116/storage/" + "NCPObjectStorageService.java에서 UUID 로 랜덤 생성된 fileName"
	    
        MovieDAO movieDAO = MovieDAO.getInstance();
        movieDAO.writeMovie(movieDTO);
	    
		return "none";
	}
}
