package com.hansen.sqlitetopostgres.model;

import com.hansen.sqlitetopostgres.entity.postgres.TableA;
import com.hansen.sqlitetopostgres.entity.postgres.TableB;
import lombok.Builder;

import java.util.List;

@lombok.Data
@Builder
public
class Data{
    List<TableA> tableAList;
    List<TableB> tableBList;
}