package com.matheusbloize.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.matheusbloize.persistence.dao.CardDAO;
import com.matheusbloize.persistence.entity.CardEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CardService {

    private final Connection connection;

    public CardEntity create(final CardEntity entity) throws SQLException {
        try {
            var dao = new CardDAO(connection);
            dao.insert(entity);
            connection.commit();
            return entity;
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        }
    }

}