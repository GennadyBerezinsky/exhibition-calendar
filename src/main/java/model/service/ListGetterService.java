package model.service;

import model.dao.CategoryDao;
import model.dao.DaoFactory;
import model.dao.ExhibitionDao;
import model.dao.ExhibitionHallDao;
import model.entity.Category;
import model.entity.Exhibition;
import model.entity.ExhibitionHall;

import java.util.List;

/**
 * Created by User on 10.03.2019.
 */


public class ListGetterService {

    public List<ExhibitionHall> getHallList() {
        DaoFactory factory = DaoFactory.getInstance();
        ExhibitionHallDao dao = factory.createExhibitionHallDao();
        return dao.findAll();
    }

    public List<Category> getCategoryList() {
        DaoFactory factory = DaoFactory.getInstance();
        CategoryDao dao = factory.createCategoryDao();
        return dao.findAll();
    }

    public List<Exhibition> getExhibitionList() {
        DaoFactory factory = DaoFactory.getInstance();
        ExhibitionDao dao = factory.createExhibitionDao();
        return dao.findAll();
    }

    public List<Exhibition> getStatusExhibition(long idHall, long idCat) {
        DaoFactory factory = DaoFactory.getInstance();
        ExhibitionDao dao = factory.createExhibitionDao();
        return dao.getSearchExhibition(idHall, idCat);
    }

}
