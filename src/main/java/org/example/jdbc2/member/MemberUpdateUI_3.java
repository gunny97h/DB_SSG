package org.example.jdbc2.member;

import java.util.Scanner;

public class MemberUpdateUI_3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 ID 입력 >> ");
        String id값 = sc.next();  // ice
        System.out.print("새 Tel값 입력 >> ");
        String tel값 = sc.next();  // 9999
        sc.close();

        // Member 테이블에 연결해서 입력받은 데이터를 주고 update 해달라고 호출하기
        // MemberDAO 클래스를 사용해서 update() 호출
        MemberDAO_3 dao = new MemberDAO_3();
        dao.update(id값, tel값);

    }
}
