package com.hansen.sqlitetopostgres.repo;

import com.hansen.sqlitetopostgres.entity.TableA;
import com.hansen.sqlitetopostgres.entity.TableB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableARepository extends JpaRepository<TableA, String> {
}
