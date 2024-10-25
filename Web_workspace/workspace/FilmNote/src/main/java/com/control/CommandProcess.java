// FilmNote/src/main/java/com/control/CommandProecss.java
package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess { 
	// 클라이언트의 요청을 처리하고 그 결과를 JSP 페이지로 반환
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
