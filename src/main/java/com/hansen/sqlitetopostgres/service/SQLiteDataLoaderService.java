package com.hansen.sqlitetopostgres.service;

import com.hansen.sqlitetopostgres.model.Data;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;

public interface SQLiteDataLoaderService {
    Data loadSQLiteData(Path pathToSQLite, String uuid) throws IOException, SQLException;
}
