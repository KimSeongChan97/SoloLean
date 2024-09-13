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
    urlPatterns = {"*.do"}, // 서블릿이 *.do로 끝나는 모든 요청을 처리하도록 설정합니다.
    initParams = {
        @WebInitParam(name = "propertyConfig", value = "command.properties") // 초기화 파라미터로 command.properties 파일의 경로를 설정합니다.
    }
)
public class ControlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // 서블릿의 직렬화 ID로, 특정 버전의 서블릿이 직렬화된 객체와 호환성을 유지할 수 있게 합니다.
    private Map<String, Object> map = new HashMap<String, Object>(); 
    // URL과 해당 요청을 처리하는 클래스를 매핑하여 저장하는 Map입니다.
    // key: 요청 URL 패턴 (예: "/member/write.do"), value: 해당 요청을 처리하는 클래스 객체.

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println();
    	// 서블릿이 최초로 로드될 때 호출되는 메소드로, 서블릿 초기화 작업을 수행합니다.
        // 'config' 객체는 서블릿 설정 정보를 담고 있으며, 여기서 'propertyConfig' 초기화 파라미터를 불러옵니다.
        String propertyConfig = config.getInitParameter("propertyConfig");
        System.out.println("propertyConfig = " + propertyConfig);
        // 결과 : propertyConfig = command.properties
        // 'propertyConfig'가 포함된 경로에서 command.properties 파일을 읽어올 예정입니다.
        System.out.println();
        // @WebServlet으로 서블릿을 등록한 경우, 실제 경로를 가져와야 할 필요가 있습니다.
        String realFolder = config.getServletContext().getRealPath("/WEB-INF");
        // '/WEB-INF' 폴더 경로를 실제 서버의 파일 시스템 경로로 변환합니다. 이 폴더는 외부 접근이 불가능하므로 보안이 중요할 때 사용됩니다.
        String realPath = realFolder + "/" + propertyConfig;
        System.out.println("realPath = " + realPath);
        // realPath는 실제로 command.properties 파일이 위치한 서버 내 경로입니다.
        // properties 파일 경로: '/WEB-INF/command.properties'로 실제 서버 경로를 출력합니다.
        System.out.println();
        // command.properties 파일의 내용을 읽어서 Map에 보관해야 합니다.
        FileInputStream fin = null; // 파일을 읽기 위한 FileInputStream 객체입니다.
        Properties properties = new Properties(); // Properties 객체는 key-value 형식의 설정값을 읽고 저장하는 데 사용됩니다.

        try {
            // @WebServlet을 사용했으므로 실제 경로를 사용해 FileInputStream을 엽니다.
            fin = new FileInputStream(realPath);
            // properties.load() 메소드를 통해 파일의 내용을 Properties 객체에 로드합니다.
            properties.load(fin);
            System.out.println("properties = " + properties);
            // 파일에서 읽어들인 설정 정보를 출력합니다.
            System.out.println();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) fin.close(); 
                // 파일을 다 사용한 후에는 반드시 close() 메소드를 호출해 자원을 해제해야 합니다.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Properties 객체에 저장된 key-value 쌍을 순회하면서 각 key에 해당하는 클래스 정보를 로드합니다.
        Iterator<Object> it = properties.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next(); // 각 key(URL 패턴)를 가져옵니다.
            System.out.println("key = " + key); 

            String className = properties.getProperty(key); // 해당 key에 매핑된 클래스 이름을 가져옵니다.
            System.out.println("className = " + className); // className 변수는 문자열로, 해당 요청을 처리할 클래스 이름을 담고 있음

            try {
                // 클래스 이름을 기반으로 해당 클래스를 동적으로 로드하여 인스턴스를 생성합니다.
                Class<?> classType = Class.forName(className); 
                // 클래스 이름을 사용하여 해당 클래스의 'Class' 객체를 가져옵니다. 이를 통해 클래스의 정보와 메소드를 동적으로 다룰 수 있습니다.
                Object ob = classType.getConstructor().newInstance();
                // 클래스의 인스턴스를 생성합니다. 해당 클래스가 CommandProcess 인터페이스를 구현한 객체임.

                System.out.println("ob = " + ob); // 생성된 클래스의 객체를 확인합니다.

                // URL 패턴과 해당 클래스를 Map에 저장합니다.
                map.put(key, ob);
                // 이 map은 요청이 들어올 때마다 해당 URL 패턴에 맞는 클래스를 찾아서 요청을 처리하는 데 사용됩니다.

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            }

            System.out.println();
        } // while
    }

    // GET 요청을 처리하는 메소드
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // GET 요청이 들어오면 execute 메소드를 호출하여 처리를 위임합니다.
        execute(request, response);
    }

    // POST 요청을 처리하는 메소드
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // POST 요청이 들어오면 execute 메소드를 호출하여 처리를 위임합니다.
        execute(request, response);
    }

    // GET과 POST 요청에 대해 공통으로 처리하는 메소드
    protected void execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        System.out.println();
        // 요청이 들어올 때마다 이 메소드가 호출되어 클라이언트의 요청을 처리합니다.

        if (request.getMethod().equals("POST")) request.setCharacterEncoding("UTF-8");
        // POST 방식으로 요청이 들어올 경우, 요청 파라미터의 인코딩을 UTF-8로 설정하여 한글 처리를 가능하게 합니다.
        // GET 방식에서는 기본적으로 브라우저가 UTF-8로 인코딩을 하므로 따로 설정할 필요가 없지만, POST 방식에서는 명시적으로 인코딩을 설정해 주어야 한글이 깨지지 않습니다.

        // 예: http://localhost:8080/memberMVC/member/writeForm.jsp.do
        // 요청한 URL에서 서블릿 경로(예: "/member/writeForm.jsp")를 추출합니다.
        String category = request.getServletPath();
        System.out.println("category = " + category);
        // 출력결과 : category = /member/writeForm.jsp.do
        // 클라이언트가 요청한 URL에서 서블릿 경로를 가져옵니다.

        // Map에서 해당 URL 패턴에 해당하는 클래스를 가져옵니다.
        // 예: "/member/writeForm.jsp.do"에 해당하는 member.service.WriteFormService 클래스
        CommandProcess com = (CommandProcess) map.get(category);
        // URL 패턴에 맞는 클래스를 Map에서 찾아서 처리 클래스를 가져옵니다.
        // Map에 저장된 클래스 객체는 CommandProcess 인터페이스를 구현한 클래스들로, 요청 처리 로직을 포함하고 있습니다.

        String view = null; // 결과로 반환할 JSP 파일 경로를 저장할 변수입니다.
        try {
            // 해당 처리 클래스의 requestPro 메소드를 호출하여 JSP 파일 경로를 얻습니다.
            view = com.requestPro(request, response);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        
        if(view.equals("none")) return; 
        // 만약 view 값이 "none"이면 포워딩을 하지 않고 함수 종료 (특정 상황에 따라 포워딩하지 않는 경우 처리)

        // 얻은 JSP 파일로 요청을 포워딩합니다.
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        // JSP 파일의 경로를 지정하여 RequestDispatcher 객체를 생성합니다.
        dispatcher.forward(request, response);
        // RequestDispatcher를 통해 JSP로 요청을 포워딩합니다.
        // 클라이언트의 요청을 받은 후, 해당하는 JSP로 화면을 출력하기 위해 요청을 전달하는 과정입니다.
    }
    
}
