package com.hansen.sqlitetopostgres.entity.sqlite;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TableB")
@Data
public class TableB {
    @Id
    @Column(name = "id")
    private long Id;

    @Column(name = "subject")
    private String subject;
}
