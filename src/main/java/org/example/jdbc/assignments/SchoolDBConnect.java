package org.example.jdbc.assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SchoolDBConnect {
    public static void main(String[] args)  {
        //자바(언어)에서 db를 연결하는 프로그램 4단계
        //Java DB Connectivity(JDBC) 4단계
        //1단계 - 사용할 라이브러리 설정
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("1. MYSQL 자바 연결할 부품 설정 성공.");
        //2단계 - db연결 --> 데이터~!(실무 설정)
        String url = "jdbc:mysql://localhost:3306/school"; //ip+port+db명
        String id = "root";
        String pw = "1234";

        try {
            Connection con = DriverManager.getConnection(url, id, pw);
            System.out.println("2. MYSQL 연결 성공.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("2. MYSQL 연결 실패");
        }

    }
}
