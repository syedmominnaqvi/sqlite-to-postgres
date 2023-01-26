package com.hansen.sqlitetopostgres.entity.postgres;

import org.hibernate.annotations.Type;

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
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "request_uuid")
    private UUID request_uuid;

    @Column(name = "title")
    private String title;

    @Column(name = "number")
    private int number;

    public TableA()
    {

    }

    public TableA(UUID uuid, UUID request_uuid, String title, int number){
        this.request_uuid = request_uuid;
        this.uuid=uuid;
        this.title=title;
        this.number= number;
    }

}
