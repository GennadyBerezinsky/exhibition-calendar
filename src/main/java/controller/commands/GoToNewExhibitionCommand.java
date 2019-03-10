package controller.commands;

import model.entity.Category;
import model.entity.ExhibitionHall;
import model.service.AdminService;
import model.service.ExhibitionCreationService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by User on 09.03.2019.
 */


public class GoToNewExhibitionCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        ExhibitionCreationService exhibitionCreationService = new ExhibitionCreationService();
        List<ExhibitionHall> exhibitionHallList = exhibitionCreationService.getHallList();
        List<Category> categoryList = exhibitionCreationService.getCategoryList();

        request.setAttribute("halls", exhibitionHallList);
        request.setAttribute("cats", categoryList);

        return "/WEB-INF/view/admin/newexhibition.jsp";
    }
}
