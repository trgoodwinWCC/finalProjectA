package db_persons;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.ConnectionPool;

public class DB_PersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
        ServletContext servletContext = getServletContext();
        ConnectionPool connectionPool = (ConnectionPool) servletContext.getAttribute("connectionPool");

        Connection connection;
        Statement statement;
        String errorMessage = "";
        try {
            connection = connectionPool.getConnection();
            statement = connection.createStatement();

            if (statement != null) {
                errorMessage = DB_PersonCollection.update(statement, request);
                statement.close();
            }

            if (connection != null) {
                connectionPool.free(connection);
            }
        } catch (SQLException ex) {
            errorMessage = ex.toString();
        }

        request.setAttribute("errorMessage", errorMessage);
        }finally {
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher("/db_personCollection.jsp");

        dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}