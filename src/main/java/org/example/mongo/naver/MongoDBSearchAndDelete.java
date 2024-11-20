package org.example.mongo.naver;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

// 회원 이름으로 검색 후 삭제하기
// MongoDB에서 네이버 블로그 서비스에서 name이 "이순신"인 회원의 정보를 검색한 후 삭제
public class MongoDBSearchAndDelete {
    public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.WARNING);  // log x

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("naver");
        MongoCollection<Document> collection = database.getCollection("members");
        // 회원 이름으로 검색
        String serviceName = "Blog";  // 검색할 서비스 이름
        String name = "이순신";  // 검색할 이름
        Document query = new Document("service", serviceName).append("name", name);
        Document member = collection.find(query).first();
        if (member != null) {
            System.out.println("검색된 회원 정보: " + member.toJson());
            // 회원 정보 삭제
            collection.deleteOne(query);
            System.out.println(name + "님의 회원 정보 삭제 완료.");
        } else {
            System.out.println(name + "님의 회원을 찾을 수 없습니다.");
        }
        mongoClient.close();
    } }
