package org.example.mongo.find;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

// memo Collection 여러개 검색
// --> office가 busan인 메모 검색
public class Many문제 {
    public static void main(String[] args) {
        // log x
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.WARNING);

        // 1. MongoClient 생성
        MongoClient client = new MongoClient("localhost", 27017);

        // 2. db, collection 연결
        MongoDatabase db = client.getDatabase("shop");
        MongoCollection<Document> memo = db.getCollection("memo");
        System.out.println("memo 컬렉션까지 연결 성공~!");

        // 3. 전송할 json(document) 조건 생성
        Document filter = new Document();
        filter.append("office", "busan");

        // 4. 전송, 결과처리
        System.out.println("------------------------------");
        FindIterable<Document> result = memo.find(filter);
        for (Document doc : result) {
            System.out.println(doc.getString("name"));
            System.out.println(doc.getInteger("age"));
            System.out.println(doc.getString("office"));
            System.out.println(doc.getString("phone"));
            System.out.println("------------------------------");
        }

        client.close();
    }
}
