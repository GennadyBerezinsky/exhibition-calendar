package model.dao.mysql;

import model.dao.ExhibitionHallDao;
import model.entity.ExhibitionHall;

import java.sql.Connection;
import java.util.List;

/**
 * Created by User on 07.03.2019.
 */


public class MySQLExhibitionHallDao implements ExhibitionHallDao {
    private Connection connection;

    public MySQLExhibitionHallDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(ExhibitionHall entity) {

    }

    @Override
    public ExhibitionHall findById(int id) {
        return null;
    }

    @Override
    public List<ExhibitionHall> findAll() {
        return null;
    }

    @Override
    public void update(ExhibitionHall entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
