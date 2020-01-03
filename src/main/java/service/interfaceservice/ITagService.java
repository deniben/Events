package service.interfaceservice;

import model.Tag;

import java.sql.SQLException;
import java.util.List;

public interface ITagService {
    Tag insertTag(Tag tag) throws SQLException, ClassNotFoundException;
    Tag getTag(int id) throws SQLException, ClassNotFoundException;
    Tag updateTag(Tag tag) throws SQLException, ClassNotFoundException;
    void deleteTag(int id) throws SQLException, ClassNotFoundException;
    List<Tag> getAll() throws SQLException, ClassNotFoundException;
    List<Tag> getTagsByListOfStringId(List<String> listOfTagsId) throws SQLException;

}
