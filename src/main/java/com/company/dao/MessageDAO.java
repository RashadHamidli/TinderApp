package com.company.dao;

import com.company.entity.Message;

import java.util.List;

public class MessageDAO implements DAO<Message>{

    @Override
    public void add(Message message) {
//        String query="insert into \"message\" ("
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Message get(int id) {
        return null;
    }

    @Override
    public List<Message> getAll() {
        return null;
    }
}
