// FilmNote/src/main/java/movie.service.MovieEditDBService.java
package movie.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import movie.bean.MovieDTO;
import movie.dao.MovieDAO;

public class MovieEditDBService implements CommandProcess {
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
	    
	    // 1. Data 받기
	    int mcode = Integer.parseInt(multi.getParameter("mcode")); 
	    int pg = Integer.parseInt(multi.getParameter("pg"));   	
	    String movieTitle = multi.getParameter("movieTitle");
	    String movieDirector = multi.getParameter("movieDirector");
	    String movieGenre = multi.getParameter("movieGenre");
	    String movieReleaseDate = multi.getParameter("movieReleaseDate");
	    int movieRating = Integer.parseInt(multi.getParameter("movieRating"));
	    float movieScore = Float.parseFloat(multi.getParameter("movieScore"));
	    String movieSynopsis = multi.getParameter("movieSynopsis");		
	    
	    System.out.println("MultipartRequest initialized successfully" + multi);
	    
		System.out.print("MovieEditDBService.java mcode : ");
		System.out.println(multi.getParameter("mcode"));
		
        /** 포스터 파일 처리 */
        String moviePoster = multi.getFilesystemName("moviePoster");
        // 파일 객체 생성 (파일의 이름만 알고 있기 때문)
        File file = new File(realFolder, moviePoster);
	    
	    // Object Storage(NCP) 설정
        NCPObjectStorageService ncp = new NCPObjectStorageService();
		
		
	    // 2. DB 에서 기존 영화 정보 가져오기
        MovieDAO movieDAO = MovieDAO.getInstance();
        MovieDTO movieDTO = movieDAO.getMovie(mcode);
        
        // movie_tb poster 컬럼에 url 이 있을 떄
        if (movieDTO.getPoster() != null && !movieDTO.getPoster().isEmpty()) {
    		String posterUrl = movieDTO.getPoster(); // 포스터 URL 가져오기
    		String uuid = posterUrl.substring(posterUrl.lastIndexOf("/") + 1); // UUID 추출
    		System.out.println("Updating file with UUID: " + uuid);
    		
    		// Object Storaged 에 포스터 url 이 있을 때
    		if (uuid != null && !uuid.isEmpty()) { 
    			ncp.deleteFile(uuid); // UUID로 Object Storage에서 파일 삭제 (삭제 후 업로드 해야함)
    			System.out.println("Object Storage에서 삭제된 포스터 uuid : " + uuid);
    		}
    	}
        	
        // movie_tb poster 컬럼에 poster url 이 없을 때
        // Object Storage에 poster url 이 없을 때 (Object Strage 에 있을 땐 삭제 후)
        
		// Object Storage (NCP)에 새로운 이미지 업로드
        String uploadedFileName = ncp.uploadFile(bucketName, "storage/", file); // UUID 쓰려면 moviePoster 에 랜덤 생성된 이름을 덮어씌워 줘야함
        String moviePosterURL = "https://kr.object.ncloudstorage.com/filmnote-bucket-116/storage/" + uploadedFileName;
        System.out.println("생성된 moviePosterURL" + " : " + moviePosterURL);
        
        // 3. movieDTO 수정된 내용 담기
        movieDTO.setTitle(movieTitle);
        movieDTO.setDirector(movieDirector);
        movieDTO.setGenre(movieGenre);
        movieDTO.setRelease_date(movieReleaseDate);
        movieDTO.setRating(movieRating);
        movieDTO.setScore(movieScore);
        movieDTO.setSynopsis(movieSynopsis);
        movieDTO.setPoster(moviePosterURL);
        
        // 4. DB 업데이트
        movieDAO.updateMovie(movieDTO);
		
		
		return "none";
	}

}
