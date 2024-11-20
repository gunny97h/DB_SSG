package org.example.mongo.assignments;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ElectromicsInsert {
    public static void main(String[] args) {

        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.WARNING);  // log x

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("company");
        MongoCollection<Document> collection = database.getCollection("products");
        // Electronics 카테고리 데이터 삽입
        Document doc1 = new Document("name", "Smartphone")
                .append("category", "Electronics")
                .append("price", 500000)
                .append("brand", "Samsung")
                .append("description", "Latest model with 5G support");

        Document doc2 = new Document("name", "Laptop")
                .append("category", "Electronics")
                .append("price", 1200000)
                .append("brand", "Apple")
                .append("description", "High-performance laptop");

        List<Document> list = new ArrayList<>();
        list.add(doc1);
        list.add(doc2);

        collection.insertMany(list);
        mongoClient.close();
        System.out.println("insert 완료.");
    }
}
