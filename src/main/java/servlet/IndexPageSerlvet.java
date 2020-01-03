package servlet;

import model.Event;
import model.Tag;
import service.EventService;
import service.TagService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "IndexPageSerlvet", value = "/index")
public class IndexPageSerlvet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO work with tags
        TagService tagService = new TagService();
        List<Tag> tags;
        try {
            tags = tagService.getAll();
            request.setCharacterEncoding("UTF-8");
            List<Event> events = new EventService().getAll();

            request.setAttribute("tags", tags);
            request.setAttribute("events", events);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
