package model.service;

import model.dao.CategoryDao;
import model.dao.ExhibitionHallDao;
import model.dao.mysql.JDBCDaoFactory;
import model.entity.Category;
import model.entity.ExhibitionHall;

import java.util.List;

/**
 * Created by User on 10.03.2019.
 */


public class ExhibitionCreationService {

    public List<ExhibitionHall> getHallList() {
        JDBCDaoFactory factory = new JDBCDaoFactory();
        ExhibitionHallDao dao = factory.createExhibitionHallDao();
        return dao.findAll();
    }

    public List<Category> getCategoryList() {
        JDBCDaoFactory factory = new JDBCDaoFactory();
        CategoryDao dao = factory.createCategoryDao();
        return dao.findAll();
    }

}
