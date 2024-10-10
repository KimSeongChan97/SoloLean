package user.bean;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component // Spring에서 이 클래스를 Bean으로 등록하여 관리하게 합니다. 이를 통해 다른 클래스에서 의존성 주입으로 사용할 수 있습니다.
@Setter // Lombok을 사용하여 setter 메서드를 자동으로 생성합니다. 각 필드에 대한 setter를 따로 작성할 필요가 없습니다.
@Getter // Lombok을 사용하여 getter 메서드를 자동으로 생성합니다. 각 필드에 대한 getter를 따로 작성할 필요가 없습니다.
public class UserPaging {
    private int currentPage; // 현재 페이지 번호를 저장하는 필드입니다.
    private int pageBlock;   // 페이지 네비게이션에서 한번에 보여줄 페이지 수 (예: [1][2][3]이면 3개의 페이지 블록).
    private int pageSize;    // 한 페이지에 보여줄 게시글 수. (예: 1페이지당 5개씩 보여줌)
    private int totalA;      // 총 글 수 (전체 게시물 수).
    private StringBuffer pagingHTML; // 페이지 네비게이션 HTML을 담을 StringBuffer 객체. StringBuffer는 문자열을 효율적으로 추가, 수정할 수 있습니다.

    // 페이징을 위한 HTML을 생성하는 메서드입니다.
    public void makePagingHTML() {
        pagingHTML = new StringBuffer(); // 새로운 StringBuffer 객체를 생성하여 HTML 내용을 추가할 준비를 합니다.

        // 글이 하나도 없을 경우 처리 (총 게시글이 0일 때)
        if (totalA == 0) {
            pagingHTML.append("<span id='noContent'>1</span>"); // 게시물이 없을 경우 1 페이지를 기본적으로 출력합니다.
            return; // 게시물이 없으므로 더 이상의 처리는 하지 않고 메서드를 종료합니다.
        }

        // 총 페이지 수를 계산합니다. 총 글 수를 페이지당 글 수로 나누어 총 페이지 수를 구합니다.
        int totalP = (totalA + pageSize - 1) / pageSize; // 예를 들어, 51개의 게시글이 있으면 10개씩 보여줄 때 총 6페이지가 필요합니다.

        // 페이지 네비게이션의 시작 페이지를 계산합니다.
        int startPage = (currentPage - 1) / pageBlock * pageBlock + 1; // 현재 페이지에서 블록의 시작 페이지 번호를 계산합니다.
        int endPage = startPage + pageBlock - 1; // 페이지 네비게이션의 마지막 페이지 번호를 계산합니다.
        if (endPage > totalP) endPage = totalP; // 마지막 페이지가 총 페이지 수를 넘지 않도록 조정합니다.

        // 이전 페이지 링크를 추가합니다.
        if (startPage != 1)
            pagingHTML.append("<span id='paging' onclick='userPaging(" + (startPage - 1) + ")'>이전</span>");
            // 시작 페이지가 1이 아닌 경우, 이전 페이지로 이동할 수 있는 링크를 추가합니다. [이전] 버튼을 클릭하면 이전 블록으로 이동합니다.

        // 현재 페이지 블록에서 각 페이지에 대한 링크를 추가합니다.
        for (int i = startPage; i <= endPage; i++) {
            if (i == currentPage) // 현재 페이지는 강조 표시합니다.
                pagingHTML.append("<span id='currentPaging' onclick='userPaging(" + i + ")'>" + i + "</span>");
                // 현재 페이지에 대한 링크를 추가하며, [1]과 같은 형식으로 표시합니다. 클릭 시에도 다시 현재 페이지로 이동하도록 합니다.
            else
                pagingHTML.append("<span id='paging' onclick='userPaging(" + i + ")'>" + i + "</span>");
                // 현재 페이지가 아닌 다른 페이지들은 클릭할 수 있는 링크로 표시됩니다.
        }

        // 다음 페이지 링크를 추가합니다.
        if (endPage < totalP)
            pagingHTML.append("<span id='paging' onclick='userPaging(" + (endPage + 1) + ")'>다음</span>");
            // 마지막 페이지가 총 페이지 수보다 작을 경우, [다음] 링크를 추가하여 다음 블록으로 이동할 수 있도록 합니다.
    }
}
