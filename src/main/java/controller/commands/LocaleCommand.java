package controller.commands;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by User on 14.03.2019.
 */


public class LocaleCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("locale", "UA");

        return "redirect: /index";
    }
}
