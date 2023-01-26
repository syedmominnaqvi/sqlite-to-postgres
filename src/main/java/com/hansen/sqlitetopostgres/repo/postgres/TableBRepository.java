package com.hansen.sqlitetopostgres.repo.postgres;

import com.hansen.sqlitetopostgres.entity.postgres.TableB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TableBRepository extends JpaRepository<TableB, UUID> {
}
