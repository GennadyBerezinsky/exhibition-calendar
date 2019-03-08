package controller.commands;

import controller.AuthUtility;
import model.entity.User;
import model.service.AuthorizationService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Created by User on 26.02.2019.
 */


public class LoginCommand implements Command {
    private static final Logger log = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        AuthorizationService service = new AuthorizationService();
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        if(login == null || login.equals("") || pass == null || pass.equals("")) {
            return "/index.jsp";
        }

        User user = service.getUserByLogin(login);
        log.info("user.login -> " + user.getLogin());
        if(!Objects.isNull(user)) {
            String redirectPath = AuthUtility.login(request, user).toLowerCase();
            return "redirect: /" + redirectPath;
        }
        else {
            return "/index.jsp";
        }
    }
}
