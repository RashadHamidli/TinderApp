package com.company.dao;

import com.company.entity.Like;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikeDAO implements DAO<Like> {
    private final Connection connection;

    public LikeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Like like) {
        String query = "insert into \"like\" (liker_id, liked_id) values (?,?) ";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, like.getLikerId());
            st.setInt(2, like.getLikedId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {
        String query = "delete from \"like\" where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Like get(int id) {
        Like like = null;
        String query = "select id,liker_id, liked_id from \"like\" where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                like = new Like(
                        rs.getInt("id"),
                        rs.getInt("liker_id"),
                        rs.getInt("liked_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return like;
    }

    @Override
    public List<Like> getAll() {
        List<Like> likes = new ArrayList<>();
        String query = "select * from \"like\"";
        try {
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int likerId = rs.getInt("liker_id");
                int likedId = rs.getInt("liked_id");
                likes.add(new Like(id, likerId, likedId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return likes;
    }
}
