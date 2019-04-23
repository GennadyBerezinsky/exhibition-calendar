package controller.filter;

import javafx.util.Pair;
import model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 26.02.2019.
 */

@WebFilter(filterName = "AccessFilter")
public class AccessFilter implements Filter {

    private final static Logger log = Logger.getLogger(AccessFilter.class);

    Map<String, List> accessMap = new HashMap<>();
    List<String> userRoleAllowed = new ArrayList<>();
    List<String> adminRoleAllowed = new ArrayList<>();
    List<String> unknownRoleAllowed = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        userRoleAllowed.add("/index");
        userRoleAllowed.add("/user");
        userRoleAllowed.add("/gotoselect");
        userRoleAllowed.add("/update");
        userRoleAllowed.add("/gotobook");
        userRoleAllowed.add("/gotomytickets");
        userRoleAllowed.add("/denied");
        userRoleAllowed.add("/logout");


        adminRoleAllowed.add("/index");
        adminRoleAllowed.add("/admin");
        adminRoleAllowed.add("/newcat");
        adminRoleAllowed.add("/gotonewcat");
        adminRoleAllowed.add("/gotonewhall");
        adminRoleAllowed.add("/newhall");
        adminRoleAllowed.add("/gotonewexhibition");
        adminRoleAllowed.add("/newexhibition");
        adminRoleAllowed.add("/denied");
        adminRoleAllowed.add("/logout");


        unknownRoleAllowed.add("/toregistr");
        unknownRoleAllowed.add("/registration");
        unknownRoleAllowed.add("/login");
        unknownRoleAllowed.add("/index");
        unknownRoleAllowed.add("/denied");
        unknownRoleAllowed.add("/logout");

        accessMap.put("USER", userRoleAllowed);
        accessMap.put("ADMIN", adminRoleAllowed);
        accessMap.put("UNKNOWN", unknownRoleAllowed);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

            User user = (User) request.getSession().getAttribute("user");

            if(user != null) {
                String role = user.getRole();
                List<String> commandList = accessMap.get(role);
                String path = request.getRequestURI().toLowerCase().replaceAll("/servlet", "").trim();
                if (commandList.contains(path)) {
                    log.info("filter allow path for logged users");
                    filterChain.doFilter(request, response);
                }
                else {
                    log.info("access defined by filter");
                    response.sendRedirect("redirect: /denied");
                }
            }
            else {

                List<String> commandList1 = accessMap.getOrDefault("UNKNOWN", unknownRoleAllowed);
                String path = request.getRequestURI().toLowerCase().replaceAll("/servlet", "").trim();
                if (commandList1.contains(path)) {
                    log.info("filter allow path");
                    filterChain.doFilter(request, response);
                }
                else {
                    log.info("access defined by filter");
                    response.sendRedirect("redirect: /denied");
                }
            }
    }

    @Override
    public void destroy() {

    }
}
