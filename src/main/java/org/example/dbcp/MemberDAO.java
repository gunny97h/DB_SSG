package org.example.dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MemberDAO {  // VO 사용
    // DAO 클래스는 member 테이블의 데이터를 접근해서
    // 여러 기능을 정의하고 있는 클래스를 말함.
    // DB 테이블당 DAO는 하나씩 만든다.
    // 테이블이 100개이면 DAO는 1000개를 만든다.

    Connection con;  // 전역변수가 됨. null로 자동초기화
    DBConnectionMgr dbcp;

    public MemberDAO() throws Exception {
        // 싱글톤으로 생성된 DBCP 객체 획득
        dbcp = DBConnectionMgr.getInstance();
    }

    public void insert(MemberVO vo) throws Exception {

        con = dbcp.getConnection();

        // 3. SQL 준비
        String sql = "insert into member values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);  // ps가 ?를 세팅하는 역할
        ps.setString(1, vo.getId());
        ps.setString(2, vo.getPw());
        ps.setString(3, vo.getName());
        ps.setString(4, vo.getTel());
        System.out.println("3. SQL 준비");

        // 4. SQL 전송 --> ps가 전송하는 기능을 가지고 있음
        int result = ps.executeUpdate();  // 실행된 row 수, update, delete
        System.out.println("4. SQL 전송");
        System.out.println("실행된 row 수 --> " + result + "개");

        // 5. 연결 종료
        dbcp.freeConnection(con, ps);
        System.out.println("5. 연결 종료");
    }

    public void delete(String id값) throws Exception {

        con = dbcp.getConnection();

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
        dbcp.freeConnection(con, ps);
        System.out.println("5. 연결 종료");
    }

    public void update(String id값, String tel값) throws Exception {

        con = dbcp.getConnection();

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
        dbcp.freeConnection(con, ps);
        System.out.println("5. 연결 종료");
    }
}
