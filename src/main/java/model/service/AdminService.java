package model.service;

import model.dao.CategoryDao;
import model.dao.DaoFactory;
import model.dao.ExhibitionDao;
import model.dao.ExhibitionHallDao;
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
            DaoFactory factory = DaoFactory.getInstance();
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
            DaoFactory factory = DaoFactory.getInstance();
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
            DaoFactory factory = DaoFactory.getInstance();
            ExhibitionDao dao = factory.createExhibitionDao();
            dao.create(exhibition);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
            return 0;
        }
        return 1;
    }

}
