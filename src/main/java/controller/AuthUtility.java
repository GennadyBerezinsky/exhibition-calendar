package controller;

import model.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 27.02.2019.
 */


public class AuthUtility {
    private static final Logger log = Logger.getLogger(AuthUtility.class);

    public static void setRole(HttpServletRequest request, User user){
        HttpSession session = request.getSession();
        session.setAttribute("id", user.getIdUser());
        session.setAttribute("login", user.getLogin());
        session.setAttribute("role", user.getRole());

    }

    public static boolean isLogged(HttpServletRequest request, String login) {
        Set<String> loggedUsers = getLoggedUsers(request);
        return loggedUsers.stream().anyMatch(login::equals);
    }

    private static Set<String> getLoggedUsers(HttpServletRequest request){
        return (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

    }

    private static void setLoggedUsers(HttpServletRequest request, Set<String> loggedUsers){
        request.getSession().getServletContext().setAttribute("loggedUsers", loggedUsers);

    }

    public static String login(HttpServletRequest request, User user){
        Set<String> loggedUsers = getLoggedUsers(request);
        log.warn("user.login -> " + user.getLogin());
        loggedUsers.add(user.getLogin());
        setRole(request, user);
        setLoggedUsers(request, loggedUsers);
        return user.getRole();
    }

    public static void logout(HttpServletRequest request, String  login) {
        Set<String> loggedUsers = getLoggedUsers(request);
        loggedUsers.remove(login);
        setLoggedUsers(request, loggedUsers);
    }


}
