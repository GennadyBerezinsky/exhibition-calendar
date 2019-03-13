package controller.commands;

import model.entity.Category;
import model.entity.Exhibition;
import model.entity.ExhibitionHall;
import model.service.ListGetterService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by User on 11.03.2019.
 */


public class UpdateCommand implements Command {
    private static final Logger log = Logger.getLogger(UpdateCommand.class);

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

        log.trace("ids: hsll cat " + hall + " " + cat);
        return "/WEB-INF/view/user/selectexhibition.jsp";
    }
}
