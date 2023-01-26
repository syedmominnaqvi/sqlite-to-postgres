package com.hansen.sqlitetopostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

@SpringBootApplication
@EnableTransactionManagement
public class SqliteToPostgresApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SqliteToPostgresApplication.class, args);
	}


}
