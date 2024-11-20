package org.example.mongo.update;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateOne2 {
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
        //    update할 json(document) 조건(filter)을 생성
        Document filter = new Document();
        filter.append("id", "kim");  // {id : "kim"}
        // 수정할 내용 지정
        Bson pw = Updates.set("pw", "q1w2e3r4");  // {$set : {pw : "q1w2e3r4"}}
        Bson name = Updates.set("name", "qwer");  // {$set : {name : "qwer"}}

        List<Bson> list = new ArrayList<>();
        list.add(pw);
        list.add(name);
        Bson all  = Updates.combine(list);  // {$set : {pw : "q1w2e3r4", name : "qwer"}}


        // 4. 전송, 결과처리
        member.updateOne(filter, all);  // db.member.updateOne({id : "kim"}, {$set : {pw : "q1w2e3r4", name : "qwer"}})
        System.out.println("MongoDB로 전송함.");

        client.close();
    }
}
