
package board.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.control.CommandProcess;

public class BoardController implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        String view = "";
        
        if ("list".equals(action)) {
            view = "/board/boardList.jsp";
        } else if ("view".equals(action)) {
            view = "/board/boardView.jsp";
        } else if ("writeForm".equals(action)) {
            view = "/board/boardWriteForm.jsp";
        } else if ("write".equals(action)) {
            view = "/board/boardWrite.jsp";
        } else {
            view = "/board/boardList.jsp"; // Default to board list
        }
        
        return view;
    }
}
