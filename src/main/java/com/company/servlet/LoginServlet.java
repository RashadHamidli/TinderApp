package com.company.servlet;

import com.company.Utils.FreemarkerEngine;
import com.company.controller.UserController;
import com.company.dao.UserDAO;
import com.company.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {

    private final Connection connection;
    private UserController userController;
    private final FreemarkerEngine f = new FreemarkerEngine();

//    private CookieService cookieService;

    public LoginServlet(Connection connection) {
        this.connection = connection;
        this.userController = new UserController(new UserDAO(connection));
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        f.render(rs, "login.ftl", new HashMap<>());

    }


    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {

        String email = rq.getParameter("email");
        String password = rq.getParameter("password");
        User user = new User(email, password);

//        int uID = userController.getUserId(user);
//        cookieService = new CookieService(rq, rs);
//        cookieService.addCookie(uID);
        rs.sendRedirect("/users");

    }
}
