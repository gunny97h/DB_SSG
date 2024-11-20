package org.example.mongo.delete;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteOne2 {
    public static void main(String[] args) {
        // log x
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.WARNING);

        // 1. MongoClient 생성
        MongoClient client = new MongoClient("localhost", 27017);

        // 2. db, collection 연결
        MongoDatabase db = client.getDatabase("shop");
        MongoCollection<Document> member = db.getCollection("member");
        System.out.println("member 컬렉션까지 연결 성공~!");

        // 3. 전송할 js 생성
        //    delete할 json(document) 조건(filter)을 생성
        Document filter = new Document();
        filter.append("id", "apple20");
        filter.append("pw", "1234");  // 조건 2개 (and)

        // 4. 전송, 결과처리
        member.deleteOne(filter);
        System.out.println("MongoDB로 전송함.");

        client.close();
    }
}
