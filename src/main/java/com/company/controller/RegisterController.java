package com.company.controller;

import com.company.dao.UserDao;
import com.company.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class RegisterController extends HttpServlet {
    public UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            User user = new User(name, surname, email, password);
            userDao.add(user);
            request.getSession().setAttribute("loggedInUser", user);

            response.sendRedirect("login");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
