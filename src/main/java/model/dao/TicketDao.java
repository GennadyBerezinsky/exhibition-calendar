package model.dao;

import model.dto.TicketListDto;
import model.entity.Ticket;

import java.util.List;

public interface TicketDao extends GenericDao<Ticket> {
    long getLastId();
    List<TicketListDto> getUserTicketsPage(int offset, long userID);
    int countRows(long userID);

}
