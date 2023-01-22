package com.hansen.sqlitetopostgres.service;

import com.hansen.sqlitetopostgres.entity.postgres.TableB;
import com.hansen.sqlitetopostgres.model.Data;
import com.hansen.sqlitetopostgres.repo.postgres.TableARepository;
import com.hansen.sqlitetopostgres.repo.postgres.TableBRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostgresPersistenceServiceImpl implements PostgresPersistenceService {

    @Autowired
    private TableARepository tableARepository;

    @Autowired
    private TableBRepository tableBRepository;

    @Override
    public void translateToPostgres(Data SQLiteData) {
        new Thread(() -> doAsyncTranslateToPostgres(SQLiteData)).start();
    }
    private void doAsyncTranslateToPostgres(Data SQLiteData){
        List<com.hansen.sqlitetopostgres.entity.postgres.TableA> postgresTableAData =
                SQLiteData.getTableAList().stream()
                        .map(com.hansen.sqlitetopostgres.entity.postgres.TableA::transformSQLiteTableA)
                        .collect(Collectors.toList());

        if(postgresTableAData == null || postgresTableAData.isEmpty()){
            return;
        }

        List<com.hansen.sqlitetopostgres.entity.postgres.TableB> postgresTableBData =
                SQLiteData.getTableBList().stream()
                        .map(com.hansen.sqlitetopostgres.entity.postgres.TableB::transformSQLiteTableB)
                        .collect(Collectors.toList());

        if(postgresTableBData == null || postgresTableBData.isEmpty()){
            return;
        }

        persistToPostgres(postgresTableAData, postgresTableBData);
    }

    private void persistToPostgres(List<com.hansen.sqlitetopostgres.entity.postgres.TableA> tableAList,
                                   List<TableB> tableBList)
    {
        tableARepository.saveAll(tableAList);
        tableBRepository.saveAll(tableBList);
        log.info("Data persisted to PostgreSQL.");
    }

}
