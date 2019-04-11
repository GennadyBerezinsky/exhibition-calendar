package model.dao.mysql;

import model.dao.ExhibitionDao;
import model.dao.mysql.update.Update;
import model.entity.Exhibition;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
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
        Exhibition e = null;

        try( PreparedStatement statement = connection.prepareStatement(sql.getString("exhibition.getbyid"))) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long idExpo = resultSet.getLong("id_expo");
                long idHall = resultSet.getLong("id_hall");
                long idCat = resultSet.getLong("id_cat");

                String nameExpo = resultSet.getString("name_expo");
                String nameHall = resultSet.getString("name_hall");

                long price = resultSet.getLong("price");
                Date date = resultSet.getDate("date_expo");

                e = new Exhibition.Builder()
                        .setDate(date)
                        .setName(nameExpo)
                        .setPrice(price)
                        .setHallName(nameHall)
                        .setIdCategory(idCat)
                        .setIdExhibitionHall(idHall)
                        .setIdExpo(idExpo)
                        .build();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            try{
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return e;
    }

    @Override
    public List<Exhibition> findAll() {
       List<Exhibition> exhibitionList = new ArrayList<>();
      /*  final String query = sql.getString("FIND_ALL_EXHIBITION");
        try{
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id_expo");
                long idCat = resultSet.getLong("id_cat");
                long idHall = resultSet.getLong("id_hall");
                String name = resultSet.getString("name_expo");
                Date date = resultSet.getDate("date_expo");
                long price = resultSet.getLong("price");

                Exhibition exhibition = new Exhibition.Builder()
                        .setIdExpo(id)
                        .setIdCategory(idCat)
                        .setIdExhibitionHall(idHall)
                        .setName(name)
                        .setDate(date)
                        .setPrice(price)
                        .build();
                exhibitionList.add(exhibition);
            }
        } catch (SQLException e) {
            log.error("SQL exception: " + e.getMessage());
            e.printStackTrace();
        }*/
        return exhibitionList;
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

    @Override
    public List<Exhibition> getSearchExhibition(long idHallParam, long idCatParam) {
        List<Exhibition> exhibitionList = new ArrayList<>();
        int counter = 1;
        Update update= new Update();
        update.setStrategy(idHallParam, idCatParam);
        final String query = sql.getString(update.execute());
        log.warn("strategy quey: " + query);
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            if(idHallParam != 0) {
                statement.setLong(counter, idHallParam);
                counter++;
            }
            if(idCatParam != 0) {
                statement.setLong(counter, idCatParam);
                counter++;
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id_expo");
                long idCat = resultSet.getLong("id_cat");
                long idHall = resultSet.getLong("id_hall");
                String name = resultSet.getString("name_expo");
                Date date = resultSet.getDate("date_expo");
                long price = resultSet.getLong("price");
                String hallName = resultSet.getString("name_hall");
                String catName = resultSet.getString("name_cat");

                Exhibition exhibition = new Exhibition.Builder()
                        .setIdExpo(id)
                        .setIdCategory(idCat)
                        .setIdExhibitionHall(idHall)
                        .setName(name)
                        .setDate(date)
                        .setPrice(price)
                        .setCatName(catName)
                        .setHallName(hallName)
                        .build();
                exhibitionList.add(exhibition);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exhibitionList;
    }
}
