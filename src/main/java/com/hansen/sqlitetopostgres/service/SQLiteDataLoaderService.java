package com.hansen.sqlitetopostgres.service;

import com.hansen.sqlitetopostgres.model.Data;

import java.nio.file.Path;

public interface SQLiteDataLoaderService {
    Data loadSQLiteData(Path pathToSQLite);
}
