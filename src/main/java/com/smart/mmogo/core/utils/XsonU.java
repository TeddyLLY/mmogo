package com.smart.mmogo.core.utils;

import com.smart.mmogo.bean.Command;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XsonU {
    public static List<Document> covertDocuments(Command command){
        List<Document> documents = new ArrayList<Document>();
        JSONArray jsonArray= command.getDocuments();

        if(StringU.isEmpty(jsonArray)){
            throw new RuntimeException("command id empty !") ;
        }

        for(int i=0 ; i<jsonArray.size() ; i++ ){
            Document doc = new Document((Map<String, Object>) jsonArray.get(i)) ;
            documents.add(doc);
        }

        return documents ;
    }

    public static Document covertDocument(Command command){
        JSONArray jsonArray= command.getDocuments();

        if(StringU.isEmpty(jsonArray)||jsonArray.size()!=1){
            throw new RuntimeException("command size wrong !") ;
        }

        return covertDocuments(command).get(0);
    }

    public static Document covertJson(JSONObject json){

        if(StringU.isEmpty(json)){
            throw new RuntimeException("filter command is empty!") ;
        }

        return Document.parse(json.toString());
    }

}
