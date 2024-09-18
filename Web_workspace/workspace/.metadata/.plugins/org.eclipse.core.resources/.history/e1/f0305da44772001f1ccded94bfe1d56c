
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
    urlPatterns = {"*.board.do"},
    initParams = {
        @WebInitParam(name = "propertyConfig", value = "command.properties")
    }
)
public class BoardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> map = new HashMap<String, Object>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        String propertyConfig = config.getInitParameter("propertyConfig");
        String realFolder = config.getServletContext().getRealPath("/WEB-INF");
        String realPath = realFolder + "/" + propertyConfig;

        FileInputStream fin = null;
        Properties properties = new Properties();
        try {
            fin = new FileInputStream(realPath);
            properties.load(fin);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { if (fin != null) fin.close(); } catch (IOException e) { e.printStackTrace(); }
        }

        Iterator<Object> it = properties.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            String className = properties.getProperty(key);
            try {
                Class<?> classType = Class.forName(className);
                Object ob = classType.getConstructor().newInstance();
                map.put(key, ob);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equals("POST")) request.setCharacterEncoding("UTF-8");
        String category = request.getServletPath();

        CommandProcess com = (CommandProcess) map.get(category);
        String view = null;
        try {
            view = com.requestPro(request, response);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        if (view != null) {
            if (view.startsWith("redirect:")) {
                response.sendRedirect(view.substring(9));
            } else {
                if (!response.isCommitted()) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
                    dispatcher.forward(request, response);
                }
            }
        }
    }
}
