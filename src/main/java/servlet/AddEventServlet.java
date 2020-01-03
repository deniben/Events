package servlet;

import dao.EventTagsDAOImpl;
import model.Event;
import model.Tag;
import service.EventService;
import service.ModelValidator;
import service.TagService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "AddEventServlet", urlPatterns = "/addEvent")
public class AddEventServlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("Enter doPost");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String location = request.getParameter("location");
            String tag = request.getParameter("tag");

            String timeOfBegin = request.getParameter("timeOfBegin");
            Date date= Date.valueOf(timeOfBegin);

            Event event = new Event();
            event.setName(name);
            event.setDescription(description);
            event.setLocation(location);
            event.setTag(tag);
            event.setTimeOfBegin(date);

            EventService eventService = new EventService();
            ModelValidator modelValidator = new ModelValidator();
            List<String> errors = modelValidator.validate(event);
                if (errors.isEmpty()) {
                    try {
                        eventService.addEvent(event);
                        request.setAttribute("accessAddedEvent", "Your event has been successfully added!");
                        request.getRequestDispatcher("/successfull.jsp").forward(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    request.setAttribute("errors", errors);
                    request.setAttribute("errorAddEvent", "Error: The Event wasn't add");
                    request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
                }
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            System.out.println("Enter doGet");

                request.getRequestDispatcher("/addEvent.jsp").forward(request, response);

        }
    }
