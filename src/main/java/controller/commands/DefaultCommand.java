package controller.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 24.02.2019.
 */


public class DefaultCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/index.jsp";
    }
}
