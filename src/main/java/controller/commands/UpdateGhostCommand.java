package controller.commands;

import model.entity.Category;
import model.entity.Exhibition;
import model.entity.ExhibitionHall;
import model.service.ListGetterService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by User on 13.03.2019.
 */


public class UpdateGhostCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        ListGetterService service = new ListGetterService();

        long hall = Long.parseLong(request.getParameter("hall"));
        long cat = Long.parseLong(request.getParameter("cat"));
        List<ExhibitionHall> halls = service.getHallList();
        List<Category> cats = service.getCategoryList();
        List<Exhibition> exhibitionList = service.getStatusExhibition(hall, cat);


        request.setAttribute("halls", halls);
        request.setAttribute("cats", cats);
        request.setAttribute("expos", exhibitionList);

        return "/WEB-INF/view/user/selectexhibitiong.jsp";
    }
}
