package servlet;

import model.Event;
import service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RemoveEventServlet", value = "/removeEvent")
public class RemoveEventServlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("Enter doPost");


        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("Enter doGet");
            EventService eventService = new EventService();
            try {
                //TODO ERROR parseInt
                int eventId = Integer.parseInt(request.getParameter("eventId"));
                eventService.removeEvent(eventId);
                request.setAttribute("successedRemove", "The event was success removed");
                request.getRequestDispatcher("/successfull.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
    }

