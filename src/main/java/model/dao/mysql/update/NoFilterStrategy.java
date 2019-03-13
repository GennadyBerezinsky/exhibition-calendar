package model.dao.mysql.update;

/**
 * Created by User on 12.03.2019.
 */


public class NoFilterStrategy implements Strategy {

    @Override
    public String getKey() {
        return "FIND_ALL_EXHIBITION";
    }
}
