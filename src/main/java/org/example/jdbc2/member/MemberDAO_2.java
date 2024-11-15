package org.example.jdbc2.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO_2 {
    // DAO 클래스는 member 테이블의 데이터를 접근해서
    // 여러 기능을 정의하고 있는 클래스를 말함.
    // DB 테이블당 DAO는 하나씩 만든다.
    // 테이블이 100개이면 DAO는 1000개를 만든다.



    public void insert(String id값, String pw값, String name값, String tel값) throws Exception {
        // 1. 드라이버 설정 --> 레이지로딩(실행시에 메모리에 올려줌)
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버 설정");

        // 2. DB 연결
        String url = "jdbc:mysql://localhost:3306/shop2";
        String user = "root";
        String password = "1234";
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("2. DB 연결");

        // 3. SQL 준비
        String sql = "insert into member values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);  // ps가 ?를 세팅하는 역할
        ps.setString(1, id값);
        ps.setString(2, pw값);
        ps.setString(3, name값);
        ps.setString(4, tel값);
        System.out.println("3. SQL 준비");

        // 4. SQL 전송 --> ps가 전송하는 기능을 가지고 있음
        int result = ps.executeUpdate();  // 실행된 row 수, update, delete
        System.out.println("4. SQL 전송");
        System.out.println("실행된 row 수 --> " + result + "개");

        // 5. 연결 종료
        ps.close();
        con.close();
        System.out.println("5. 연결 종료");
    }
    public void delete(String id값) throws Exception {
        // 1. 드라이버 설정 --> 레이지로딩(실행시에 메모리에 올려줌)
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버 설정");

        // 2. DB 연결
        String url = "jdbc:mysql://localhost:3306/shop2";
        String user = "root";
        String password = "1234";
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("2. DB 연결");

        // 3. SQL 준비
        String sql = "delete from member where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);  // ps가 ?를 세팅하는 역할
        ps.setString(1, id값);
        System.out.println("3. SQL 준비");

        // 4. SQL 전송 --> ps가 전송하는 기능을 가지고 있음
        int result = ps.executeUpdate();  // 실행된 row 수, update, delete
        System.out.println("4. SQL 전송");
        System.out.println("실행된 row 수 --> " + result + "개");

        // 5. 연결 종료
        ps.close();
        con.close();
        System.out.println("5. 연결 종료");
    }
    public void update(String id값, String tel값) throws Exception {
        // 1. 드라이버 설정 --> 레이지로딩(실행시에 메모리에 올려줌)
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버 설정");

        // 2. DB 연결
        String url = "jdbc:mysql://localhost:3306/shop2";
        String user = "root";
        String password = "1234";
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("2. DB 연결");

        // 3. SQL 준비
        String sql = "update member set tel = ? where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);  // ps가 ?를 세팅하는 역할
        ps.setString(1, tel값);
        ps.setString(2, id값);
        System.out.println("3. SQL 준비");

        // 4. SQL 전송 --> ps가 전송하는 기능을 가지고 있음
        int result = ps.executeUpdate();  // 실행된 row 수, update, delete
        System.out.println("4. SQL 전송");
        System.out.println("실행된 row 수 --> " + result + "개");

        // 5. 연결 종료
        ps.close();
        con.close();
        System.out.println("5. 연결 종료");
    }


}
