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
	private String bucketName = "filmnote-bucket-116"; // NCP Object Storage 버킷 이름
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 실제 서버 내 저장 경로 지정 (실제 파일이 저장되는 폴더)
		String realFolder = request.getServletContext().getRealPath("/storage");	
		
		System.out.println("realFolder : " + realFolder); // 실제 경로 출력
		// 예시 출력: D:\Web\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\FilmNote\storage
		
		// 업로드 처리 전, 디버깅용 메시지 출력
		System.out.println("Before MultipartRequest initialization");
		
	    MultipartRequest multi = new MultipartRequest(
		        request, 
		        realFolder, // 이미지가 저장될 위치
		        5 * 1024 * 1024, // 최대 파일 크기: 5MB
		        "UTF-8",
		        new DefaultFileRenamePolicy() // 동일한 파일 이름이 있을 경우 자동으로 이름 변경
	    );
	    
	    // 1. Data 받기
	    int mcode = Integer.parseInt(multi.getParameter("mcode")); // 영화 코드
	    int pg = Integer.parseInt(multi.getParameter("pg"));   	// 페이지 번호
	    String movieTitle = multi.getParameter("movieTitle"); // 영화 제목
	    String movieDirector = multi.getParameter("movieDirector"); // 감독
	    String movieGenre = multi.getParameter("movieGenre"); // 장르
	    String movieReleaseDate = multi.getParameter("movieReleaseDate"); // 개봉일
	    int movieRating = Integer.parseInt(multi.getParameter("movieRating")); // 영화 등급
	    float movieScore = Float.parseFloat(multi.getParameter("movieScore")); // 평점
	    String movieSynopsis = multi.getParameter("movieSynopsis"); // 줄거리
	    
	    System.out.println("MultipartRequest initialized successfully" + multi);
	    
		System.out.print("MovieEditDBService.java mcode : ");
		System.out.println(multi.getParameter("mcode")); // 영화 코드 확인 출력
		
        /** 포스터 파일 처리 */
        String moviePoster = multi.getFilesystemName("moviePoster"); // 업로드된 파일 이름 추출
        File file = new File(realFolder, moviePoster); // 업로드된 파일 객체 생성
        
	    // NCP Object Storage(Naver Cloud Platform) 설정
        NCPObjectStorageService ncp = new NCPObjectStorageService(); 
		
	    // 2. DB에서 기존 영화 정보 가져오기
        MovieDAO movieDAO = MovieDAO.getInstance();
        MovieDTO movieDTO = movieDAO.getMovie(mcode); // 영화 코드로 해당 영화 정보 가져오기
        
        // 기존 포스터가 존재할 경우 처리
        if (movieDTO.getPoster() != null && !movieDTO.getPoster().isEmpty()) {
    		String posterUrl = movieDTO.getPoster(); // 포스터 URL 가져오기
    		String uuid = posterUrl.substring(posterUrl.lastIndexOf("/") + 1); // UUID 추출
    		System.out.println("Updating file with UUID: " + uuid);
    		
    		// Object Storage에서 해당 포스터 삭제 (기존 포스터 교체)
    		if (uuid != null && !uuid.isEmpty()) { 
    			ncp.deleteFile(uuid); // Object Storage에서 파일 삭제
    			System.out.println("Object Storage에서 삭제된 포스터 uuid : " + uuid);
    		}
    	}
        
        // Object Storage에 새로운 포스터 업로드
		String uploadedFileName = ncp.uploadFile(bucketName, "storage/", file); // NCP에 업로드된 파일 이름
        String moviePosterURL = "https://kr.object.ncloudstorage.com/filmnote-bucket-116/storage/" + uploadedFileName;
        System.out.println("생성된 moviePosterURL" + " : " + moviePosterURL);
        
        // 3. movieDTO 수정된 내용으로 갱신
        movieDTO.setTitle(movieTitle); // 영화 제목 업데이트
        movieDTO.setDirector(movieDirector); // 영화 감독 업데이트
        movieDTO.setGenre(movieGenre); // 영화 장르 업데이트
        movieDTO.setRelease_date(movieReleaseDate); // 개봉일 업데이트
        movieDTO.setRating(movieRating); // 영화 등급 업데이트
        movieDTO.setScore(movieScore); // 평점 업데이트
        movieDTO.setSynopsis(movieSynopsis); // 줄거리 업데이트
        movieDTO.setPoster(moviePosterURL); // 새로운 포스터 URL 저장
        
        // 4. DB 업데이트 실행
        movieDAO.updateMovie(movieDTO); // 영화 정보 업데이트 실행
		
		return "none"; // 화면 전환이 필요 없으므로 'none' 반환
	}

}
