package com.hansen.sqlitetopostgres.service;

//import com.hansen.sqlitetopostgres.config.PersistenceSQLiteOnDemandConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hansen.sqlitetopostgres.entity.postgres.TableA;
import com.hansen.sqlitetopostgres.entity.postgres.TableB;
import com.hansen.sqlitetopostgres.model.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class SQLiteDataLoaderServiceImpl implements SQLiteDataLoaderService{
    String tableAQuery = "SELECT * FROM TableA";
    String tableBQuery = "SELECT * FROM TableB";

    @Override
    public Data loadSQLiteData(Path pathToSQLite, String uuid) throws IOException, SQLException {
        Connection conn = connect(pathToSQLite);
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(tableAQuery);
        List<TableA> tableAList = new ArrayList<>();

        while (rs.next()) {
            TableA tableA = new TableA(
                    UUID.fromString(rs.getString(1)),
                    rs.getString(2)
                    ,rs.getInt(3));
            tableAList.add(tableA);
        }

        rs    = stmt.executeQuery(tableBQuery);
        List<TableB> tableBList = new ArrayList<>();

        while (rs.next()) {
            TableB tableB = new TableB(rs.getLong(1) ,rs.getString(2));
            tableBList.add(tableB);
        }

        conn.close();
        Files.delete(pathToSQLite);

        return Data.builder()
                .tableAList(tableAList)
                .tableBList(tableBList)
                .build();

    }

    public Connection connect(Path SQLiteFilePath) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:"+SQLiteFilePath.toFile().getAbsolutePath();
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            log.info("Connection to SQLite has been established.");

        } catch (SQLException e) {
            log.warn(e.getMessage());
        }
        return conn;
    }
}
