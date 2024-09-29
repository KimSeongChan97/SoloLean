package movie.service;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import movie.bean.MovieDTO;
import movie.dao.MovieDAO;

public class MovieDeleteDBService implements CommandProcess {

   @Override
   public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
       // 요청 처리에 대한 로그 출력
	   System.out.println("MovieDeleteDBService.java");

      // 1. Data 받기: 삭제할 영화의 mcode(영화 코드) 배열을 받아옴
	  String[] mcodes = request.getParameterValues("mcode");
	  System.out.println("mcodes: " + Arrays.toString(mcodes)); // 삭제할 영화 코드 배열 값 출력

      // 2. 데이터 유효성 체크 후, DB에서 삭제 작업 수행
      if (mcodes != null && mcodes.length > 0) {
          // MovieDAO 인스턴스 가져오기
          MovieDAO movieDAO = MovieDAO.getInstance();
          
          // 각 mcode에 대해 영화 정보를 가져오고, 포스터 이미지 삭제 처리
          for (String mcode : mcodes) {
              // mcode를 String에서 int로 변환
              int mcodeInt = Integer.parseInt(mcode);
              
              // 해당 mcode로 영화 정보(MovieDTO) 조회
              MovieDTO movieDTO = movieDAO.getMovie(mcodeInt); // mcode로 영화 데이터 가져옴
              
              // 영화 정보가 존재하고, 포스터 이미지가 있을 경우
              if (movieDTO != null && movieDTO.getPoster() != null) {
                  // 포스터 URL에서 UUID(파일 고유 이름) 추출
                  String posterUrl = movieDTO.getPoster(); // 포스터 URL
                  String uuid = posterUrl.substring(posterUrl.lastIndexOf("/") + 1); // UUID 추출
                  
                  // 로그 출력: 삭제할 파일의 UUID 출력
                  System.out.println("Deleting file with UUID: " + uuid);
                  
                  // NCPObjectStorageService를 통해 포스터 파일 삭제
                  NCPObjectStorageService ncp = new NCPObjectStorageService();
                  ncp.deleteFile(uuid); // UUID로 Object Storage에서 파일 삭제
              }
          }         

          // DB에서 영화 데이터 삭제 (영화 코드 배열로 삭제)
          movieDAO.deleteMovies(mcodes);
      }
      
      // View 페이지로의 이동을 하지 않기 때문에 'none' 반환
      return "none";
   }

}
