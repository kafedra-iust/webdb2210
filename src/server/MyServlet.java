package server;

import logic.Person;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MyServlet", urlPatterns = {"*.html"})
public class MyServlet extends HttpServlet {
    @Resource(name = "jdbc/store")
    DataSource ds;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(
            Connection connection = ds.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from person");
            ResultSet resultSet = ps.executeQuery()) {
            List<Person> people = new ArrayList<>();
            while (resultSet.next()) {
                people.add(
                        new Person(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"))
                );
            }
            request.setAttribute("people", people);
            request.getRequestDispatcher("/people.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
