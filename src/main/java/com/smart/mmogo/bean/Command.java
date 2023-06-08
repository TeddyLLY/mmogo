package com.smart.mmogo.bean;


import org.bson.BsonArray;
import org.bson.conversions.Bson;
import org.json.simple.JSONArray;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Command {

    /*
     * CRUD TYPE
     *-----------------------
     *      delete
     *      select
     *      update
     *      insert
     *      base
     *-----------------------
     */
    String type;

    String dbName;

    String collection;

    /*
     * 參數 基本上都是 Bson or BsonArray
     */
    Object filter ;
    JSONArray documents ;
    Object options ;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public Object getFilter() {
        return filter;
    }

    public void setFilter(Object filter) {
        this.filter = filter;
    }

    public Object getOptions() {
        return options;
    }

    public void setOptions(Object options) {
        this.options = options;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public JSONArray getDocuments() {
        return documents;
    }

    public void setDocuments(JSONArray documents) {
        this.documents = documents;
    }
}
