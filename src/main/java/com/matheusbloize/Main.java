package com.matheusbloize;

import java.sql.Connection;
import java.sql.SQLException;

import com.matheusbloize.persistence.migration.MigrationStrategy;
import com.matheusbloize.ui.MainMenu;

import static com.matheusbloize.persistence.config.ConnectionConfig.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = getConnection()) {
            new MigrationStrategy(connection).executeMigration();
        }
        new MainMenu().execute();
    }
}