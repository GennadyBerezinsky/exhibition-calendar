package model.dao.mysql;

import model.dao.TicketDao;
import model.entity.Ticket;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by User on 07.03.2019.
 */


public class MySQLTicketDao implements TicketDao {
    private Connection connection;
    private ResourceBundle sql = ResourceBundle.getBundle("sql");
    private static final Logger log = Logger.getLogger(MySQLTicketDao.class);

    public MySQLTicketDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Ticket entity) {
        String query = sql.getString("INSERT_TICKET");
        try(PreparedStatement statement = connection.prepareStatement(query)){

            statement.setLong(1, entity.getIdExpo());
            statement.setLong(2, entity.getIdUser());

            statement.executeUpdate();
            log.info("statement added to butch");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long getLastId() {
        String query = sql.getString("GET_LAST_TICKET_ID");
        long id = 0;
        try(Statement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                id = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
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
