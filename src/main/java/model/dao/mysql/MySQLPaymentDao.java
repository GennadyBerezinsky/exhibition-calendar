package model.dao.mysql;

import model.dao.PaymentDao;
import model.entity.Payment;

import java.sql.Connection;
import java.util.List;

/**
 * Created by User on 07.03.2019.
 */


public class MySQLPaymentDao implements PaymentDao {
    private Connection connection;

    public MySQLPaymentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Payment entity) {

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
