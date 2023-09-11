package jdbc.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.internal.MongoClientImpl;
import org.bson.Document;
public class jdbc {

    public static void main(String[] args) {
        // MongoDB connect uri
        String connectionString = "mongodb+srv://root:root@cloud-cluster0.prhwadb.mongodb.net/demo?retryWrites=true&w=majority";

        // create MongoClient
        MongoClient mongoClient = new MongoClientImpl(
                MongoClientSettings.builder().applyConnectionString
                        ( new ConnectionString(connectionString)).build(),null
        );

        // get db & collection info
        MongoDatabase database = mongoClient.getDatabase("demo");
        MongoCollection<Document> collection = database.getCollection("employee");

        // insert test
        Document document = new Document("first_name", "Kelly")
                .append("last_name", "Blue")
                .append("job", "Reporter")
                .append("salary", 5566)
                .append("internship", false)
                .append("regular_date", null);
        collection.insertOne(document);

        // select
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }

        // close connect
        mongoClient.close();
    }
}
