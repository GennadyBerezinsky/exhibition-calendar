package model.service;

import model.dao.DaoFactory;
import model.dao.TicketDao;
import model.dto.TicketListDto;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 23.04.2019.
 */


public class PaginationService {
    private static final int ELEMENTS_ON_PAGE = 3;
    private static final Logger log = Logger.getLogger(PaginationService.class);

    public List<TicketListDto> getTicketListPage(int page, long userID) {
        List<TicketListDto> ticketListDtos = new ArrayList<>();
        int offset = page*ELEMENTS_ON_PAGE;
        try {
            DaoFactory factory = DaoFactory.getInstance();
            TicketDao dao = factory.createTicketDao();
            ticketListDtos = dao.getUserTicketsPage(offset, userID);
        } catch (Exception e) {
            log.error("exception: " + e.getMessage());
        }
        return ticketListDtos;
    }

    public int getPages(long userID) {
        DaoFactory factory = DaoFactory.getInstance();
        TicketDao dao = factory.createTicketDao();
        int rows =  dao.countRows(userID);
        return rows/ELEMENTS_ON_PAGE + 1;
    }

}
