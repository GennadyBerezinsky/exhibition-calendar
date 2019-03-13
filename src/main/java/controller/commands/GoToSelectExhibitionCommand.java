package controller.commands;

import model.entity.Category;
import model.entity.Exhibition;
import model.entity.ExhibitionHall;
import model.service.ListGetterService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10.03.2019.
 */


public class GoToSelectExhibitionCommand implements Command {
    private static final Logger log = Logger.getLogger(GoToSelectExhibitionCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        ListGetterService service = new ListGetterService();

        List<ExhibitionHall> halls = service.getHallList();
        List<Category> cats = service.getCategoryList();
        List<Exhibition> exhibitionList = service.getStatusExhibition(0, 0);

        log.info("size: " + exhibitionList.size());

        request.setAttribute("halls", halls);
        request.setAttribute("cats", cats);
        request.setAttribute("expos", exhibitionList);

        return "/WEB-INF/view/user/selectexhibition.jsp";
    }
}
