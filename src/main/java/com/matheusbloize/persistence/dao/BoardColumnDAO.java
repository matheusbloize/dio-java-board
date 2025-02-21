package com.matheusbloize.persistence.dao;

import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.matheusbloize.persistence.entity.BoardColumnEntity;

@RequiredArgsConstructor
public class BoardColumnDAO {

    private final Connection connection;

    public BoardColumnEntity insert(final BoardColumnEntity entity) throws SQLException {
        var sql = "INSERT INTO BOARDS_COLUMNS (name, \"order\", kind, board_id) VALUES (?, ?, ?, ?) RETURNING id;";
        try (var statement = connection.prepareStatement(sql)) {
            var i = 1;
            statement.setString(i++, entity.getName());
            statement.setInt(i++, entity.getOrder());
            statement.setString(i++, entity.getKind().name());
            statement.setLong(i, entity.getBoard().getId());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    entity.setId(resultSet.getLong("id"));
                }
            }
            return entity;
        }
    }

    public List<BoardColumnEntity> findByBoardId(final Long id) throws SQLException {
        return null;
    }
}