package com.hansen.sqlitetopostgres.service;

import com.hansen.sqlitetopostgres.model.Data;

public interface PostgresPersistenceService {
    void translateToPostgres(Data SQLiteData);
}
