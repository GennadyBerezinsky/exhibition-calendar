package controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 27.02.2019.
 */


public class AuthUtility {
    public static void login(HttpServletRequest request, String login) {
        Set<String> users = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");
        users.add(login);
        request.getSession().getServletContext().setAttribute("loggedUsers", users);
    }

}
