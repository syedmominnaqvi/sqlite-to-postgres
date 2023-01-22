package com.hansen.sqlitetopostgres.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface FileStorageService {
    Path storeFile(MultipartFile file);
}
