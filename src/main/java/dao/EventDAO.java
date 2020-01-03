package dao;

import model.Event;

import java.sql.SQLException;
import java.util.List;

public interface EventDAO {
    Event addEvent(Event event) throws SQLException, ClassNotFoundException;
    Event getEvent(int id) throws SQLException, ClassNotFoundException;
    Event updateEvent(Event event) throws SQLException, ClassNotFoundException;
    void removeEvent(int id) throws SQLException, ClassNotFoundException;
    List<Event> getAll() throws SQLException, ClassNotFoundException;
}
