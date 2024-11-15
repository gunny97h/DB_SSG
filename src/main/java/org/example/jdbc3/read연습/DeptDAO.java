package org.example.jdbc3.read연습;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 데이터베이스에서 부서 정보를 검색하기 위한 DAO 클래스
public class DeptDAO {
    Connection con;  // 데이터베이스 연결 객체

    // 생성자 메서드: 객체가 생성될 때 드라이버 설정 및 DB 연결을 수행
    public DeptDAO() throws Exception {
        // JDBC 드라이버를 메모리에 로드하여 DB와의 연결 준비
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. 드라이버 설정 성공!");

        // 데이터베이스 연결 설정
        String url = "jdbc:mysql://localhost:3306/shop2";
        String id = "root";  // 데이터베이스 사용자 ID
        String pw = "1234";  // 데이터베이스 사용자 비밀번호
        con = DriverManager.getConnection(url, id, pw);  // DB에 연결
        System.out.println("2. db연결 성공!");
    }

    // 특정 부서 번호에 해당하는 부서 정보를 데이터베이스에서 조회하여 반환
    public DeptVO one(int deptno) throws Exception {
        // SQL 쿼리를 작성하여 특정 부서 번호에 해당하는 부서 정보 검색
        String sql = "select * from dept where deptno = ?";
        PreparedStatement ps = con.prepareStatement(sql);  // SQL 쿼리를 준비하여 실행
        ps.setInt(1, deptno);  // 쿼리의 첫 번째 위치에 부서 번호 삽입

        // 쿼리 실행 후 결과 집합(ResultSet)을 테이블 형태로 받음
        ResultSet table = ps.executeQuery();

        // 결과 집합에서 데이터를 읽어와 DeptVO 객체에 저장
        DeptVO bag = new DeptVO();
        if (table.next()) {  // 결과가 있는 경우, 각 열의 값을 DeptVO 객체에 설정
            bag.setDeptno(table.getInt(1));
            bag.setDname(table.getString("dname"));
            bag.setLoc(table.getString(3));
        }
        return bag;  // 검색 결과를 담은 DeptVO 객체 반환
    }
}
//package org.example.jdbc3.read연습;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//// 1. 없으면, 슬랙에 있는 DeptDAO를 복사해서 프로젝트에 붙이세요.
////    있으면, one()메서드를 본인의 DeptDAO에 붙이세요.
//// 2. DeptVO를 만드세요.
//// 3. DeptOneUI를 만들어서 deptno로 검색해서 검색 결과를 출력해보세요.
//
//public class DeptDAO {
//    Connection con;//전역변수가 됨, null로 초기화!
//
//    public DeptDAO() throws Exception {
//        //new MemberDAO()할 때 클래스이름과 동일한 메서드인 생성자메서드가
//        //                     자동호출됨.(1-2단계를 실행해줌)
//        //1. 드라이버 설정 --> 레이지로딩(실행시에 메모리에 올려줌)
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        System.out.println("1. 드라이버 설정 성공!");
//        //2. db연결
//        String url = "jdbc:mysql://localhost:3306/shop2";
//        String id = "root";
//        String pw = "1234";
//        con = DriverManager.getConnection(url, id, pw);
//        System.out.println("2. db연결 성공!");
//    }
//
//
//
//    public DeptVO one(int dname) throws Exception {
//        // 1,2 단계는 DAO 객체 생성시 벌써 실행됨.
//        // 3,4 단계만 구현하면 됨.
//        // 3. sql문 객체로 준비
//        String sql = "select * from dept where deptno = ?";
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setInt(1, dname);
//        // 4. 준비된 sql문 mysql로 전송
//        ResultSet table = ps.executeQuery();  // 테이블 형태로 mysql로부터 받아와야할 때 사용
//
//        //UI로 ResultSet에 있는 것 있으면 꺼내서 vo에 넣어서 전달하자!
//        DeptVO bag = new DeptVO();
//        if (table.next()) {
//            bag.setDeptno(table.getInt("deptno"));
//            bag.setDname(table.getString("dname"));
//            bag.setLoc(table.getString("loc"));
//        }
//        return bag;
//    }
//}



