package controller.commands;

import model.entity.Exhibition;
import model.entity.User;
import model.service.BookingService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 03.04.2019.
 */


public class GoToBookingCommand implements Command {
    private static final Logger log = Logger.getLogger(GoToBookingCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        long exhibid = Long.parseLong(request.getParameter("btnid")) ;
        BookingService service = new BookingService();
        Exhibition exhibition = service.getById((int) exhibid);
        request.setAttribute("exhibition", exhibition);

        request.getSession().setAttribute("exhibition", exhibition);
        User user = (User) request.getSession().getAttribute("user");
        log.trace("current user: " + user.toString());
        request.setAttribute("user", user);
        log.trace("id exhibition " + exhibid);

        request.getSession().setAttribute("user", user);

        return "/WEB-INF/view/user/booking.jsp";
    }
}
