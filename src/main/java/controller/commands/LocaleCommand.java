package controller.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 14.03.2019.
 */


public class LocaleCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String url = request.getRequestURL().toString();

        return null;
    }
}
