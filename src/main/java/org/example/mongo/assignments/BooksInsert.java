package org.example.mongo.assignments;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BooksInsert {
    public static void main(String[] args) {

        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.WARNING);  // log x

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("company");
        MongoCollection<Document> collection = database.getCollection("products");
        // Books 카테고리 데이터 삽입
        Document doc1 = new Document()
                .append("name", "Java Programming")
                .append("category", "Books")
                .append("price", 35000)
                .append("author", "John Doe")
                .append("description", "Learn Java programming");

        Document doc2 = new Document()
                .append("name", "The Great Gatsby")
                .append("category", "Books")
                .append("price", 20000)
                .append("author", "F.Scott Fitzgerald")
                .append("description", "Classic American novel");

        List<Document> list = new ArrayList<>();
        list.add(doc1);
        list.add(doc2);

        collection.insertMany(list);
        mongoClient.close();
        System.out.println("insert 완료.");
    }
}
