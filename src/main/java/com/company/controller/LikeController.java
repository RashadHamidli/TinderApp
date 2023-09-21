package com.company.controller;

import com.company.dao.LikeDAO;
import com.company.entity.Like;

import java.util.List;

public class LikeController {
    private final LikeDAO likeDAO;

    public LikeController(LikeDAO likeDAO) {
        this.likeDAO = likeDAO;
    }

    public void addLike(Like like) {
        if (isLikeExist(like)) {
            likeDAO.add(like);
        }
    }

    public void removeLike(int id) {
        likeDAO.remove(id);
    }

    public Like getLike(int id) {
        return likeDAO.get(id);
    }

    public List<Like> getAllLike() {
        return likeDAO.getAll();
    }

    public boolean isLikeExist(Like like) {
        return getAllLike()
                .stream()
                .anyMatch(l->(l.equals(like)));
    }

}
