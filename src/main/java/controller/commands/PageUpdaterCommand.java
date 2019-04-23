package controller.commands;

import model.dto.TicketListDto;
import model.service.PaginationService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by User on 23.04.2019.
 */


public class PageUpdaterCommand implements Command {
    private static final Logger log = Logger.getLogger(PaginationService.class);

    @Override
    public String execute(HttpServletRequest request) {


        long userID = (long) request.getSession().getAttribute("id");
        int pagenum =  Integer.valueOf(request.getParameter("pagenum"));
        log.trace("userid: " + userID + ", page num: " + pagenum);
        PaginationService service = new PaginationService();
        List<TicketListDto> dtoList = service.getTicketListPage(pagenum-1, userID);
        request.setAttribute("dto", dtoList);
        log.trace("dto size: " + dtoList.size());
        int pages = service.getPages(userID);
        request.setAttribute("pages", pages);

        return "/WEB-INF/view/user/mytickets.jsp";
    }
}
