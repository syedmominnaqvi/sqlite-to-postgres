package com.hansen.sqlitetopostgres.entity.postgres;

import lombok.Builder;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "TableA")
@Builder
public class TableA {
    @Id
    @Type(type="uuid-char")
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "title")
    private String title;

    @Column(name = "number")
    private int number;

    public static TableA transformSQLiteTableA(com.hansen.sqlitetopostgres.entity.sqlite.TableA dto){
        return TableA.builder()
                .uuid(dto.getUuid())
                .title(dto.getTitle())
                .number(dto.getNumber())
                .build();
    }
}
