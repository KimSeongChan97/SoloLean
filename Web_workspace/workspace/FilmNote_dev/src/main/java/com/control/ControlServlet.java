package com.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = {"*.do"}, 
    initParams = {
        @WebInitParam(name = "propertyConfig", value = "command.properties")
    }
)
public class ControlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; 
    private Map<String, Object> commandMap = new HashMap<>(); // 요청 URL과 처리 객체를 저장할 Map

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 서블릿 초기화 시 command.properties 파일을 로드하여 객체 맵핑 준비
        String propertyConfig = config.getInitParameter("propertyConfig");
        String realFolder = config.getServletContext().getRealPath("/WEB-INF");
        String realPath = realFolder + "/" + propertyConfig;

        Properties properties = new Properties();
        try (FileInputStream fin = new FileInputStream(realPath)) {
            properties.load(fin);
        } catch (IOException e) {
            throw new ServletException(e);
        }

        Iterator<Object> it = properties.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next(); // URL 경로 키
            String className = properties.getProperty(key); // 처리 클래스 이름
            try {
                Class<?> commandClass = Class.forName(className);
                Object commandInstance = commandClass.getDeclaredConstructor().newInstance();
                commandMap.put(key, commandInstance);
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
    }

    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase("POST")) {
            request.setCharacterEncoding("UTF-8");
        }

        String command = request.getServletPath(); // 요청된 URL 경로 추출
        CommandProcess com = (CommandProcess) commandMap.get(command);

        String view = null;
        try {
            view = com.requestPro(request, response); // 비즈니스 로직 처리 후 결과 뷰 반환
        } catch (Throwable e) {
            throw new ServletException(e);
        }

        if (view.equals("none")) {
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response); // GET 요청 처리
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response); // POST 요청 처리
    }
}
