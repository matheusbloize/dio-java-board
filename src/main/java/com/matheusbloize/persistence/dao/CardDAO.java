package com.matheusbloize.persistence.dao;

import java.sql.Connection;

import com.matheusbloize.dto.CardDetails;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CardDAO {

    private Connection connection;

    public CardDetails findById(final Long id) {
        return null;
    }

}