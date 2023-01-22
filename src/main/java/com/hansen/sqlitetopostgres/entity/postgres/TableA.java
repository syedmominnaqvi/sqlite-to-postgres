package com.hansen.sqlitetopostgres.entity.postgres;

import lombok.Builder;
import org.hibernate.annotations.Type;
import org.hibernate.type.PostgresUUIDType;
import org.hibernate.type.UUIDCharType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "tablea")
public class TableA {
    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "title")
    private String title;

    @Column(name = "number")
    private int number;

    public TableA()
    {

    }

    public TableA(UUID uuid, String title, int number){
        this.uuid=uuid;
        this.title=title;
        this.number= number;
    }

}
