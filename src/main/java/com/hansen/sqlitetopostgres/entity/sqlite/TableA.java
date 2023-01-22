package com.hansen.sqlitetopostgres.entity.sqlite;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "TableA")
@Data
public class TableA {
    @Id
    @Type(type="uuid-char")
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "title")
    private String title;

    @Column(name = "number")
    private int number;
}
