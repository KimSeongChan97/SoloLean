
package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.control.CommandProcess;

public class BoardWriteFormService implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Logic for displaying the board write form
        return "/board/boardWriteForm.jsp";
    }
}
