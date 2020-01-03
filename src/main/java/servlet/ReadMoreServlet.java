package servlet;

import model.Event;
import model.Tag;
import service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ReadMoreServlet", value = "/readmore")
public class ReadMoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventService eventService = new EventService();

        try {
            Event event = eventService.getEvent(Integer.parseInt(request.getParameter("eventId")));
            List<Tag> tags = event.getTags();
//            for(Tag tag : tags){
//                System.out.println(tag);
//            }
            request.setAttribute("tags", tags);
            request.setAttribute("event", event);
            request.getRequestDispatcher("/readMore.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
