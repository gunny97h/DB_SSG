package org.example.mongo.naver;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

// 특정 서비스 회원 정보 검색하기
// MongoDB에서 네이버 카페 서비스의 id가 "cafeUser1"인 회원의 정보를 검색
public class MongoDBSearch {
    public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.WARNING);  // log x

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("naver");
        MongoCollection<Document> collection = database.getCollection("members");
        // 카페 서비스에서 회원 아이디로 검색
        String memberId = "cafeUser1";  // 검색할 회원 아이디
        Document query = new Document("service", "Cafe").append("id", memberId);
        Document member = collection.find(query).first();
        if (member != null) {
            System.out.println("검색된 회원 정보: " + member.toJson());
        } else {
            System.out.println("회원 정보를 찾을 수 없습니다.");
        }
        mongoClient.close();
    }
}
