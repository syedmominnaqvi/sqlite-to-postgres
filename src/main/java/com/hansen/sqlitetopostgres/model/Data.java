package com.hansen.sqlitetopostgres.model;

import com.hansen.sqlitetopostgres.entity.sqlite.TableA;
import com.hansen.sqlitetopostgres.entity.sqlite.TableB;
import lombok.Builder;

import java.util.List;

@lombok.Data
@Builder
public
class Data{
    List<TableA> tableAList;
    List<TableB> tableBList;
}