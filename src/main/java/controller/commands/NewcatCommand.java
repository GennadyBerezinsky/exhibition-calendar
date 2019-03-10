package controller.commands;

import model.entity.Category;
import model.service.AdminService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 09.03.2019.
 */


public class NewcatCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String catname = request.getParameter("catname").toLowerCase().trim();
        AdminService adminService = new AdminService();
        Category category = new Category.Builder()
                .setName(catname)
                .build();

        adminService.newCat(category);
        return "redirect: /admin";
    }
}
