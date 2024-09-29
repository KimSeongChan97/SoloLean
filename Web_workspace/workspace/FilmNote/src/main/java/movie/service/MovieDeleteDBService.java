// FilmNote/src/main/java/movie.service.MovieDeleteDBService.java
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
	   System.out.println("MovieDeleteDBService.java");
      // 1. Data 받기
	  String[] mcodes = request.getParameterValues("mcode");
	  System.out.println("mcodes: " + Arrays.toString(mcodes)); // 배열 값 확인

      
      // 2. DB
//      MovieDTO movieDTO = new MovieDTO();
//      movieDTO.setMcode(mcode);
//      
//      MovieDAO movieDAO = MovieDAO.getInstance();
//      movieDAO.deleteMovie(mcode);
      
      
      if (mcodes != null && mcodes.length > 0) {
          MovieDAO movieDAO = MovieDAO.getInstance();
          
          // 각 mcode 에 대해 영화 정보를 가져와서 UUID를 가져오기
          for (String mcode : mcodes) {
              // mcode를 int로 변환
              int mcodeInt = Integer.parseInt(mcode);
              
              // 해당 mcode 로 MovieDTO 객체를 가져옴
              MovieDTO movieDTO = movieDAO.getMovie(mcodeInt); // mcode 로 영화 정보 조회
              if (movieDTO != null && movieDTO.getPoster() != null) {
                  String posterUrl = movieDTO.getPoster(); // 포스터 URL 가져오기
                  String uuid = posterUrl.substring(posterUrl.lastIndexOf("/") + 1); // UUID 추출
                  System.out.println("Deleting file with UUID: " + uuid);
                  
                  // 이미지 파일 삭제
                  NCPObjectStorageService ncp = new NCPObjectStorageService();
                  ncp.deleteFile(uuid); // UUID로 Object Storage에서 파일 삭제
              }
          }         
          
          // DB에서 영화 삭제
          movieDAO.deleteMovies(mcodes);
      }
      
      
      return "none";
   }

}
