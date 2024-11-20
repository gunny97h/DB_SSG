package org.example.mongo;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;
import java.util.concurrent.TimeUnit;
import com.mongodb.client.FindIterable;

public class 연결테스트 {
    public static void main(String[] args) {

        Bson filter = new Document("id", "kim");
        Bson filter2 = new Document("tel", "631-106-6136");

        MongoClient mongoClient = new MongoClient(
                new MongoClientURI(
                        "mongodb://localhost:27017/"
                )
        );
        MongoDatabase database = mongoClient.getDatabase("shop");
        MongoCollection<Document> collection = database.getCollection("member");
        FindIterable<Document> result = collection.find(filter);
        FindIterable<Document> result2 = collection.find(filter2);

        System.out.println(result.first().getString("name"));

        System.out.println(result2.first().getString("id"));
        System.out.println(result2.first().getString("pw"));
        System.out.println(result2.first().getString("name"));
        System.out.println(result2.first().getString("tel"));

        mongoClient.close();
    }
}
