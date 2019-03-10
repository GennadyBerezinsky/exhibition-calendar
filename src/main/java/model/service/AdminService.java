package model.service;

import model.dao.CategoryDao;
import model.dao.ExhibitionDao;
import model.dao.ExhibitionHallDao;
import model.dao.mysql.JDBCDaoFactory;
import model.entity.Category;
import model.entity.Exhibition;
import model.entity.ExhibitionHall;
import org.apache.log4j.Logger;

/**
 * Created by User on 09.03.2019.
 */


public class AdminService {
    private static final Logger log = Logger.getLogger(AdminService.class);

    public int newCat(Category cat) {
        try{
            JDBCDaoFactory factory = new JDBCDaoFactory();
            CategoryDao dao = factory.createCategoryDao();
            dao.create(cat);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
            return 0;
        }
        return 1;
    }

    public int newHall(ExhibitionHall hall) {
        try{
            JDBCDaoFactory factory = new JDBCDaoFactory();
            ExhibitionHallDao dao = factory.createExhibitionHallDao();
            dao.create(hall);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
            return 0;
        }
        return 1;
    }

    public int newExhibition(Exhibition exhibition) {
        try{
            JDBCDaoFactory factory = new JDBCDaoFactory();
            ExhibitionDao dao = factory.createExhibitionDao();
            dao.create(exhibition);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
            return 0;
        }
        return 1;
    }

}
