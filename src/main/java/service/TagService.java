package service;

import dao.TagDAOImpl;
import model.Tag;
import service.interfaceservice.ITagService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagService implements ITagService {
    private TagDAOImpl tagDAO = new TagDAOImpl();


    @Override
    public Tag insertTag(Tag tag) throws SQLException, ClassNotFoundException {
        return tagDAO.addTag(tag);
    }

    @Override
    public Tag getTag(int id) throws SQLException, ClassNotFoundException {
        return tagDAO.getTag(id);
    }

    @Override
    public Tag updateTag(Tag tag) throws SQLException, ClassNotFoundException {
        return tagDAO.updateTag(tag);
    }

    @Override
    public void deleteTag(int id) throws SQLException, ClassNotFoundException {
        tagDAO.removeTag(id);

    }

    @Override
    public List<Tag> getAll() throws SQLException, ClassNotFoundException {
        return tagDAO.getAll();
    }

    @Override
    public List<Tag> getTagsByListOfStringId(List<String> listOfTagsId) throws SQLException {
        List<Tag> tags = new ArrayList<>();
        TagService tagService = new TagService();
        for (String tagId : listOfTagsId){
            try {
                tags.add(tagService.getTag(Integer.parseInt(tagId)));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return tags;
    }

}
