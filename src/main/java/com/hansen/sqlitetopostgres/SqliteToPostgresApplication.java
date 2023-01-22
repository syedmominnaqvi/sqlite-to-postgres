package com.hansen.sqlitetopostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.persistence.Entity;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
@EnableAsync
//@EnableJpaRepositories(
//		basePackages = "com.hansen.sqlitetopostgres.repo.postgres")
public class SqliteToPostgresApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SqliteToPostgresApplication.class, args);
	}

}
