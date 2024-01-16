package com.nt.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get parameters from the request
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // Assuming a simple validation for demonstration
        if ("yourUsername".equals(name) && "yourPassword".equals(password)) {
            // Set attributes to be used in welcome.jsp
            request.setAttribute("name", name);

            // Forward the request to welcome.jsp
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        } else {
            // Redirect back to login.jsp if credentials are invalid
            response.sendRedirect("login.jsp");
        }
    }
}
