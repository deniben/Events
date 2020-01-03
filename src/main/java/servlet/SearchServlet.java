package servlet;

import dbconnection.ConnectionUtils;
import model.Event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        // Pattern regex = Pattern.compile("^\\W");

        try {
            Connection connection = ConnectionUtils.getConnection();
            List<Event> events = new ArrayList<>(); //List events that search
            if (!(Pattern.matches("([\\w&&[^']])*", search))) {
                request.setAttribute("sqlProtection", "The symbol: ' forbidden to use");
                request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
            } else {
                if (search.equals("nearest")) {
                    String query = "SELECT * FROM event WHERE date(now()) < time_of_start ORDER BY time_of_start ASC";
                    PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet rs = statement.executeQuery();
                    while (rs.next()) {
                        events.add(new Event(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("location"),
                                rs.getString("tag"),
                                rs.getDate("time_of_start"),
                                rs.getString("description")));
                    }
                    rs.close();
                    statement.close();
                    if (!(events.isEmpty())) {
                        request.setAttribute("events", events);
                        request.setAttribute("nearestSearch", "The nearest events placed in descending from nearest to the furthest");
                        request.getRequestDispatcher("/searchview.jsp").forward(request, response);
                    } else {
                        request.setAttribute("SearchNotFount", "For Your request: '" + search + "' nothing found!");
                        request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
                    }
                } else {
                    String queryForName = "SELECT * FROM event WHERE name ILIKE '%" + search + "%'";
                    String queryForTag = "SELECT * FROM event WHERE tag ILIKE '%" + search + "%'";

                    PreparedStatement statement = connection.prepareStatement(queryForName);
                    ResultSet rs = statement.executeQuery();
                    while (rs.next()) {
                        events.add(new Event(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("location"),
                                rs.getString("tag"),
                                rs.getDate("time_of_start"),
                                rs.getString("description")));
                    }
                    rs.close();
                    statement.close();
                    PreparedStatement statementForTag = connection.prepareStatement(queryForTag);

                    ResultSet rsForTag = statementForTag.executeQuery();
                    while (rsForTag.next()) {
                        events.add(new Event(
                                rsForTag.getInt("id"),
                                rsForTag.getString("name"),
                                rsForTag.getString("location"),
                                rsForTag.getString("tag"),
                                rsForTag.getDate("time_of_start"),
                                rsForTag.getString("description")));
                    }
                    rsForTag.close();
                    statementForTag.close();
                    connection.close();
                    if (!(events.isEmpty())) {
                        request.setAttribute("searched", "For your search '<i>" + search + "</i>' was found '" + events.size() + "' events:");
                        request.setAttribute("events", events);
                        request.getRequestDispatcher("/searchview.jsp").forward(request, response);
                    } else {
                        request.setAttribute("SearchNotFount", "For Your request: '" + search + "' nothing found!");
                        request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
                    }
                }
            }
            } catch(ClassNotFoundException e){
                e.printStackTrace();
            } catch(SQLException e){
                e.printStackTrace();
            }


    }
}
