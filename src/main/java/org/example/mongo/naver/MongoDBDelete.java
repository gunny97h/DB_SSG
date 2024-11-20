package org.example.mongo.naver;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

// 특정 서비스 회원 정보 삭제하기
// MongoDB에서 네이버 블로그 서비스의 id가 "blogUser2"인 회원의 정보를 삭제
public class MongoDBDelete {
    public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.WARNING);  // log x

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("naver");
        MongoCollection<Document> collection = database.getCollection("members");
        // 블로그 서비스에서 회원 아이디로 삭제
        String memberId = "blogUser2";  // 삭제할 회원 아이디
        Document query = new Document("service", "Blog").append("id", memberId);
        collection.deleteOne(query);
        System.out.println("블로그 회원 정보 삭제 완료.");
        mongoClient.close();
    }
}
