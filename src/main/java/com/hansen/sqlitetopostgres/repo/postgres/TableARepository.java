package com.hansen.sqlitetopostgres.repo.postgres;

import com.hansen.sqlitetopostgres.entity.postgres.TableA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TableARepository extends JpaRepository<TableA, String> {
}
