package model.dao;

import model.dao.mysql.JDBCDaoFactory;
import org.apache.log4j.Logger;

/**
 * Created by User on 06.03.2019.
 */


public abstract class DaoFactory {
    private static DaoFactory daoFactory;
    private static final Logger log = Logger.getLogger(DaoFactory.class);

    public abstract CategoryDao createCategoryDao();
    public abstract ExhibitionHallDao createExhibitionHallDao();
    public abstract ExhibitionDao createExhibitionDao();
    public abstract TicketDao createTicketDao();
    public abstract UserDao createUserDao();
    public abstract PaymentDao createPaymentDao();

    public static DaoFactory getInstance() {
        if(daoFactory == null) {
            synchronized (DaoFactory.class) {
                if(daoFactory == null) {
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
