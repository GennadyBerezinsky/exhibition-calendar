package model.dao.mysql;

import model.dao.*;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by User on 06.03.2019.
 */


public class JDBSDaoFactory extends DaoFactory {
    private static final Logger log = Logger.getLogger(JDBSDaoFactory.class);
    private DataSource dataSource = MySQLConnectionPoolHolder.getDataSource();

    private Connection getConnection() {
        try{
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public CategoryDao createCategoryDao() {
        return new MySQLCategoryDao(getConnection());
    }

    @Override
    public ExhibitionHallDao createExhibitionHallDao() {
        return new MySQLExhibitionHallDao(getConnection());
    }

    @Override
    public ExhibitionDao createExhibitionDao() {
        return new MySQLExhibitionDao(getConnection());
    }

    @Override
    public TicketDao createTicketDao() {
        return new MySQLTicketDao(getConnection());
    }

    @Override
    public UserDao createUserDao() {
        return new MySQLUserDao(getConnection());
    }

    @Override
    public PaymentDao createPaymentDao() {
        return new MySQLPaymentDao(getConnection());
    }
}
