package controller.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 21.04.2019.
 */


public class GoToAccessDeniedCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "accessdenied.jsp";
    }
}
