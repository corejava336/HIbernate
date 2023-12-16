package com.nt.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.nt.entity.bank;
import com.nt.service.BankService;
import com.nt.util.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        BankService bankService = new BankService();
        HttpSession session = request.getSession();
        bank BankEntity = new bank();
        Session ses = null;

        try {
            ses = util.getSession();
            ses.beginTransaction();

            session.setAttribute("BankService", bankService);
            session.setAttribute("BankEntity", BankEntity);
            boolean loginSuccess = bankService.login(request.getParameter("name"), request.getParameter("password"));

            if (loginSuccess) {
                // Commit transaction only if successfully started
                if (ses.getTransaction().getStatus() == TransactionStatus.ACTIVE) {
                    ses.getTransaction().commit();
                }
                request.getRequestDispatcher("/welcome.jsp").forward(request, response);
            } else {
                // Rollback transaction and forward to login error page
                if (ses.getTransaction().getStatus() == TransactionStatus.ACTIVE) {
                    ses.getTransaction().rollback();
                }
                out.println("Record not found");
                request.getRequestDispatcher("/loginError.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Handle exceptions, log, or rethrow if needed
            e.printStackTrace();

            // Rollback transaction in case of exception
            if (ses != null && ses.getTransaction().getStatus() == TransactionStatus.ACTIVE) {
                ses.getTransaction().rollback();
            }
        } finally {
            // Close the session in the finally block to ensure it's closed even if an exception occurs
            if (ses != null && ses.isOpen()) {
                ses.close();
            }
        }
    }
}



/*
 * @WebServlet("/LoginServlet") public class LoginServlet extends HttpServlet {
 * private static final long serialVersionUID = 1L;
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { PrintWriter out =
 * response.getWriter(); String name = request.getParameter("name"); String
 * password = request.getParameter("password"); HttpSession session =
 * request.getSession(); BankService bankService = new BankService();
 * session.setAttribute("BankService", bankService); bank BankEntity = new
 * bank(); // Assuming bank is your entity class
 * session.setAttribute("BankEntity", BankEntity); boolean loginSuccess =
 * bankService.login(name, password);
 * 
 * if (loginSuccess) {
 * request.getRequestDispatcher("/welcome.jsp").forward(request, response); }
 * else { out.println("Record not found"); response.sendRedirect("signup.jsp");
 * } } }
 */