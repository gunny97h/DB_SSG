package org.example.mongo.assignments;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClothingInsert {
    public static void main(String[] args) {

        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.WARNING);  // log x

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("company");
        MongoCollection<Document> collection = database.getCollection("products");
        // Clothing 카테고리 데이터 삽입
        Document shirt = new Document()
                .append("name", "T-shirt")
                .append("category", "Clothing")
                .append("price", 20000)
                .append("brand", "Nike")
                .append("description", "Comfortable cotton fabric");

        Document jeans = new Document()
                .append("name", "Jeans")
                .append("category", "Clothing")
                .append("price", 45000)
                .append("brand", "Levi's")
                .append("description", "Classic blue jeans");


        List<Document> list = new ArrayList<>();
        list.add(shirt);
        list.add(jeans);

        collection.insertMany(list);
        mongoClient.close();
        System.out.println("insert 완료.");
    }
}
