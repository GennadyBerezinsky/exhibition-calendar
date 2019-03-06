package controller.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 04.03.2019.
 */


public class GoToLoginCommand implements Command  {

    @Override
    public String execute(HttpServletRequest request) {
        return "/index.jsp";
    }
}
