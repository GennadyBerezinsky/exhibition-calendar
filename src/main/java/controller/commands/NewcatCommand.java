package controller.commands;

import model.entity.Category;
import model.service.AdminService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 09.03.2019.
 */


public class NewcatCommand implements Command {
    private static final Logger log = Logger.getLogger(NewcatCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String catname = request.getParameter("catname").toLowerCase().trim();
        AdminService adminService = new AdminService();
        Category category = new Category.Builder()
                .setName(catname)
                .build();

        adminService.newCat(category);
        log.info("category " + catname + " created");
        return "redirect: /admin";
    }
}
