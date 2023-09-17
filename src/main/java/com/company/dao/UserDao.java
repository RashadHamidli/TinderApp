package com.company.dao;

import com.company.db.DBConnect;
import com.company.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UserDao implements Dao<User> {
    private final Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(User user) {
        String query = "INSERT INTO users (name, surname, email, password) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.executeUpdate();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
