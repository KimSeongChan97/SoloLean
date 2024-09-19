
package member.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
    // CommandProcess should be an interface to match its usage across various services
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
