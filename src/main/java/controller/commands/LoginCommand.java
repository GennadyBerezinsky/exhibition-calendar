package controller.commands;

import controller.AuthUtility;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 26.02.2019.
 */


public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        if(login == null || login.equals("") || pass == null || pass.equals("")) {
            return "index.jsp";
        }

        // TODO: 26.02.2019  : check if logged

        if(login.equals("admin")) {
            AuthUtility.login(request, login);
            return "redirect: admin";
        }
        if(login.equals("user")) {

            return "redirect: user";
        }

        return "index.jsp";
    }
}
