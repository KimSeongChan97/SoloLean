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

@WebServlet(
    urlPatterns = {"*.do"}, // URL 패턴이 "*.do"인 모든 요청을 이 서블릿에서 처리함. 예를 들어, "writeForm.do" 같은 요청이 이 서블릿으로 들어옴.
    initParams = {
        @WebInitParam(name = "propertyConfig", value = "command.properties") // 초기화 파라미터를 설정. "propertyConfig"라는 이름으로 "command.properties" 파일 경로를 전달.
    }
)
public class ControlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // 직렬화를 위한 고유 ID
    private Map<String, Object> map = new HashMap<String, Object>(); // 요청 URL과 그에 따른 처리 객체를 저장할 Map 객체 생성
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        
    	 // AWS 경고 메시지 비활성화 설정 추가
        System.setProperty("aws.java.v1.disableDeprecationAnnouncement", "true");

        // init 메서드는 서블릿이 처음 로딩될 때 한 번만 호출되며, 설정 파일을 읽고 준비 작업을 수행함.
    	
    	
        String propertyConfig = config.getInitParameter("propertyConfig"); 
        // 서블릿 초기화 파라미터에서 "propertyConfig" 값을 가져옴. 여기서는 "command.properties"라는 파일 이름이 설정됨.
        System.out.println("propertyConfig = " + propertyConfig);
        
        //@WebServlet로 서블릿을 등록했을 때
        //--------------------
        String realFolder = config.getServletContext().getRealPath("/WEB-INF");
        // 서블릿이 실행되고 있는 실제 서버 경로를 가져옴. "/WEB-INF"는 웹 애플리케이션의 보호된 폴더로, 외부에서는 직접 접근할 수 없음.
        // 이 경로는 실제 서버에 배포될 때의 폴더 구조를 기반으로 함. 예를 들어, 로컬 개발 환경에서는 이 경로가 실제 파일 시스템의 절대 경로일 수 있음.
        
        String realPath = realFolder + "/" + propertyConfig;
        // "command.properties" 파일의 실제 경로를 생성함. 이 경로를 통해 설정 파일에 접근할 수 있음.
        // 즉, "WEB-INF" 내부에 있는 파일을 절대 경로로 접근하게 됨. 이를 통해 애플리케이션이 실행 중일 때 설정 파일을 안전하게 접근함.
        System.out.println("realPath = " + realPath);
        //--------------------
                    
        // command.properties의 파일의 내용을 읽어서 Map에 보관
        FileInputStream fin = null; // 파일을 읽기 위한 FileInputStream 선언. 이 스트림을 사용하여 파일의 내용을 읽음.
        Properties properties = new Properties(); // Properties 객체는 키-값 쌍으로 설정 파일을 다룰 수 있게 함.
        // Properties는 주로 설정 파일의 key-value 쌍을 관리하는 데 사용됨. 여기서는 command.properties 파일을 처리함.
        
        try { 
            // 웹 애플리케이션이 실행될 때 초기화 파라미터로 설정된 파일을 읽어들임.
            // web.xml 사용했을 때
            // fin = new FileInputStream(propertyConfig);
            
            //@WebServlet 사용했을 때
            fin = new FileInputStream(realPath);
            // 실제 경로에 위치한 "command.properties" 파일을 읽기 위한 입력 스트림을 열음.
            // FileInputStream은 파일의 내용을 바이트 단위로 읽을 수 있게 해줌. 실제 서버에서 해당 파일에 접근하여 내용을 읽어옴.
            
            properties.load(fin);
            // properties.load() 메서드를 통해 properties 파일 내용을 로드하고, 각 key-value 쌍을 Properties 객체에 저장함.
            // 이 메서드는 입력 스트림으로부터 데이터를 읽어들여 Properties 객체에 key-value로 저장함.
            // 파일에 있는 데이터를 프로그램이 읽을 수 있는 형태로 변환해 줌.
            System.out.println("properties = "+properties);
             
        } catch (IOException e) {
            // 파일을 읽거나 로드할 때 예외가 발생하면 해당 예외를 처리함.
            // 파일이 없거나 경로가 잘못되었을 때 발생할 수 있는 예외.
            e.printStackTrace();
        }finally{
            // 항상 실행되는 블록으로, 파일 입력 스트림을 닫아줌으로써 자원 누수를 방지함.
            try {
                fin.close(); // FileInputStream을 닫음.
                // 파일 스트림을 닫아야 메모리 누수를 방지하고 다른 프로세스에서 파일을 사용할 수 있음.
                // 항상 닫는 처리를 하는 것이 좋음.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        
        Iterator<Object> it = properties.keySet().iterator();
        // properties 파일의 키(명령어)를 순차적으로 읽기 위해 Iterator를 사용함.
        // keySet()은 설정 파일에서 모든 키들을 가져오며, 이를 순차적으로 처리하기 위해 Iterator 사용.
        while(it.hasNext()) {
            String key = (String)it.next();
            // 현재 읽고 있는 키(명령어)를 가져옴. 명령어는 예를 들어 "/member/writeForm.do"와 같은 형태일 수 있음.
            System.out.println("key = " + key);
            
            String className = properties.getProperty(key);
            // 키에 해당하는 클래스 이름(값)을 가져옴.
            // 즉, 명령어에 대응하는 처리 클래스 이름을 가져오는 것. 예를 들어, "/member/writeForm.do" 요청이 들어오면 이 요청을 처리할 클래스 이름을 얻음.
            System.out.println("className = "+ className);
            
            try {
                // 가져온 클래스 이름을 바탕으로 해당 클래스를 메모리에 로드함.
                Class<?> classType = Class.forName(className);
                // reflection을 통해 클래스 타입을 얻음. 이 방법으로 런타임 시 객체를 동적으로 생성할 수 있음.
                // Class.forName()은 문자열로 된 클래스 이름을 실제 클래스 타입으로 변환함.
                
                Object ob = classType.getConstructor().newInstance();
                // 동적으로 객체를 생성함. newInstance()는 클래스의 인스턴스를 생성함. 여기서 생성된 객체는 CommandProcess의 구현체임.
                // getConstructor()는 클래스의 생성자를 찾고, newInstance()는 그 생성자를 호출하여 객체를 생성함.
                
                System.out.println("ob = "+ob);
                
                map.put(key, ob);
                // 생성된 객체를 key(명령어)와 함께 map에 저장함. 이후 요청이 들어왔을 때 이 map에서 해당 명령어에 맞는 객체를 찾아 실행할 수 있음.
                // map.put(key, value)를 통해 명령어와 그에 대응하는 처리 객체를 저장함.
                // 이렇게 하면 나중에 사용자가 특정 명령어로 요청을 보냈을 때, map에서 그 명령어에 해당하는 객체를 쉽게 꺼내서 사용할 수 있음.
                
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
        }//while
    }//init
    
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
        // GET 방식 요청을 처리하는 메서드로, 내부적으로 execute() 메서드를 호출하여 요청을 처리함.
        // GET 방식 요청은 URL 뒤에 파라미터가 포함되어 전송되며, 주로 데이터를 조회할 때 사용됨.
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
        // POST 방식 요청을 처리하는 메서드로, 내부적으로 execute() 메서드를 호출하여 요청을 처리함.
        // POST 방식 요청은 HTTP 메시지 본문에 데이터를 포함해 전송하며, 주로 데이터 제출에 사용됨.
    }
    
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println();
        
        if(request.getMethod().equals("POST")) request.setCharacterEncoding("UTF-8");
        
        String category = request.getServletPath();
        System.out.println("category = " + category);
        
        CommandProcess com = (CommandProcess) map.get(category);
        
        String view = null;
        try {
            view = com.requestPro(request, response);
        } catch (Throwable e) {
            e.printStackTrace();
            // 로그에 예외 정보 출력
            System.out.println("Error in execute: " + e.getMessage());
        }
        
        // view가 null이거나 empty인 경우 index.do로 리다이렉트
        if (view == null || view.isEmpty()) {
            view = "/index.do";
            System.out.println("view is null, redirecting to /index.do");
        }
        
        if(view.equals("none")) return;
        // 뷰가 "none"이면 화면을 이동하지 않고 종료.
        // 만약 이동할 뷰가 없다면 반환값을 "none"으로 설정하여 추가적인 화면 처리를 하지 않음.
        
        // forward
        RequestDispatcher dispatcher = request.getRequestDispatcher(view); // 상대번지
        // RequestDispatcher를 통해 지정된 뷰로 제어를 넘김. 즉, 서버 내부에서 페이지 전환이 이루어짐.
        // forward는 서버 내부에서의 페이지 이동을 의미하며, 클라이언트의 URL은 변경되지 않음.
        
        dispatcher.forward(request, response); // 제어권 넘기기
        // forward 메서드를 사용하여 클라이언트에게 응답을 보냄. 이때 클라이언트는 URL이 변경되지 않음.
        // 이 방식은 서버 내부에서만 페이지 이동이 일어나기 때문에, 클라이언트는 URL이 바뀌지 않는 것을 알 수 있음.
    }

}
