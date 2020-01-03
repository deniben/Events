package servlet;

import model.Tag;
import service.TagService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
//TODO DOESN'T REALIZE
@WebServlet(name = "AddTagServlet", value = "/addTag")
public class AddTagServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TagService tagService = new TagService();
        Tag tag = new Tag();
        tag.setTag(request.getParameter("tag"));
        try {
            tagService.insertTag(tag);
            request.setAttribute("accessAddedTag", "Your tag has been successfully added!");
            request.getRequestDispatcher("/successfull.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("Enter doGet");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/addTag.jsp");
        requestDispatcher.forward(request, response);
    }
}
