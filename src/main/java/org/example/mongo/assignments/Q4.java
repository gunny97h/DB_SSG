package org.example.mongo.assignments;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Q4 {
    public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.WARNING);    // log x

        // 1. MongoClient 생성
        MongoClient client = new MongoClient("localhost", 27017);

        // 2. db, collection 연결
        MongoDatabase db = client.getDatabase("company");
        MongoCollection<Document> collection = db.getCollection("products");
        System.out.println("member 컬렉션까지 연결 성공~!");

        // 3. 전송할 json(document) 조건 생성
        Document filter = new Document();
        filter.append("category", "Electronics")
              .append("name", new Document("$regex", "Smart"));

        // 4. 전송, 결과처리
        FindIterable<Document> result = collection.find(filter);
        for (Document doc : result) {
            System.out.println(doc.getString("name"));
            System.out.println(doc.getString("category"));
            System.out.println(doc.getInteger("price"));
            System.out.println(doc.getString("brand"));
            System.out.println(doc.getString("description"));
            System.out.println("------------------------------");
        }
        client.close();
    }
}
