package controller.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 10.03.2019.
 */


public class GoToTicketsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/view/user/mytickets.jsp";
    }
}
