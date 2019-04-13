package model.dto;

import model.entity.Exhibition;
import model.entity.Ticket;

/**
 * Created by User on 13.04.2019.
 */


public class TicketListDto {
    private Ticket ticket;
    private Exhibition exhibition;

    public TicketListDto(Ticket ticket, Exhibition exhibition) {
        this.ticket = ticket;
        this.exhibition = exhibition;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Exhibition getExhibition() {
        return exhibition;
    }
}
