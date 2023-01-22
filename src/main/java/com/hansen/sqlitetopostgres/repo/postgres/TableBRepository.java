package com.hansen.sqlitetopostgres.repo.postgres;

import com.hansen.sqlitetopostgres.entity.postgres.TableB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TableBRepository extends JpaRepository<TableB, Integer> {
}
