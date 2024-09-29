// FilmNote/src/main/java/movie/bean/MovieDTO.java
package movie.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private int mcode;				// 영화 코드
    private String title;			// 영화 제목
    private String director;		// 영화 감독
    private String genre;			// 영화 장르
    private String release_date;	// 개봉일 YYYY-MM-DD
    private int rating;				// 영화 등급 : 0(ALL), 15, 19
    private float score;			// 영화 평점
    private String synopsis;		// 줄거리
    private String poster;			// 영화 포스터
}

