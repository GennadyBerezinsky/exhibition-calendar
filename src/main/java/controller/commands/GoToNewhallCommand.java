package controller.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 09.03.2019.
 */


public class GoToNewhallCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/view/admin/newhall.jsp";
    }
}
