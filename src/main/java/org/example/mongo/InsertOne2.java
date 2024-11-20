package org.example.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertOne2 {
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
        //    insert할 json(document)을 생성
        Scanner sc = new Scanner(System.in);
        System.out.print("id >> ");
        String id = sc.next();
        System.out.print("pw >> ");
        String pw = sc.next();
        System.out.print("name >> ");
        String name = sc.next();
        System.out.print("tel >> ");
        String tel = sc.next();
        sc.close();

        Document doc = new Document();
        doc.append("id", id);
        doc.append("pw", pw);
        doc.append("name", name);
        doc.append("tel", tel);

        // 4. 전송, 결과처리
        member.insertOne(doc);
        System.out.println("MongoDB로 전송함.");

        client.close();
    }
}
