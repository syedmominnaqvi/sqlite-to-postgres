package com.hansen.sqlitetopostgres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TableB")
public class TableB {
    @Id
    @Column(name = "id")
    private long Id;

    @Column(name = "subject")
    private String subject;
}
