package dao;

import dbconnection.ConnectionUtils;
import model.Event;
import model.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
//TODO doesn't realize
public class EventTagsDAOImpl implements EventTagsDAO {
    @Override
    public Event getEventBySearch(Event event) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.getConnection();

        String name = event.getName();
        String description = event.getDescription();
        String location = event.getLocation();
        String query = "SELECT * FROM event WHERE name = ?, description = ?, location = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, description);
        statement.setString(3, location);
//        ResultSet rs = statement.executeQuery();
//        rs.next();
//        Event searchEvent = new Event(
//                rs.getInt("id"),
//                rs.getString("name"),
//                rs.getString("location"),
//                rs.getString("tag"),
//                rs.getDate("time_of_start"),
//                rs.getString("description"));
        return null;
    }

    @Override
    public void addEventAndTagsId(Event event, List<Tag> tags) throws SQLException, ClassNotFoundException {

    }
}
