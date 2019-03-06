package model.dao.mysql;

import model.dao.CategoryDao;
import model.entity.Category;

import java.sql.Connection;
import java.util.List;

/**
 * Created by User on 07.03.2019.
 */


public class MySQLCategoryDao implements CategoryDao {
    private Connection connection;

    public MySQLCategoryDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Category entity) {

    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public void update(Category entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
