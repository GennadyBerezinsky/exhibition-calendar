package model.dao.mysql;

import model.dao.CategoryDao;
import model.entity.Category;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by User on 07.03.2019.
 */


public class MySQLCategoryDao implements CategoryDao {
    private Connection connection;
    ResourceBundle sql = ResourceBundle.getBundle("sql");
    private static final Logger log = Logger.getLogger(MySQLCategoryDao.class);

    public MySQLCategoryDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Category entity) {
        final String query = sql.getString("CREATE_CATEGORY") ;
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, entity.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("sql exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        final String query = sql.getString("FIND_ALL_CAT");
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id_cat");
                String catName = resultSet.getString("name_cat");

                Category cat = new Category.Builder()
                        .setIdCat(id)
                        .setName(catName)
                        .build();
                categoryList.add(cat);
            }
            log.trace("cat list size: " + categoryList.size());
        } catch (SQLException e) {
            log.error("sql exception: " + e.getMessage());
            e.printStackTrace();
        }
        return categoryList;
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
