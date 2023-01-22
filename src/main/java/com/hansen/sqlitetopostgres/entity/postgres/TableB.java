package com.hansen.sqlitetopostgres.entity.postgres;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TableB")
@Builder
public class TableB {
    @Id
    @Column(name = "id")
    private long Id;

    @Column(name = "subject")
    private String subject;

    public static TableB transformSQLiteTableB(com.hansen.sqlitetopostgres.entity.sqlite.TableB dto){
        return TableB.builder()
                .Id(dto.getId())
                .subject(dto.getSubject())
                .build();
    }
}
