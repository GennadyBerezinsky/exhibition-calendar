package controller.commands;

import model.dto.TicketListDto;
import model.service.ListGetterService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by User on 13.04.2019.
 */


public class GoToMyTickets implements Command {
    private static final Logger log = Logger.getLogger(GoToMyTickets.class);

    @Override
    public String execute(HttpServletRequest request) {

        long userID = (long) request.getSession().getAttribute("id");
        log.info("user id: " + userID);
        ListGetterService service = new ListGetterService();
        List<TicketListDto> dto = service.getUserTicketList(userID);
        request.setAttribute("dto", dto);
        log.info("dto size: " + dto.size());
        return "/WEB-INF/view/user/mytickets.jsp";
    }
}
