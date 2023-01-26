package com.hansen.sqlitetopostgres.service;

import com.hansen.sqlitetopostgres.entity.postgres.TableA;
import com.hansen.sqlitetopostgres.entity.postgres.TableB;
import com.hansen.sqlitetopostgres.model.Data;
import com.hansen.sqlitetopostgres.repo.postgres.TableARepository;
import com.hansen.sqlitetopostgres.repo.postgres.TableBRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class PostgresPersistenceServiceImpl implements PostgresPersistenceService {

    @Autowired
    private TableARepository tableARepository;

    @Autowired
    private TableBRepository tableBRepository;

    @Override
    public void translateToPostgres(Data SQLiteData) {
        if (SQLiteData == null)
        {
            throw new RuntimeException("SQLite data cannot be null.");
        }
        new Thread(() -> doAsyncTranslateToPostgres(SQLiteData)).start();
    }
    private void doAsyncTranslateToPostgres(Data SQLiteData){

        persistToPostgres(SQLiteData.getTableAList(), SQLiteData.getTableBList());
    }

    @Transactional
    private void persistToPostgres(List<TableA> tableAList,
                                   List<TableB> tableBList)
    {
        tableBRepository.saveAll(tableBList);
        tableARepository.saveAll(tableAList);
        log.info("Data persisted to PostgreSQL.");

    }

}
