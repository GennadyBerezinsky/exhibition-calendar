package model.service;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.dao.mysql.JDBCDaoFactory;
import model.entity.User;
import org.apache.log4j.Logger;

/**
 * Created by User on 07.03.2019.
 */


public class AuthorizationService {
    private static final Logger log = Logger.getLogger(AuthorizationService.class);

    public User getUserByLogin(String login) {
        User user = null;
        try{
            DaoFactory factory = DaoFactory.getInstance();
            UserDao dao = factory.createUserDao();
            user = dao.findByLogin(login);
        } catch (Exception e) {
            log.error("exception: " + e.getMessage());
        }
        return user;
    }

    public boolean isExist(String login) {
        User user = null;
        try{
            DaoFactory factory = DaoFactory.getInstance();
            UserDao dao = factory.createUserDao();
            user = dao.findByLogin(login);
        } catch (Exception e) {
            log.error("exception: " + e.getMessage());
        }
        if(user.getLogin().equals(login)) {
            return true;
        }
        return false;
    }

    public void registration(User user) {
        try{

            DaoFactory factory = DaoFactory.getInstance();

            UserDao dao = factory.createUserDao();

            dao.create(user);
        } catch (Exception e) {
            log.error("exception: " + e.getStackTrace().toString());
        }
    }

}
