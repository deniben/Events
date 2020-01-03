package service;

import dao.EventDAOImpl;
import model.Event;
import service.interfaceservice.IEventService;

import java.sql.SQLException;
import java.util.List;

public class EventService implements IEventService {
    private EventDAOImpl eventDAO = new EventDAOImpl();
    @Override
    public Event addEvent(Event event) throws SQLException, ClassNotFoundException {
        return eventDAO.addEvent(event);
    }

    @Override
    public Event getEvent(int id) throws SQLException, ClassNotFoundException {
        return eventDAO.getEvent(id);
    }

    @Override
    public Event updateEvent(Event event) throws SQLException, ClassNotFoundException {
        return eventDAO.updateEvent(event);
    }

    @Override
    public void removeEvent(int id) throws SQLException, ClassNotFoundException {
        eventDAO.removeEvent(id);
    }

    @Override
    public List<Event> getAll() throws SQLException, ClassNotFoundException {
        return eventDAO.getAll();
    }


}
