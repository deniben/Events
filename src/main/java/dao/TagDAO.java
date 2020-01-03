package dao;

import model.Tag;

import java.sql.SQLException;
import java.util.List;

public interface TagDAO {
    Tag addTag(Tag tag) throws SQLException, ClassNotFoundException;
    Tag getTag(int id) throws SQLException, ClassNotFoundException;
    Tag updateTag(Tag tag) throws SQLException, ClassNotFoundException;
    void removeTag(int id) throws SQLException, ClassNotFoundException;
    List<Tag> getAll() throws SQLException, ClassNotFoundException;

}
