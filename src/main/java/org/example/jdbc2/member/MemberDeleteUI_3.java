package org.example.jdbc2.member;

import java.util.Scanner;

public class MemberDeleteUI_3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 ID 입력 >> ");  // apple
        String id값 = sc.next();
        sc.close();

        // Member 테이블에 연결해서 입력받은 데이터를 주고 delete 해달라고 호출하기
        // MemberDAO 클래스를 사용해서 delete() 호출
        MemberDAO_3 dao = new MemberDAO_3();
        dao.delete(id값);

    }
}
