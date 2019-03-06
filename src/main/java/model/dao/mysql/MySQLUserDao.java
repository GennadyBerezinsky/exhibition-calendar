package model.dao.mysql;

import model.dao.UserDao;
import model.entity.User;

import java.sql.Connection;
import java.util.List;

/**
 * Created by User on 07.03.2019.
 */


public class MySQLUserDao implements UserDao {
    private Connection connection;

    public MySQLUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
