package controller.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 08.03.2019.
 */


public class GoToIndexCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/index.jsp";
    }
}
