package org.example.mongo.naver;

import java.util.logging.Level;
import java.util.logging.Logger;

// 응용문제(네이버 회원정보)
// SSG_DB/강의자료/NEW02-MySQL-7(몽고DB+JAVA).pdf  p.33
public class NaverInsertMain {
    public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.WARNING);  // log x

        MongoDBBlogInsert.insertBlogMember();
        MongoDBCafeInsert.insertCafeMember();
        MongoDBLineInsert.insertLineMember();
//        MongoDBMergeMembers.mergeMembers();
    }
}
