package org.example.jdbc2.board;

import java.util.Scanner;

public class BoardInsertUI {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("No 입력 >> ");
        int no값 = sc.nextInt();
        System.out.print("Title 입력 >> ");
        String title값 = sc.next();
        System.out.print("Content 입력 >> ");
        String content값 = sc.next();
        System.out.print("Writer 입력 >> ");
        String writer값 = sc.next();
        sc.close();

        // Member 테이블에 연결해서 입력받은 데이터를 주고 insert 해달라고 호출하기
        // MemberDAO 클래스를 사용해서 insert() 호출
        BoardDAO dao = new BoardDAO();
        dao.insert(no값, title값, content값, writer값);

    }
}
