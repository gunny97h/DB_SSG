package org.example.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level; // log x
import java.util.logging.Logger;

public class InsertMany {
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
        //    insert할 json(document)을 여러 개 생성
        Document doc = new Document();
        doc.append("id", "apple2");
        doc.append("pw", "1234");
        doc.append("name", "apple2");
        doc.append("tel", "011");

        Document doc2 = new Document();
        doc2.append("id", "apple3");
        doc2.append("pw", "1234");
        doc2.append("name", "apple3");
        doc2.append("tel", "011");

        List<Document> list = new ArrayList<>();
        list.add(doc);
        list.add(doc2);

        // 4. 전송, 결과처리
        member.insertMany(list);
        System.out.println("MongoDB로 전송함.");

        client.close();
    }
}
