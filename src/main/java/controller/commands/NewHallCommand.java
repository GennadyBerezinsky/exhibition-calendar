package controller.commands;

import model.entity.ExhibitionHall;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 09.03.2019.
 */


public class NewHallCommand implements Command {

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
