package model.dao;

import model.entity.Exhibition;

import java.util.List;

public interface ExhibitionDao extends GenericDao<Exhibition> {
    List<Exhibition> getSearchExhibition(long idHall, long idCat);
}
