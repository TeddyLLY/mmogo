package com.smart.mmogo.core.utils;

import com.smart.mmogo.bean.Command;
import org.bson.BsonArray;
import org.bson.Document;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
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
}
