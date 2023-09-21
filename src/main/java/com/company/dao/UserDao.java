package com.company.dao;

import com.company.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User> {
    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(User user) {
        String query = "insert into \"users\" (email, password, name, surname, gender, imgurl) values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, user.getEmail());
            st.setString(2, user.getPassword());
            st.setString(3, user.getName());
            st.setString(4, user.getSurname());
            st.setBoolean(5, user.getGender());
            st.setString(6, user.getImgurl());
            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {
        String query = "delete from \"users\" where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public User get(int id) {
        User user = null;
        String query = "select id, name, surname, email, password, gender, imgurl from \"users\" where id=?";
        System.out.println(user.getId());
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getBoolean("gender"),
                        rs.getString("imgurl"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String query = "select * from \"users\"";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                boolean gender = rs.getBoolean("gender");
                String imgurl = rs.getString("imgurl");
                users.add(new User(id, name, surname, email, password, gender, imgurl));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
