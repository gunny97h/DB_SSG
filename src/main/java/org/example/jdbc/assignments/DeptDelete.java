package org.example.jdbc.assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeptDelete {
    public static void main(String[] args) throws Exception {
        //자바(언어)에서 db를 연결하는 프로그램 4단계
        //Java DB Connectivity(JDBC) 4단계
        //1단계 - 사용할 라이브러리 설정
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. MYSQL 자바 연결할 부품 설정 성공.");
        //2단계 - db연결 --> 데이터~!(실무 설정)
        String url = "jdbc:mysql://localhost:3306/school"; //ip+port+db명
        String id = "root";
        String pw = "1234";

        Connection con = DriverManager.getConnection(url, id, pw);

        System.out.println("2. MYSQL 연결 성공.");

        //3단계 - sql작성

        // 입력 받는 부분(UI)
        Scanner sc = new Scanner(System.in);
        System.out.print("deptNo >> ");
        int deptNo값 = sc.nextInt();
        sc.close();

        String sql = "delete from dept where deptno = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, deptNo값);

        System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

        //4단계 - dbms로 sql문 전송
        int result = ps.executeUpdate();
        System.out.println("4. SQL문 MYSQL로 보내기 성공.");
        System.out.println("수정 성공\n처리된 row 수 >> " + result);



        ps.close();
        con.close();


    }
}
