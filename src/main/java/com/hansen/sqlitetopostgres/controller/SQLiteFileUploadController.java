package com.hansen.sqlitetopostgres.controller;

import com.hansen.sqlitetopostgres.entity.postgres.TableB;
import com.hansen.sqlitetopostgres.model.Data;
import com.hansen.sqlitetopostgres.model.ResponseMessage;
import com.hansen.sqlitetopostgres.repo.postgres.TableBRepository;
import com.hansen.sqlitetopostgres.service.FileStorageService;
import com.hansen.sqlitetopostgres.service.PostgresPersistenceService;
import com.hansen.sqlitetopostgres.service.SQLiteDataLoaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

@Controller
@Slf4j
public class SQLiteFileUploadController {

    @Autowired
    FileStorageService storageService;

    @Autowired
    TableBRepository repository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if(file == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File cannot be empty");
        }

        String message = "";
        try {
            List<TableB> ss = repository.findAll();
            Path pathToTempFile=storageService.storeFile(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            log.info(message);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }
}

