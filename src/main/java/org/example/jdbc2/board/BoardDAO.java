package org.example.jdbc2.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
   shop2 db 이용
  - board
    no int, title varchar(100), content varchar(100), writer(100)

  - BoardDAO를 MemberDAO를 복사해서
    다른 메서드(update/delete)는 지우고 insert()메서드를 구현

  - BoardInsertUI.java를 MemberInsertUI.java를 복사해서
    BoardDAO의 insert()메서드를 호출하여 삽입 처리

  --> insert다 하신 분들은 update()복사 후 구현 BoardUpdateUI.java실행
      update board set content = ? where no = ?
  --> update다 하신 분들은 delete()복사 후 구현 BoardDeleteUI.java실행
      delete from board where no = ?
 */

/*
CREATE TABLE `board` (
  `no` int NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `writer` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 */

public class BoardDAO {

    Connection con;
    public BoardDAO() throws Exception {

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

    public void insert(int no값, String title값, String content값, String writer값) throws Exception {
        // 3. SQL 준비
        String sql = "insert into board values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);  // ps가 ?를 세팅하는 역할
        ps.setInt(1, no값);
        ps.setString(2, title값);
        ps.setString(3, content값);
        ps.setString(4, writer값);
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

    public void delete(int no값) throws Exception {
        // 3. SQL 준비
        String sql = "delete from board where no = ?";
        PreparedStatement ps = con.prepareStatement(sql);  // ps가 ?를 세팅하는 역할
        ps.setInt(1, no값);
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

    public void update(int no값, String content값) throws Exception {
        // 3. SQL 준비
        String sql = "update board set content = ? where no = ?";
        PreparedStatement ps = con.prepareStatement(sql);  // ps가 ?를 세팅하는 역할
        ps.setString(1, content값);
        ps.setInt(2, no값);
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
