package org.example.distributed.assignments;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

// SSG_DB/문제/1121-NEW02-몽고DB%20+%20mySQL%20분산환경%20구축.pdf
public class AWSDistributedDatabase {

    // MySQL JDBC URL
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/aws";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASSWORD = "1234";
    // MongoDB Connection URI
    private static final String MONGO_URI = "mongodb://localhost:27017";

    public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.WARNING);  // log x

        String time = null;
        try {
            // 1. MySQL 연결
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection mysqlConnection = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
            System.out.println("1. MySQL에 연결.");

            // 2. 회원가입 후 자동증가한 id를 얻어오자
            String insertUserSQL = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement pstmt = mysqlConnection.prepareStatement(insertUserSQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, "hong");
            pstmt.setString(2, "hong@new.com");
            pstmt.executeUpdate();
            System.out.println("2. MySQL에 전송");
            // Get the generated user ID
            ResultSet rs = pstmt.getGeneratedKeys();
            int userId = 0;
            if (rs.next()) {
                userId = rs.getInt(1);
            }
            // Get the generated timestamp
            String selectSignupDate = "SELECT signup_date FROM users WHERE id = ?";
            PreparedStatement timestampStmt = mysqlConnection.prepareStatement(selectSignupDate);
            timestampStmt.setInt(1, userId);
            ResultSet timeResult = timestampStmt.executeQuery();

            if (timeResult.next()) {
                time = timeResult.getString("signup_date");
            }
            System.out.println("   Inserted user with ID: " + userId);

            // 3. 2번에서 얻은 id를 이용해서 MongoDB에 주문정보를 넣자
            //    3-1. MongoDB에 연결
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("aws");
            MongoCollection<Document> logCollection = mongoDatabase.getCollection("activity_logs");
            System.out.println("3. MongoDB에 연결.");
            //    3-2. document를 만들어서 전송
            //    json 형태의 값: String, int, float, array
            Document activityLog = new Document();
            activityLog.append("user_id", userId);
            activityLog.append("activity", "Login");
            activityLog.append("timestamp", "2024-11-10T10:15:00");
            Document activityLog2 = new Document();
            activityLog2.append("user_id", userId);
            activityLog2.append("activity", "Order");
            activityLog2.append("timestamp", "2024-11-11T11:15:00");
            Document activityLog3 = new Document();
            activityLog3.append("user_id", userId);
            activityLog3.append("activity", "Order");
            activityLog3.append("timestamp", "2024-11-21T11:15:00");

            logCollection.insertOne(activityLog);
            logCollection.insertOne(activityLog2);
            logCollection.insertOne(activityLog3);

            System.out.println("   Inserted order for user ID: " + userId);
            System.out.println("4. MongoDB에 전송.");
            System.out.println("---------------------------------------------------");

            // 4. 회원정보는 mysql 검색, 회원주문정보보기는 mongoDB 검색하여 분산!
            //    4-1. 회원정보는 MySQL 검색
            String selectUserSQL = "SELECT * FROM users WHERE id = ?";
            PreparedStatement selectPstmt = mysqlConnection.prepareStatement(selectUserSQL);
            selectPstmt.setInt(1, userId);
            ResultSet userResult = selectPstmt.executeQuery();
            if (userResult.next()) {
                System.out.println("(MySQL) User Info: ");
                System.out.println("ID: " + userResult.getInt("id"));
                System.out.println("Name: " + userResult.getString("name"));
                System.out.println("Email: " + userResult.getString("email"));
                System.out.println("Signup Date: " + userResult.getString("signup_date"));
            }
            System.out.println("---------------------------------------------------");
            //    4-2. 회원주문정보보기는 MongoDB 검색
            //Document userOrder = ordersCollection.find(Filters.eq("user_id", userId)).first();
            Document filter = new Document("user_id", userId);
            ArrayList<Document> result = logCollection.find(filter).into(new ArrayList<Document>());

            System.out.println("(MongoDB) Order Info: ");
            for (Document doc : result) {
                System.out.println(doc);
            }
            System.out.println("---------------------------------------------------");


            // 5. Close connections
            mysqlConnection.close();
            mongoClient.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
 #### 몽고DB + mySQL분산 환경 구축(aws) ####
 -- SSG_DB/문제/1121-NEW02-몽고DB%20+%20mySQL%20분산환경%20구축.pdf
 CREATE DATABASE aws;

 USE aws;

 CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    signup_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
 );
 */
