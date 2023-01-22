package com.hansen.sqlitetopostgres.service;

import com.hansen.sqlitetopostgres.model.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
@Slf4j
public class SQLiteDataLoaderServiceImpl implements SQLiteDataLoaderService{

    @Override
    public Data loadSQLiteData(Path pathToSQLite) {
        return null;
    }
}
