package com.hansen.sqlitetopostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.io.IOException;

@SpringBootApplication
public class SqliteToPostgresApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SqliteToPostgresApplication.class, args);
	}


}
