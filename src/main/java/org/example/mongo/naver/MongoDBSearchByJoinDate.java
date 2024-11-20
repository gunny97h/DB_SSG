package org.example.mongo.naver;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

// 특정 가입일 이후 가입한 회원 정보 검색하기
// MongoDB에서 네이버 라인 서비스의 joinDate가 "2021-12-01" 이후인 모든 회원의 정보를 검색
public class MongoDBSearchByJoinDate {
    public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.WARNING);  // log x

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("naver");
        MongoCollection<Document> collection = database.getCollection("members");
        // 라인 서비스에서 가입일이 특정 날짜 이후인 회원 정보 검색
        String joinDate = "2021-12-01";  // 특정 날짜 이후 가입한 회원
        Document query = new Document("service", "Line").append("joinDate", new Document("$gt", joinDate));
        for (Document member : collection.find(query)) {
            System.out.println("검색된 회원 정보: " + member.toJson());
        }
        mongoClient.close();
    }
}
