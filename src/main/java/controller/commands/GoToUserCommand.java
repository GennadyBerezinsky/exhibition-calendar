package controller.commands;

import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 07.03.2019.
 */


public class GoToUserCommand implements Command {
    private static final Logger log = Logger.getLogger(GoToUserCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        log.info("here");
        return "/WEB-INF/view/user/user.jsp";
    }
}
