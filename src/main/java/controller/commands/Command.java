package controller.commands;

import javax.servlet.http.HttpServletRequest;
//todo its a strategy!!!
public interface Command {
    String execute(HttpServletRequest request);
}
