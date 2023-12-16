package com.nt.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;

import com.nt.entity.bank;
import com.nt.service.BankService;
import com.nt.util.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        bank BankEntity = (bank) session.getAttribute("BankEntity");
        BankService bankService = (BankService) session.getAttribute("BankService");

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        boolean signupSuccess = bankService.signup(name, password, BankEntity);

        if (signupSuccess) {
            out.println("Signup successful");
            response.sendRedirect("login.jsp");
            // Redirect or forward to success page
        } else {
            out.println("Signup failed");
            response.sendRedirect("signupError.jsp");
            // Redirect or forward to error page
        }
    }
}

