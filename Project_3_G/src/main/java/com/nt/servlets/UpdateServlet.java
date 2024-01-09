package com.nt.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;

import com.nt.entity.items;
import com.nt.service.BankService;
import com.nt.util.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        // Retrieve BankService from the session
        BankService bankService = (BankService) session.getAttribute("BankService");
        Session ses = null;

        try {
            ses = util.getSession();

            // Retrieve or create items instance in session
            items i = (items) session.getAttribute("items");
            if (i == null) {
                i = new items();
                session.setAttribute("items", i);
            }

            String name = request.getParameter("name");
            String count = request.getParameter("count");

            // Check if a transaction is already active
            if (!ses.getTransaction().isActive()) {
                ses.beginTransaction();
            }

            items updatedItem = bankService.update(name, count, i);

            boolean recordFound = (updatedItem != null);

            if (recordFound) {
                // Set the record information in request attributes
                request.setAttribute("recordFound", true);
                request.setAttribute("recordInfo", updatedItem);
            } else {
                ses.getTransaction().commit();
                request.setAttribute("recordFound", false);
            }

            // Forward to update.jsp after setting request attributes
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();

            if (ses != null && ses.getTransaction().isActive()) {
                ses.getTransaction().rollback();
            }
        } finally {
            if (ses != null && ses.isOpen()) {
                ses.close();
            }
        }
    }
}
