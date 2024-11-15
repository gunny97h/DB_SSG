package org.example.jdbc2.assignments;

import java.util.Scanner;

public class DeptDeleteUI {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 DEPTNO 입력 >> ");
        int deptno값 = sc.nextInt();
        sc.close();


        // Member 테이블에 연결해서 입력받은 데이터를 주고 insert 해달라고 호출하기

        // 가방 만들기(new) --> 넣기(set) --> 전달
        DeptVO vo = new DeptVO();
        vo.setDeptno(deptno값);

        // MemberDAO 클래스를 사용해서 insert() 호출
        DeptDAO dao = new DeptDAO();
        dao.delete(vo);

    }
}
