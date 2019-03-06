package model.dao.mysql;

import model.dao.TicketDao;
import model.entity.Ticket;

import java.sql.Connection;
import java.util.List;

/**
 * Created by User on 07.03.2019.
 */


public class MySQLTicketDao implements TicketDao {
    private Connection connection;

    public MySQLTicketDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Ticket entity) {

    }

    @Override
    public Ticket findById(int id) {
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }

    @Override
    public void update(Ticket entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
