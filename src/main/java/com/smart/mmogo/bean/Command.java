package com.smart.mmogo.bean;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
    JSONArray documents ;
    JSONObject filter ;
    JSONObject update ;
    Boolean upsert ;


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

    public JSONObject getFilter() {
        return filter;
    }

    public void setFilter(JSONObject filter) {
        this.filter = filter;
    }

    public JSONObject getUpdate() {
        return update;
    }

    public void setUpdate(JSONObject update) {
        this.update = update;
    }

    public Boolean getUpsert() {
        return upsert;
    }

    public void setUpsert(Boolean upsert) {
        this.upsert = upsert;
    }
}
