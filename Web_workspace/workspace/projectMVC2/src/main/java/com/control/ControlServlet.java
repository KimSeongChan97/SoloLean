package com.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

import member.control.CommandProcess;

@WebServlet(
    urlPatterns = {"*.do", "*.board.do", "*.member.do"}, // 모든 서블릿 패턴을 하나의 서블릿으로 처리
    initParams = {
        @WebInitParam(name = "propertyConfig", value = "command.properties") // 초기화 파라미터로 command.properties 파일의 경로 설정
    }
)
public class ControlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; 
    private Map<String, Object> map = new HashMap<String, Object>(); 

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println();
        // 디버깅: 초기화 파라미터와 경로를 출력
        String propertyConfig = config.getInitParameter("propertyConfig");
        System.out.println("propertyConfig = " + propertyConfig);
        
        String realFolder = config.getServletContext().getRealPath("/WEB-INF");
        String realPath = realFolder + "/" + propertyConfig;
        System.out.println("realPath = " + realPath);

        FileInputStream fin = null;
        Properties properties = new Properties();

        try {
            fin = new FileInputStream(realPath);
            properties.load(fin);
            System.out.println("properties = " + properties);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) fin.close(); 
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Iterator<Object> it = properties.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println("key = " + key); // URL 매핑 키 출력
            String className = properties.getProperty(key);
            System.out.println("className = " + className); // 클래스 이름 출력

            try {
                Class<?> classType = Class.forName(className);
                Object ob = classType.getConstructor().newInstance();
                System.out.println("ob = " + ob); // 생성된 클래스 객체 출력
                map.put(key, ob);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        execute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        execute(request, response);
    }

    protected void execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        if (request.getMethod().equals("POST")) request.setCharacterEncoding("UTF-8");

        String category = request.getServletPath();
        System.out.println("category = " + category); // 요청된 카테고리 출력
        CommandProcess com = (CommandProcess) map.get(category);

        if (com == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "The requested URL was not found on this server.");
            return;
        }

        String view = null;
        try {
            view = com.requestPro(request, response);
            System.out.println("view = " + view); // 결과 JSP 경로 출력
        } catch (Throwable e) {
            e.printStackTrace();
        }

        if (view == null || view.equals("none")) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "View not found or returned as null.");
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
