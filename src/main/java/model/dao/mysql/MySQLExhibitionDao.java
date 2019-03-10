package model.dao.mysql;

import model.dao.ExhibitionDao;
import model.entity.Exhibition;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by User on 07.03.2019.
 */


public class MySQLExhibitionDao implements ExhibitionDao {
    private Connection connection;
    ResourceBundle sql = ResourceBundle.getBundle("sql");
    private static final Logger log = Logger.getLogger(MySQLExhibitionDao.class);

    public MySQLExhibitionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Exhibition entity) {
        final String query = sql.getString("CREATE_EXHIBITION");
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, entity.getIdCategory());
            statement.setLong(2, entity.getIdHall());
            statement.setString(3, entity.getName());
            statement.setDate(4, entity.getDate());
            statement.setLong(5, entity.getPrice());

            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("SQL exception: " + e.getMessage());
            e.printStackTrace();
        }
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
