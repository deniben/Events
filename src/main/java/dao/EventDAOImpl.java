package dao;

import dbconnection.ConnectionUtils;
import model.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EventDAOImpl implements EventDAO {
    @Override
    public Event addEvent(Event event) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.getConnection(); //Connection to Database
        String query = "INSERT INTO public.\"event\"(name, location, tag, time_of_start, description) VALUES (?, ?, ?, ?, ?)"; //make query for DB that insert event
        // PrepStat - using for completing requests and preparing requests, formatting how we need
        PreparedStatement statement = connection.prepareStatement(query); // create PS Connection class
        // substitution instead of '?'
        statement.setString(1, event.getName());
        statement.setString(2, event.getLocation());
        statement.setString(3, event.getTag());
        Date date = event.getTimeOfBegin();
        statement.setDate(4, event.getTimeOfBegin());
        statement.setString(5, event.getDescription());
        statement.executeUpdate(); //execute SELECT, INSERT, DELETE... and back some edited rows
        statement.close(); //close
        connection.close();
        return null;
    }

    @Override
    public Event getEvent(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.getConnection();
        Event event = new Event();
        String query = "SELECT * FROM event WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();//execute SELECT command, which back data in ResulSet
        rs.next();

        event.setId(rs.getInt("id"));
        event.setName(rs.getString("name"));
        event.setDescription(rs.getString("description"));
        event.setLocation(rs.getString("location"));
        event.setTag(rs.getString("tag"));
        event.setTimeOfBegin(rs.getDate("time_of_start"));
        rs.close();
        statement.close();
        connection.close();
        return event;
    }

    @Override
    public Event updateEvent(Event event) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.getConnection();
        String query = "UPDATE event SET name=?, location=?, tag=?, description=?, time_of_start=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, event.getName());
        statement.setString(2, event.getLocation());
        statement.setString(3, event.getTag());
        statement.setString(4, event.getDescription());
        statement.setDate(5, event.getTimeOfBegin());
        statement.setInt(6, event.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();

        return event;
    }

    @Override
    public void removeEvent(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.getConnection();
        String query = "DELETE FROM event WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public List<Event> getAll() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.getConnection();
        List<Event> events = new ArrayList<>();
//         String query = "SELECT * FROM event";
         String query = "SELECT * FROM event ORDER BY time_of_start DESC";
         PreparedStatement statement = connection.prepareStatement(query);
         ResultSet rs = statement.executeQuery();
         while (rs.next()){
             events.add(new Event( rs.getInt("id"), rs.getString("name"), rs.getString("location"),rs.getString("tag"), rs.getDate("time_of_start"), rs.getString("description")));
         }
         rs.close();
         statement.close();
         connection.close();
        return events;
    }
}
