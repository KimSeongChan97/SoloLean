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

/** 
 * 이 서블릿은 @WebServlet을 사용하여 URL 패턴 "*.do"에 매칭됩니다.
 * 즉, *.do 형식의 모든 요청을 이 서블릿이 처리합니다.
 * 또한 initParams로 초기화 파라미터를 설정하여 "propertyConfig"라는 이름의 파일을 사용합니다.
 */
@WebServlet(
		urlPatterns = {"*.do"}, 
		initParams = {
				@WebInitParam(name = "propertyConfig", value = "command.properties") // 초기화 파라미터로 properties 파일 지정
		}
)
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	private Map<String, Object> map = new HashMap<String, Object>(); // 커맨드 클래스를 저장할 Map

	/**
	 * 서블릿 초기화 시 호출되는 메서드. properties 파일을 읽고 그에 대응하는 커맨드 객체를 생성해 map에 저장.
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// @WebInitParam에서 설정한 "propertyConfig" 값을 가져옴
		String propertyConfig = config.getInitParameter("propertyConfig");
		System.out.println("propertyConfig : " + propertyConfig);

		// 실제 파일 경로를 가져옴. 이때 "/WEB-INF" 내부에 위치한 properties 파일을 참조
		String realFolder = config.getServletContext().getRealPath("/WEB-INF");
		String realPath = realFolder + "/" + propertyConfig;
		System.out.println("realPath : " + realPath);

		// properties 파일을 읽어서 key와 class 정보를 저장할 properties 객체 생성
		FileInputStream fin = null;
		Properties properties = new Properties();

		try {
			// 파일 스트림을 통해 properties 파일을 읽어들임
			fin = new FileInputStream(realPath);
			properties.load(fin); // properties 파일 내용을 로드
			System.out.println("properties = " + properties);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fin != null) fin.close(); // 파일 스트림을 닫음
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// properties 파일의 key-value 쌍을 순차적으로 처리
		Iterator<Object> it = properties.keySet().iterator();
		while (it.hasNext()) {
			// key와 대응되는 class 이름을 가져와서 객체로 변환
			String key = (String) it.next();
			System.out.println("key = " + key);

			String className = properties.getProperty(key);
			System.out.println("className = " + className);

			try {
				// className에 해당하는 클래스 객체를 동적으로 생성하여 map에 저장
				Class<?> classType = Class.forName(className);
				Object ob = classType.getConstructor().newInstance(); // 새로운 객체 생성
				System.out.println("ob = " + ob);
				map.put(key, ob); // 생성된 객체를 map에 저장
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException
					| NoSuchMethodException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}

	// GET 요청을 처리하는 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response); // 실제 로직은 execute에서 처리
	}

	// POST 요청을 처리하는 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response); // 실제 로직은 execute에서 처리
	}

	/**
	 * GET 및 POST 요청을 공통으로 처리하는 메서드
	 */
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();

		// POST 방식으로 요청이 들어오면 UTF-8 인코딩을 적용하여 한글이 깨지지 않도록 처리
		if (request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}

		// 요청한 URL에서 경로 정보를 가져옴. 예: "/member/memberWriteForm.do"
		String category = request.getServletPath();
		System.out.println("category : " + category);

		// 해당 경로에 맞는 CommandProcess 객체를 map에서 가져옴
		CommandProcess com = (CommandProcess) map.get(category);

		// 해당 경로에 맞는 객체가 없으면 처리 중단
		if (com == null) {
			System.out.println("No CommandProcess found for category: " + category);
			return; // 더 이상 처리를 진행하지 않음
		}

		System.out.println("com : " + com);

		// 해당 커맨드의 requestPro 메서드를 호출하여 결과 페이지를 결정
		String view = null;
		try {
			view = com.requestPro(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("view : " + view);

		// view가 null이거나 "none"일 경우에는 포워딩을 하지 않음
		if (view == null || view.equals("none")) {
			return; // 별도 포워딩이 필요 없는 경우 처리 종료
		}

		// view가 지정되어 있으면 해당 view로 포워딩 처리
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response); // 제어권을 해당 view로 넘김
	}
}
