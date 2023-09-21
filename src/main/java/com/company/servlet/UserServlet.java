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
import java.util.List;

public class UserServlet extends HttpServlet {

    private final Connection connection;
    private UserController userController;
//    private LikeService likeService;
    private final FreemarkerEngine f = new FreemarkerEngine();
//    private CookieService ck;
    private static int counter = 0;
    public UserServlet(Connection connection) {
        this.connection = connection;
        this.userController = new UserController(new UserDAO(connection));
//        this.likeService = new LikeService(new LikeDao(connection));
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
//        ck = new CookieService(rq, rs);
//        int id = Integer.parseInt(ck.getCookie().getValue());
        List<User> allUsers = userController.getAllUsers(1);/////
        User user = allUsers.get(counter++);
        HashMap<String, Object> data = new HashMap<>();
        data.put("user", user);
        f.render(rs, "like-page.ftl", data);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {

//        ck = new CookieService(rq, rs);
//        int likerId = Integer.parseInt(ck.getCookie().getValue());
//        int likedId = Integer.parseInt(rq.getParameter("likedId"));
//        Like like = new Like(likerId, likedId);
//
//        if (rq.getParameter("like") != null) {
//            likeService.addLike(like);
//        }
//        else if (rq.getParameter("dislike") != null){
//            if(likeService.isLikeExist(like)){
//                likeService.removeLike(likeService.getLikeId(like));
//            }
//        }
//
//
//        if(counter == userController.getAllUsers(likerId).size()){
//            counter = 0;
//            rs.sendRedirect("/liked");
//        }
//        else{
//            doGet(rq, rs);
//        }
    }
}