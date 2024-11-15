package org.example.jdbc2.assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeptDAO2 {
    public static void main(String[] args) throws Exception {
        //1. 드라이버 설정 --> 레이지로딩(실행시에 메모리에 올려줌)
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버 설정 성공!");
        //2. db연결
        String url = "jdbc:mysql://localhost:3306/shop2";
        String id = "root";
        String pw = "1234";
        Connection con = DriverManager.getConnection(url, id, pw);
        System.out.println("2. db연결 성공!");

        //3. sql준비 --> sql객체
        StringBuilder sqlBuilder = new StringBuilder("INSERT INTO dept VALUES ");
        for (int i = 100; i < 1000; i++) {
            sqlBuilder.append("(").append(i).append(", 'dname").append(i).append("', 'loc").append(i).append("')");
            if (i < 999) {
                sqlBuilder.append(", ");
            }
        }
        String sql = sqlBuilder.toString();


        //insert into member values ('apple',...)
        //ps가 ?를 셋팅하는 역할!
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.println("3. sql준비 --> sql객체 성공!");

        //4. sql전송 --> ps가 전송하는 기능을 가지고 있음.
        int result = ps.executeUpdate();
        System.out.println("4. sql전송 성공!");
        System.out.println("실행된 row수 --> " + result + "개");

        ps.close();
        con.close(); //관련 자원들 메모리에서 해제!

        // delete from dept where deptno >= 100;
        // SELECT * FROM shop2.dept;
    }
}
