package controller.commands;

import model.entity.Exhibition;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by User on 09.03.2019.
 */


public class NewExhibitionCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        AdminService service = new AdminService();

        long idHall = Long.parseLong(request.getParameter("hall"));
        long idCat = Long.parseLong(request.getParameter("cat"));
        Date date = Date.valueOf(request.getParameter("date"));
        long price = Long.parseLong(request.getParameter("price"));
        String name = request.getParameter("exhname");

        Exhibition exhibition = new Exhibition.Builder()
                .setDate(date)
                .setIdExhibitionHall(idHall)
                .setIdCategory(idCat)
                .setName(name)
                .setPrice(price)
                .build();
        service.newExhibition(exhibition);
        return "redirect: /admin";
    }
}
