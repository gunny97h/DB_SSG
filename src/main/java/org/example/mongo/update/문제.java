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

public class 문제 {
    // 1. id가 hong인 사람의 tel을 999로 변경
    // 2. id가 hong인 사람의 pw를 7777, name을 winner로 변경

    // Bson은 json을 나타내는 인터페이스
    // Document는 Bson을 구현한 클래스
    // Bson은 실제로 문자를 json에 저장하지 않고 바이너리 형태로 저장해서 속도가 빠르다.
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
        filter.append("id", "hong");
        // 수정할 내용 지정
        Bson tel = Updates.set("tel", "999");  // 1번

        Bson pw = Updates.set("pw", "7777");  // 2번
        Bson name = Updates.set("name", "winner");

        List<Bson> list = new ArrayList<>();  // 2번
        list.add(pw);
        list.add(name);
        Bson all  = Updates.combine(list);

        // 4. 전송, 결과처리
        member.updateOne(filter, tel);  // 1번
        member.updateOne(filter, all);  // 2번
        System.out.println("MongoDB로 전송함.");

        client.close();
    }
}
/*
===> BSON에 대해
///////////////////////////////////////////////////////////////////////
원래 class를 만들 때
업계에서는 Json을 다루기 위해서는 이런 기능이 필요한 것 같다라고 해서
먼저 인터페이스로 정의합니다.
==> 우리도 어떤 것을 구체적으로 만들기 전에
==> 이런 이런 기능이 있으면 좋겠다라고 간단하게 기능에 대해 먼저 써보잖아요!!
==> 같은 개념.!
(모든 업계에서 그런 것은 아니지만 대부분 그렇습니다.)
이렇게 간단히 기능을 정의해놓은 인터페이스를 토대로 클래스를 만들고
그 클래스로 객체를 만들어 사용하게 되는 거죠!!
Bson은 json을 다루려면 이런 기능이 있어야해라고 몽고db측에서 만들어놓은 기능만 간단히 정의한 문서같은 인터페이스이고
이것을 구체적으로 구현한 클래스가 Document클래스랍니다.!!!
자동차가 되려면 정의(인터페이스)
public interface Car{
      달리다();
      멈추다() ;
}
2. 실제 자동차 틀(클래스)
public class CarClass {
      달리다() {
         달리는 기능 구현();
      }
       멈추다() {
          멈추는 기능 구현();
      }
      문자동열리다() {
         추가기능 구현();
      }
 }
3. 객체생성 후 사용
Car c1 = new CarClass(); //차 1대 생성
Car c2 = new CarClass(); //차 1대 생성
c1, c2는 주자장 자리에 Car규칙에 의해 만들어진 객체면 다 놓을 수 있어라고 선언된 변수!
그 규칙에 따라 만들어진 2대의 차는 주차할 수 있음.
///////////////////////////////////////////////////
Bson json = new Document();
Bson json2 =new BsonDocument();
앞에 있는 변수의 타입을 Bson을 선언해두면
Bson인터페이스(기능정의)를 따라서 만든
클래스의 객체 주소는
모두 사용할 수 있습니다. !!!
(Document객체만 사용하지 않아도 됨.!!!)
 */
