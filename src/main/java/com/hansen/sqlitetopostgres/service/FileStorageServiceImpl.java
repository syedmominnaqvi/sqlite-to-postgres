package com.hansen.sqlitetopostgres.service;

import com.hansen.sqlitetopostgres.model.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.UUID.randomUUID;

@Service
@Slf4j
public class FileStorageServiceImpl implements FileStorageService{
    @Autowired
    SQLiteDataLoaderService dataLoaderService;

    @Autowired
    PostgresPersistenceService postgresPersistenceService;
    @Override
    public Path storeFile(MultipartFile file) {
        try {
            String uuid = String.valueOf(randomUUID());
            log.info("UUID generated: "+uuid);
            Path newFilePath = Files.createFile(Path.of("/tmp/"+uuid+".db"));
            file.transferTo(newFilePath);

            Data data = null;
            try {
               data = dataLoaderService.loadSQLiteData(newFilePath, uuid);
            }
            catch (Exception e){
                log.warn("Error occured while loading SQLite data. Err:"+e.getMessage());
            }
            finally {
                Files.delete(newFilePath);
            }

            postgresPersistenceService.translateToPostgres(data);
            return newFilePath;
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }


}
