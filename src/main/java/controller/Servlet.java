package controller;

import controller.commands.Command;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by User on 24.02.2019.
 */


public class Servlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(Servlet.class);
    private Map<String, Command> commandMap = new HashMap<>();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        Locale.setDefault(Locale.ENGLISH);

    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        processRequest(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        processRequest(httpServletRequest, httpServletResponse);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getRequestURI();
        path = path.replaceAll("/servlet", "");
        Command command = commandMap.getOrDefault(path, (r) -> "/index.jsp");
        String page = command.execute(request);
        if(page.contains("redirect: ")) {
            page = page.replaceAll("redirect: ", "");
            String redirect = request.getContextPath() + "/servlet" + page;
            response.sendRedirect(redirect);
        }
        else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
