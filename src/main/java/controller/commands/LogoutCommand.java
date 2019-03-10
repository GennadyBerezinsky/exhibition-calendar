package controller.commands;

import controller.AuthUtility;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 09.03.2019.
 */


public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        AuthUtility.logout(request, login);
        return "redirect: /index";
    }
}
