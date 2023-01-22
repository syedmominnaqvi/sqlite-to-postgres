package com.hansen.sqlitetopostgres.repo.postgres;

import com.hansen.sqlitetopostgres.entity.postgres.TableA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface TableARepository extends JpaRepository<TableA, UUID> {
}
