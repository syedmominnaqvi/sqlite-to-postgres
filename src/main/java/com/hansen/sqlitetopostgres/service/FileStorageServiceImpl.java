package com.hansen.sqlitetopostgres.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.UUID.randomUUID;

@Service
@Slf4j
public class FileStorageServiceImpl implements FileStorageService{
    @Override
    public void storeFile(MultipartFile file) {
        try {
            String uuid = String.valueOf(randomUUID());
            log.info("UUID generated: "+uuid);
            Files.copy(file.getInputStream(), Path.of(uuid));
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }
}
