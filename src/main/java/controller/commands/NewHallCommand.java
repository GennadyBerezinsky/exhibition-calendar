package controller.commands;

import model.entity.ExhibitionHall;
import model.service.AdminService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 09.03.2019.
 */


public class NewHallCommand implements Command {
    private static final Logger log = Logger.getLogger(NewHallCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("hallname");
        String address = request.getParameter("halladdress");

        ExhibitionHall hall = new ExhibitionHall.Builder()
                .setNameHall(name)
                .setAddress(address)
                .build();

        AdminService service = new AdminService();
        service.newHall(hall);

        return "redirect: /admin";
    }
}
