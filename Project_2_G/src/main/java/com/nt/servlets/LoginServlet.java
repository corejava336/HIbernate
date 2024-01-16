package com.nt.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get parameters from the request
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        // Assuming a simple validation for demonstration
        if ("y".equals(name) && "123".equals(password)) {
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
