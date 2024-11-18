package org.example.jdbc4.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
            bag.setDname(table.getString("dname")); // index는 변경될 가능성이 높아 컬럼명을 더 선호
            bag.setLoc(table.getString(3));
        }

        table.close();
        ps.close();
        con.close();
        return bag;  // 검색 결과를 담은 DeptVO 객체 반환
    }

    public ArrayList<DeptVO> list() throws Exception {
        // row 하나당 가방(vo) 하나 필요함.
        // ui에 가방 5개 리턴해서 전달하려면 묶어주어야 함.
        // --> 자바에서는 리턴할 때 무조건! 하나로 묶어서 해야함.
        // 가방을 묶어줄 용도로 사용하는 것이 List 타입의 객체를 사용함.
        ArrayList<DeptVO> list = new ArrayList<>();

        //3단계
        String sql = "select * from dept";
        PreparedStatement ps = con.prepareStatement(sql);

        //4단계
        //테이블 형태로 검색결과가 와야하므로, executeQuery()
        ResultSet table = ps.executeQuery(); //컬럼+값들(row)

        while(table.next()) { //true
            //있으면 row에 있는 값들을 꺼내어 vo에 넣자.
            //ORM
            DeptVO bag = new DeptVO();
            bag.setDeptno(table.getInt("deptno"));//1
            bag.setDname(table.getString(2));
            bag.setLoc(table.getString("loc")); //컬럼명
            //db의 인덱스는 1부터 시작
            list.add(bag);
        }

        table.close();
        ps.close();
        con.close();
        return list;
    }
}



