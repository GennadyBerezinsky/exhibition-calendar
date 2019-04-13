package model.dao.mysql;

import model.dto.TicketListDto;
import model.dao.TicketDao;
import model.entity.Exhibition;
import model.entity.Ticket;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by User on 07.03.2019.
 */


public class MySQLTicketDao implements TicketDao  {
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
    public List<TicketListDto> getUserTickets(long userID) {
        log.info("user id in dao: " + userID);
        List<TicketListDto> dtoList = new ArrayList<>();
        final String queue = sql.getString("USER_TICKETS");
        try(PreparedStatement statement = connection.prepareStatement(queue)) {
            statement.setLong(1, userID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long ticketId = resultSet.getLong("id_ticket");
                String exhibitionName = resultSet.getString("name_expo");
                String hallName = resultSet.getString("name_hall");
                String catName = resultSet.getString("name_cat");
                Date date = resultSet.getDate("date_expo");
                long price = resultSet.getLong("price");

                Ticket ticket = new Ticket.Builder()
                        .setIdUser(userID)
                        .setIdTicket(ticketId)
                        .build();
                Exhibition exhibition = new Exhibition.Builder()
                        .setDate(date)
                        .setName(exhibitionName)
                        .setHallName(hallName)
                        .setCatName(catName)
                        .setPrice(price)
                        .build();

                dtoList.add(new TicketListDto(ticket, exhibition));
            }
        } catch (SQLException e) {
            log.error("sql exception" + e.getMessage());
            e.printStackTrace();
        }
        log.info("list size in dao: " + dtoList.size());
        return dtoList;
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
