package org.example.jdbc4.clone;

import java.sql.*;
import java.util.ArrayList;

public class DeptDAO2 {
    Connection con;

    public DeptDAO2() throws Exception {
        // JDBC 드라이버를 메모리에 로드하여 DB와의 연결 준비
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 데이터베이스 연결 설정
        String url = "jdbc:mysql://localhost:3306/shop2";
        String id = "root";  // 데이터베이스 사용자 ID
        String pw = "1234";  // 데이터베이스 사용자 비밀번호
        con = DriverManager.getConnection(url, id, pw);  // DB에 연결
    }

    public DeptVO2 one(int deptno) throws Exception {
        String sql = "select * from dept where deptno = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, deptno);

        ResultSet table = ps.executeQuery();

        DeptVO2 bag = new DeptVO2();
        if (table.next()) {
            bag.setDeptno(table.getInt("deptno"));
            bag.setDname(table.getString("dname"));
            bag.setLoc(table.getString("loc"));
        }
        table.close();
        ps.close();
        con.close();
        return bag;
    }

    public ArrayList<DeptVO2> list() throws Exception {

        ArrayList<DeptVO2> list = new ArrayList<>();

        String sql = "select * from dept";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet table = ps.executeQuery();

        while (table.next()) {
            DeptVO2 bag = new DeptVO2();
            bag.setDeptno(table.getInt("deptno"));
            bag.setDname(table.getString("dname"));
            bag.setLoc(table.getString("loc"));
            list.add(bag);
        }
        table.close();
        ps.close();
        con.close();
        return list;
    }
}
