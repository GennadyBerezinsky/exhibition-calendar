package controller.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 07.03.2019.
 */

public class GoToAdminCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/view/admin.jsp";
    }
}
