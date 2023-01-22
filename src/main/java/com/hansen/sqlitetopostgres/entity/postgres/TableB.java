package com.hansen.sqlitetopostgres.entity.postgres;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tableb")
public class TableB {
    @Id
    @Column(name = "id")
    private long Id;

    @Column(name = "subject")
    private String subject;

    public TableB()
    {

    }

    public TableB(long id, String subject){
        this.Id = id;
        this.subject = subject;
    }
}
