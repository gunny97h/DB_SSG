package org.example.jdbc2.assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// SSG_DB/문제/1109-NEW02-JDBC2.pdf Q1
public class DeptDAO {

    Connection con;
    public DeptDAO() throws Exception {
        // 1. 드라이버 설정 --> 레이지로딩(실행시에 메모리에 올려줌)
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버 설정");

        // 2. DB 연결
        String url = "jdbc:mysql://localhost:3306/shop2";
        String user = "root";
        String password = "1234";
        con = DriverManager.getConnection(url, user, password);
        System.out.println("2. DB 연결");
    }

    public void insert(DeptVO vo) throws Exception {
        // 3. SQL 준비
        String sql = "insert into dept values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);  // ps가 ?를 세팅하는 역할
        ps.setInt(1, vo.getDeptno());
        ps.setString(2, vo.getDname());
        ps.setString(3, vo.getLoc());
        System.out.println("3. SQL 준비");

        // 4. SQL 전송 --> ps가 전송하는 기능을 가지고 있음
        int result = ps.executeUpdate();
        System.out.println("실행된 row 수 --> " + result + "개");
        System.out.println(vo);
        System.out.println("4. SQL 전송");
        // 5. 연결 종료
        ps.close();
        con.close();
        System.out.println("5. 연결 종료");
    }

    public void insert_many(DeptVO vo) throws Exception {
        // 3. SQL 준비
        String sql = "insert into dept values(?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);  // ps가 ?를 세팅하는 역할
        ps.setInt(1, vo.getDeptno());
        ps.setString(2, vo.getDname());
        ps.setString(3, vo.getLoc());
        System.out.println("3. SQL 준비");

        // 4. SQL 전송 --> ps가 전송하는 기능을 가지고 있음
        int result = ps.executeUpdate();
        System.out.println("실행된 row 수 --> " + result + "개");
        System.out.println(vo);
        System.out.println("4. SQL 전송");
        // 5. 연결 종료
        ps.close();
        con.close();
        System.out.println("5. 연결 종료");
    }

    public void update(DeptVO vo) throws Exception {
        // 3. SQL 준비
        String sql = "update dept set dname = ? where deptno = ?";
        PreparedStatement ps = con.prepareStatement(sql);  // ps가 ?를 세팅하는 역할
        ps.setString(1, vo.getDname());
        ps.setInt(2, vo.getDeptno());

        System.out.println("3. SQL 준비");

        // 4. SQL 전송 --> ps가 전송하는 기능을 가지고 있음
        int result = ps.executeUpdate();
        System.out.println("실행된 row 수 --> " + result + "개");
        System.out.println(vo);
        System.out.println("4. SQL 전송");
        // 5. 연결 종료
        ps.close();
        con.close();
        System.out.println("5. 연결 종료");
    }

    public void delete(DeptVO vo) throws Exception {
        // 3. SQL 준비
        String sql = "delete from dept where deptno = ?";
        PreparedStatement ps = con.prepareStatement(sql);  // ps가 ?를 세팅하는 역할
        ps.setInt(1, vo.getDeptno());

        System.out.println("3. SQL 준비");

        // 4. SQL 전송 --> ps가 전송하는 기능을 가지고 있음
        int result = ps.executeUpdate();
        System.out.println("실행된 row 수 --> " + result + "개");
        System.out.println(vo);
        System.out.println("4. SQL 전송");
        // 5. 연결 종료
        ps.close();
        con.close();
        System.out.println("5. 연결 종료");
    }

}
