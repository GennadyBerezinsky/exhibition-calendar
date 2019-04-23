package controller.commands;

import model.entity.Exhibition;
import model.entity.Payment;
import model.entity.Ticket;
import model.entity.User;
import model.service.BookingService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 06.04.2019.
 */


public class BookingCommand implements Command {
    private static final Logger log = Logger.getLogger(BookingCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        log.info("in booking command");
        Exhibition exhibition = (Exhibition) request.getSession().getAttribute("exhibition");
        log.trace(exhibition.getIdExpo());
        User user = (User) request.getSession().getAttribute("user");
        int summ = Integer.valueOf(request.getParameter("payment"));

        Ticket ticket = new Ticket.Builder()
                .setIdExpo(exhibition.getIdExpo())
                .setIdUser(user.getIdUser())
                .build();


        BookingService service = new BookingService();
        service.bookingTransaction(ticket, summ);

        return "redirect: /user";
    }
}
