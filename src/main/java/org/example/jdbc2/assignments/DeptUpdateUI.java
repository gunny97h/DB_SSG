package org.example.jdbc2.assignments;

import java.util.Scanner;

public class DeptUpdateUI {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 DEPTNO 입력 >> ");
        int deptno값 = sc.nextInt();
        System.out.print("새 DNAME 입력 >> ");
        String dname값 = sc.next();
        sc.close();


        // Member 테이블에 연결해서 입력받은 데이터를 주고 insert 해달라고 호출하기

        // 가방 만들기(new) --> 넣기(set) --> 전달
        DeptVO vo = new DeptVO();
        vo.setDeptno(deptno값);
        vo.setDname(dname값);

        // MemberDAO 클래스를 사용해서 insert() 호출
        DeptDAO dao = new DeptDAO();
        dao.update(vo);

    }
}
