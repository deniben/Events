package dao;

import model.Event;
import model.Tag;

import java.sql.SQLException;
import java.util.List;

//TODO doesn't realize
public interface EventTagsDAO {
    void addEventAndTagsId(Event event, List<Tag> tags) throws SQLException, ClassNotFoundException;
    Event getEventBySearch(Event event) throws SQLException, ClassNotFoundException;

}
