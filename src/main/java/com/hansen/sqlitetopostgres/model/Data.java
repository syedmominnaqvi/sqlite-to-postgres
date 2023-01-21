package com.hansen.sqlitetopostgres.model;

import com.hansen.sqlitetopostgres.entity.TableA;
import com.hansen.sqlitetopostgres.entity.TableB;
import lombok.Builder;

import java.util.List;

@lombok.Data
@Builder
class Data{
    List<TableA> tableAList;
    List<TableB> tableBList;
}