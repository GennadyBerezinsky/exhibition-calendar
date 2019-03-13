package controller.commands;

import model.entity.Category;
import model.entity.ExhibitionHall;
import model.service.ListGetterService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by User on 09.03.2019.
 */


public class GoToNewExhibitionCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        ListGetterService listGetterService = new ListGetterService();
        List<ExhibitionHall> exhibitionHallList = listGetterService.getHallList();
        List<Category> categoryList = listGetterService.getCategoryList();

        request.setAttribute("halls", exhibitionHallList);
        request.setAttribute("cats", categoryList);

        return "/WEB-INF/view/admin/newexhibition.jsp";
    }
}
