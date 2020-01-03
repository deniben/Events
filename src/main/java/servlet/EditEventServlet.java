package servlet;

import model.Event;
import service.EventService;
import service.ModelValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EditEventServlet", value="/editEvent")
public class EditEventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Enter doPost");
        EventService eventService = new EventService();
        Event event = new Event();
//        int eventId=8;
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String location = request.getParameter("location");
        String timeOfBegin = request.getParameter("timeOfBegin");
        String tag = request.getParameter("tag");

        Event updatedEvent = new Event();

        updatedEvent.setId(eventId);
        updatedEvent.setTag(tag);
        Date date = Date.valueOf(timeOfBegin);
        updatedEvent.setTimeOfBegin(date);
        updatedEvent.setName(name);
        updatedEvent.setLocation(location);
        updatedEvent.setDescription(description);

        ModelValidator modelValidator = new ModelValidator();
        List<String> errors = modelValidator.validate(updatedEvent);

        try {
            if (errors.isEmpty()) {
                eventService.updateEvent(updatedEvent);
                request.setAttribute("AccessUpdated", "Event has been successfully updated");
                request.getRequestDispatcher("/successfull.jsp").forward(request, response);
            } else {
                request.setAttribute("errors", errors);
                request.setAttribute("errorUpdateEvent", "Error: The Event wasn't updated");
                request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("Enter doget");
        EventService eventService = new EventService();
        try {
            //TODO ERROR parseInt
            int eventid = Integer.parseInt(request.getParameter("eventId"));
            Event event = eventService.getEvent(eventid);
            request.setAttribute("event", event);
            request.getRequestDispatcher("/editEvent.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
