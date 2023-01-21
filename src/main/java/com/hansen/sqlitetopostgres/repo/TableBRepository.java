package com.hansen.sqlitetopostgres.repo;

import com.hansen.sqlitetopostgres.entity.TableB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableBRepository extends JpaRepository<TableB, Integer> {
}
