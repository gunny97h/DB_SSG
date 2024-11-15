package org.example.jdbc2.board;

import java.util.Scanner;

public class BoardDeleteUI {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 No 입력 >> ");
        int no값 = sc.nextInt();
        sc.close();

        // Member 테이블에 연결해서 입력받은 데이터를 주고 insert 해달라고 호출하기
        // MemberDAO 클래스를 사용해서 insert() 호출
        BoardDAO dao = new BoardDAO();
        dao.delete(no값);

    }
}
