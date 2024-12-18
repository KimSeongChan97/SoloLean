package board.controller; // 패키지 선언. 이 클래스가 'board.controller' 패키지에 속해 있음을 나타냅니다.
// 패키지는 Java의 네임스페이스와 같은 개념으로, 같은 패키지에 속한 클래스들끼리는 쉽게 접근할 수 있으며, 충돌을 방지해줍니다.

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping; // HTTP GET 요청을 특정 메서드와 매핑하기 위해 사용하는 어노테이션
// GetMapping은 특정 URL 경로로 들어오는 HTTP GET 요청을 이 메서드로 처리하겠다는 것을 명시합니다. RESTful API에서 데이터를 가져올 때 주로 사용됩니다.
import org.springframework.web.bind.annotation.RequestParam; // 요청 파라미터를 메서드의 인자로 받을 때 사용하는 어노테이션
// RequestParam은 클라이언트가 보낸 쿼리 파라미터를 서버의 메서드 파라미터로 연결시켜주는 역할을 합니다. 예를 들어, URL 쿼리로 전달된 값들을 쉽게 받을 수 있습니다.
import org.springframework.web.bind.annotation.RestController; // RESTful 웹 서비스를 위한 컨트롤러임을 나타내는 어노테이션


import board.bean.BoardDTO;


//RestController는 컨트롤러의 메서드가 반환하는 값을 JSON이나 XML 형태로 변환하여 HTTP 응답 본문에 포함해주는 역할을 합니다.
//- REST API와 같은 웹 서비스에서 주로 사용됩니다.
//- JSP 같은 뷰를 별도로 만들지 않고, 메서드가 반환하는 데이터를 클라이언트에게 직접 전달할 때 유용합니다.
//이 어노테이션을 사용하면 메서드의 반환값이 View를 통해서가 아닌 JSON 형태로 클라이언트에 직접 전달됩니다.
//HTTP 요청을 받아서 JSON 형태의 응답을 반환하는 API 컨트롤러로 주로 활용됩니다.
@RestController // @RestController는 @Controller와 @ResponseBody가 결합된 형태로, 메서드의 반환값을 HTTP 응답 본문으로 전달합니다.
public class BoardController { // BoardController 클래스 선언부. 이 클래스는 "board" 관련 요청을 처리하는 컨트롤러 역할을 합니다.
    // BoardController는 스프링에서 HTTP 요청을 처리하는 컨트롤러 클래스로, 특정 요청을 매핑된 메서드로 연결하는 역할을 합니다.

    public BoardController() { // BoardController 클래스의 생성자. 객체가 생성될 때 이 생성자가 호출됩니다.
        System.out.println("BoardController 의 생성자 입니다. ");
    };
    // 생성자에 있는 값이 로그에 출력되지 못하는 것은 Bean 으로 등록이 되지 않아서 이다.
    // 그러므로 강제 빈을 선택하는 component-scan 을 통해 설정한다.
    // main method 에 어노테이션으로 설정하면 된다.
    // - 스프링에서는 @ComponentScan을 통해 특정 패키지나 클래스가 빈(Bean)으로 등록되도록 설정할 수 있습니다.
    // - 이 클래스를 빈으로 등록하려면, 스프링 부트 메인 애플리케이션 클래스에서 해당 패키지를 @ComponentScan 어노테이션으로 지정하면 됩니다.
    // - 예를 들어, 메인 애플리케이션 클래스에 @ComponentScan("board.controller")로 설정하여 이 컨트롤러를 빈으로 등록할 수 있습니다.
    // 스프링에서 빈은 스프링 컨테이너가 관리하는 객체로, 애플리케이션 전체에서 공용으로 사용할 수 있습니다.
    // @ComponentScan 어노테이션을 사용하면 특정 패키지 내에 있는 클래스들이 자동으로 빈으로 등록되며, 이렇게 등록된 클래스는 DI(의존성 주입)를 통해 다른 클래스에서 쉽게 사용될 수 있습니다.
    // 또한, 메인 애플리케이션 클래스에 설정함으로써 이 패키지의 클래스들이 빈으로 등록되어 의존성 주입 등의 스프링 기능을 사용할 수 있게 됩니다.

    @GetMapping(value="board/hello") // HTTP GET 요청을 "/board/hello" 경로로 매핑합니다.
    public String hello(@RequestParam(value="name") String name) { // 요청 파라미터 "name"을 메서드 파라미터로 받습니다.
        return "Hello, " + name + " 님 !! ";
        // "Hello, [name] 님 !!"이라는 문자열을 반환합니다.
        // 예를 들어, http://localhost:9000/board/hello?name=홍길동 라고 요청하면
        // "Hello, 홍길동 님 !!"이라는 응답이 반환됩니다.
        // @RequestParam을 통해 클라이언트가 요청한 URL에서 전달된 파라미터를 받아와서 사용할 수 있습니다.
        // 사용 예: http://localhost:9000/board/hello?name=홍길동
        // @RequestParam의 value는 URL에서 파라미터의 이름을 지정해주는 역할을 합니다.
        // 사용자가 요청할 때 "name"이라는 쿼리 파라미터 값을 보내지 않으면 예외가 발생할 수 있으므로, 기본값이나 필수 여부를 설정할 수도 있습니다.
    };

    @GetMapping(value="board/getBoard") // HTTP GET 요청을 "/board/getBoard" 경로로 매핑합니다.
    public BoardDTO getBoard() {
        BoardDTO boardDTO = new BoardDTO(); // BoardDTO 객체를 생성하여 데이터를 세팅합니다.
        boardDTO.setSeq(10); // 글 번호를 설정합니다.
        boardDTO.setName("허균"); // 작성자 이름을 설정합니다.
        boardDTO.setSubject("홍길동전"); // 글 제목을 설정합니다.
        boardDTO.setContent("호부호형"); // 글 내용을 설정합니다.
        boardDTO.setLogtime(new Date()); // 작성 시간을 현재 시간으로 설정합니다. Date 객체는 현재 시스템 시간을 자동으로 할당합니다.
        // 위와 같이 각 필드에 데이터를 설정하여 게시글의 정보를 저장한 객체를 만듭니다.

        System.out.println(boardDTO); // 배열형식
        // 콘솔에 boardDTO 객체의 정보가 출력됩니다. toString 메서드를 재정의했다면, 필드 값들이 포맷에 맞게 출력됩니다.

        return boardDTO; 
        // BoardDTO 객체를 반환합니다. @RestController로 인해 이 객체는 JSON 형태로 자동 변환되어 클라이언트에게 응답됩니다.
        // 클라이언트는 이 응답 데이터를 JSON 포맷으로 받아서 처리할 수 있습니다.
    };

    @GetMapping(value="board/getBoardList") // HTTP GET 요청을 "/board/getBoardList" 경로로 매핑합니다.
    public List<BoardDTO> getBoardList() { 
        List<BoardDTO> list = new ArrayList<>(); 
        // BoardDTO 객체들을 담을 ArrayList를 생성하여 "list"라는 변수에 할당합니다.
        // ArrayList는 List 인터페이스를 구현한 클래스로, 가변 크기의 배열을 사용하여 데이터를 저장하고 관리합니다.

        BoardDTO boardDTO = new BoardDTO(); 
        // 첫 번째 BoardDTO 객체를 생성하고 데이터를 설정합니다.
        
        boardDTO.setSeq(10); // 첫 번째 게시글의 글 번호를 설정합니다.
        boardDTO.setName("허균"); // 작성자 이름을 설정합니다.
        boardDTO.setSubject("홍길동전"); // 글 제목을 설정합니다.
        boardDTO.setContent("호부호형"); // 글 내용을 설정합니다.
        boardDTO.setLogtime(new Date()); // 작성 시간을 현재 시간으로 설정합니다.
        list.add(boardDTO); // 설정이 끝난 첫 번째 게시글 객체를 리스트에 추가합니다.

        boardDTO = new BoardDTO(); // 두 번째 BoardDTO 객체를 새로 생성합니다.
        boardDTO.setSeq(11); // 두 번째 게시글의 글 번호를 설정합니다.
        boardDTO.setName("김수정"); // 작성자 이름을 설정합니다.
        boardDTO.setSubject("아기공룡 둘리"); // 글 제목을 설정합니다.
        boardDTO.setContent("호잇 호잇"); // 글 내용을 설정합니다.
        boardDTO.setLogtime(new Date()); // 작성 시간을 현재 시간으로 설정합니다.
        list.add(boardDTO); // 설정이 끝난 두 번째 게시글 객체를 리스트에 추가합니다.
        
        System.out.println(list); // 배열형식
        // 콘솔에 list 객체의 정보가 출력됩니다. 리스트 내부의 BoardDTO 객체들이 모두 출력되며, 각 객체는 toString 메서드가 재정의되어 있다면, 포맷에 맞게 필드 값들이 출력됩니다.

        return list;
        // 리스트를 반환합니다. 리스트 내의 BoardDTO 객체들은 @RestController의 자동 JSON 변환 기능에 의해 JSON 배열 형태로 클라이언트에 응답됩니다.
    };
    
}

/*

@RestController는 JSP 같은 뷰를 별도로 만들지 않는 대신에 컨트롤러 메소드가 리턴하는 데이터 자체를 클라이언트로 보낸다.
클라이언트에 전달되는 데이터는 문자열, DTO, 컬렉션 형태의 자바 객체인데, 
자바 객체가 전달되는 경우에는 자동으로 JSON으로 변환하여 처리하게 된다.

 */
