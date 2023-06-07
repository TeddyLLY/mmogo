package com.smart.mmogo.bean;


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

    /*
     * 參數 基本上都是 Bson or BsonArray
     */
    Object filter ;
    Object documents ;
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

    public Object getDocuments() {
        return documents;
    }

    public void setDocuments(Object documents) {
        this.documents = documents;
    }

    public Object getOptions() {
        return options;
    }

    public void setOptions(Object options) {
        this.options = options;
    }
}
