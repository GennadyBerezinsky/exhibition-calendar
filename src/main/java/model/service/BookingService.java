package model.service;

import model.dao.DaoFactory;
import model.dao.ExhibitionDao;
import model.dao.PaymentDao;
import model.dao.TicketDao;
import model.entity.Exhibition;
import model.entity.Payment;
import model.entity.Ticket;

/**
 * Created by User on 07.04.2019.
 */


public class BookingService {

    public Exhibition getById(int id) {
        DaoFactory factory = DaoFactory.getInstance();
        ExhibitionDao dao = factory.createExhibitionDao();
        return dao.findById(id);
    }


    public void bookingTransaction(Ticket ticket, long pay) {
        DaoFactory factory = DaoFactory.getInstance();
        TicketDao ticketDao = factory.createTicketDao();
        PaymentDao paymentDao = factory.createPaymentDao();

        ticketDao.create(ticket);
        long id = ticketDao.getLastId() + 1;

        Payment payment = new Payment.Builder()
                .setIdTicket(id)
                .setIdUser(ticket.getIdUser())
                .build();
        paymentDao.create(payment);
    }

}
