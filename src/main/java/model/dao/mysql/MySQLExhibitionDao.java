package model.dao.mysql;

import model.dao.ExhibitionDao;
import model.entity.Exhibition;

import java.sql.Connection;
import java.util.List;

/**
 * Created by User on 07.03.2019.
 */


public class MySQLExhibitionDao implements ExhibitionDao {
    private Connection connection;

    public MySQLExhibitionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Exhibition entity) {

    }

    @Override
    public Exhibition findById(int id) {
        return null;
    }

    @Override
    public List<Exhibition> findAll() {
        return null;
    }

    @Override
    public void update(Exhibition entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
