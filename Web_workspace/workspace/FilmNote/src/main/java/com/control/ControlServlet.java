// FilmNote/src/main/java/com/control/ControlServlet.java
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

/** 서블릿을 @WebServlet 으로 등록했을 때 ; web.xml 에서 등록한 서블릿 주석처리 해야함 */
@WebServlet(
		urlPatterns = {"*.do"}, 
		initParams = {
				@WebInitParam(name = "propertyConfig", value = "command.properties")
		}
)

public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> map = new HashMap<String, Object>();
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// @WebInitParam으로 설정한 propertyConfig 값 가져옴
		String propertyConfig = config.getInitParameter("propertyConfig");
		System.out.println("propertyConfig : " + propertyConfig);
		
		// 실제 파일 경로 가져오기
		String realFolder = config.getServletContext().getRealPath("/WEB-INF");
		String realPath = realFolder + "/" + propertyConfig;
		System.out.println("realPath : " + realPath);
        
		// command.properties 의 파일 내용을 읽어서 Map 에 보관
		FileInputStream fin = null;
		Properties properties = new Properties();
		
        try {
        	/** 서블릿을 web.xml 로 등록했을 때 
        	fin = new FileInputStream(propertyConfig);
        	 */
        	fin = new FileInputStream(realPath);
            properties.load(fin);
            System.out.println("properties = "+ properties);

         } catch (IOException e) {
            e.printStackTrace();
         }finally{
            try {
               fin.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         System.out.println();

         Iterator<Object> it = properties.keySet().iterator();
         
         while(it.hasNext()) {
            String key = (String)it.next();
            System.out.println("key = "+key);

            String className = properties.getProperty(key);
            System.out.println("className = "+className);

			try {
			// command.properties 파일을 읽어서 key와 class 이름 추출
			// 추출한 class 이름을 바탕으로 해당 클래스의 객체 생성
			Class<?> classType = Class.forName(className);
			Object ob = classType.getConstructor().newInstance();
			// ob : command.properties 파일에 명시된 클래스(member.service.WriteFormService)의 인스턴스
			// newInstance() 로 클래스의 객체를 동적으로 생성해서 ob 에 저장
	
	       System.out.println("ob = "+ob);
	
	       map.put(key, ob);

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
         } //while
	} // init
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();
		
		if ( request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8"); 
		}
		
		// http://localhost:8080/memberMVC/member/memberWriteForm.do
		// 요청한 URL 에서 "/member/memberWriteForm.do" 뜯어오기
		String category = request.getServletPath();
		System.out.println("category : " + category);
		
		// Map 에서 해당 경로에 맞는 CommandProcess 객체를 가져와 실행
		// Map 을 이용하여 Key 에 해당하는 값을 꺼내온다
		// member.service.WriteFormService
		CommandProcess com = (CommandProcess)map.get(category); // 자식 = (자식)부모
		
		if (com == null) {
		    System.out.println("No CommandProcess found for category: " + category);
		    return; // 적절한 처리
		}

		System.out.println("com : " + com);
		
		String view = null;
		try {
			view = com.requestPro(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("view : " + view);

//		if(view.equals("none")) return; // 굳이 forwarding 처리 필요 없는 페이지는 안가게 한다.
//		
//		// forward
//		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//		dispatcher.forward(request, response); // 제어권 넘기기
		
	    // view가 null인 경우에 대한 처리 추가
	    if (view == null || view.equals("none")) {
	        return; // 굳이 forwarding 처리 필요 없는 페이지는 안가게 한다
	    }

	    // forward
	    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	    dispatcher.forward(request, response); // 제어권 넘기기
		
	}
}
