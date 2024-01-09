package com.nt.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.nt.entity.items;
import com.nt.service.BankService;
import com.nt.util.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = (HttpSession) request.getSession();

        // Retrieve BankService from the session
        BankService bankService = (BankService) session.getAttribute("BankService");
        Session ses = null;

        try {
            ses = util.getSession();
            ses.beginTransaction();

            // Retrieve or create items instance in session
            items i = (items) session.getAttribute("items");
            if (i == null) {
                i = new items();
                session.setAttribute("items", i);
            }

            items addSuccess = bankService.search(request.getParameter("name"));

            boolean recordFound = (addSuccess != null);

            if (recordFound) {
                // Set the record information in request attributes
                request.setAttribute("recordFound", true);
                request.setAttribute("recordInfo", addSuccess);
            } else {
                if (ses.getTransaction().getStatus() == TransactionStatus.ACTIVE) {
                    ses.getTransaction().commit();
                }
                request.setAttribute("recordFound", false);
            }

            // Forward to add.jsp after setting request attributes
            request.getRequestDispatcher("/search.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();

            if (ses != null && ses.getTransaction().getStatus() == TransactionStatus.ACTIVE) {
                ses.getTransaction().rollback();
            }
        } finally {
            if (ses != null && ses.isOpen()) {
                ses.close();
            }
        }
    }
}
