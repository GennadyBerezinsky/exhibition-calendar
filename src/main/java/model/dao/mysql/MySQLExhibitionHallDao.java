package model.dao.mysql;

import model.dao.ExhibitionHallDao;
import model.entity.ExhibitionHall;
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


public class MySQLExhibitionHallDao implements ExhibitionHallDao {
    private Connection connection;
    ResourceBundle sql = ResourceBundle.getBundle("sql");
    private static final Logger log = Logger.getLogger(MySQLExhibitionHallDao.class);

    public MySQLExhibitionHallDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(ExhibitionHall entity) {
        final String query = sql.getString("CREATE_HALL");
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, entity.getNameHall());
            statement.setString(2, entity.getAddress());
            statement.executeUpdate();

        } catch (SQLException e) {
            log.error("SQL exception: " + e.getStackTrace().toString());
            e.printStackTrace();
        }
    }

    @Override
    public ExhibitionHall findById(int id) {
        return null;
    }

    @Override
    public List<ExhibitionHall> findAll() {
        List<ExhibitionHall> hallList = new ArrayList<>();
        final String query = sql.getString("FIND_ALL_HALL");
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String nameHall = resultSet.getString("name_hall");
                String address = resultSet.getString("adress");

                ExhibitionHall hall = new ExhibitionHall.Builder()
                        .setId(id)
                        .setNameHall(nameHall)
                        .setAddress(address)
                        .build();
                hallList.add(hall);
            }
            log.trace("halls finded: " +  hallList.size());
        } catch (SQLException e) {
            log.error("SQL exception: " + e.getStackTrace().toString());
            e.printStackTrace();
        }
        return hallList;
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
