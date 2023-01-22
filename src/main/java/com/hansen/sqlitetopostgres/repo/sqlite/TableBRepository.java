package com.hansen.sqlitetopostgres.repo.sqlite;

import com.hansen.sqlitetopostgres.entity.sqlite.TableB;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

@Scope("session")
public interface TableBRepository extends JpaRepository<TableB, Integer> {
}
