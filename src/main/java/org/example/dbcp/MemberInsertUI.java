package org.example.dbcp;

import java.util.Scanner;

public class MemberInsertUI {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID 입력 >> ");
        String id값 = sc.next();  // apple
        System.out.print("PW 입력 >> ");
        String pw값 = sc.next();  // 1234
        System.out.print("Name 입력 >> ");
        String name값 = sc.next();  // apple
        System.out.print("Tel 입력 >> ");
        String tel값 = sc.next();  // 1111
        sc.close();

        // Member 테이블에 연결해서 입력받은 데이터를 주고 insert 해달라고 호출하기
        // MemberDAO 클래스를 사용해서 insert() 호출
        MemberDAO dao2 = new MemberDAO();

        // 가방 만들기(new) --> 넣기(set) --> 전달
        MemberVO vo = new MemberVO();
        vo.setId(id값);
        vo.setPw(pw값);
        vo.setName(name값);
        vo.setTel(tel값);

        dao2.insert(vo);

    }
}
