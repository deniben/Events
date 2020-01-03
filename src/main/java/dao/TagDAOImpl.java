package dao;

import dbconnection.ConnectionUtils;
import model.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagDAOImpl implements TagDAO {

    @Override
    public Tag addTag(Tag tag) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.getConnection();
        String query = "INSERT INTO public.\"tags\"(name) VALUES (?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, tag.getTag());
        statement.executeUpdate();
        statement.close();
        connection.close();
        return null;

    }

    @Override
    public Tag getTag(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.getConnection();
        Tag tag = new Tag();
        String query = "SELECT * FROM tags WHERE tag_id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        tag.setId(resultSet.getInt("tag_id"));
        tag.setTag(resultSet.getString("name"));
        resultSet.close();
        statement.close();
        connection.close();
        return tag;

    }

    @Override
    public Tag updateTag(Tag tag) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.getConnection();
        String query = "UPDATE tags SET name = ? WHERE tag_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, tag.getTag());
        statement.setInt(2, tag.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
        return tag;
    }

    @Override
    public void removeTag(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.getConnection();
        String query = "DELETE FROM tags WHERE tag_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public List<Tag> getAll() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionUtils.getConnection();
        List<Tag> tags = new ArrayList<Tag>();
        String query = "SELECT * FROM tags";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            tags.add(new Tag(rs.getInt("tag_id"), rs.getString("name")));
        }
        rs.close();
        statement.close();
        connection.close();
        return tags;
    }
}
