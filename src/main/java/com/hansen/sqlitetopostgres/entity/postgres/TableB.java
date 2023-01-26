package com.hansen.sqlitetopostgres.entity.postgres;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "tableb")
public class TableB {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "uuid")
    private UUID uuid;

    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "request_uuid")
    private UUID request_uuid;

    @Column(name = "id")
    private long Id;

    @Column(name = "subject")
    private String subject;

    public TableB()
    {

    }

    public TableB(UUID uuid, UUID request_uuid, long id, String subject){
        this.uuid = uuid;
        this.request_uuid = request_uuid;
        this.Id = id;
        this.subject = subject;
    }
}
