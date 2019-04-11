package model.dao.mysql;

import model.dao.PaymentDao;
import model.entity.Payment;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by User on 07.03.2019.
 */


public class MySQLPaymentDao implements PaymentDao {
    private Connection connection;
    private ResourceBundle sql = ResourceBundle.getBundle("sql");
    private static final Logger log = Logger.getLogger(MySQLPaymentDao.class);

    public MySQLPaymentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Payment entity) {
        final String query = sql.getString("INSERT_PAYMENT");
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, entity.getIdUser());
            statement.setLong(2, entity.getIdTicket());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Payment findById(int id) {
        return null;
    }

    @Override
    public List<Payment> findAll() {
        return null;
    }

    @Override
    public void update(Payment entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
