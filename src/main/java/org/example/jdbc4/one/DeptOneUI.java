package org.example.jdbc4.one;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.swing.*;
import java.util.Scanner;

@Setter
@Getter
@ToString

public class DeptOneUI {
    public static void main(String[] args) throws Exception {
        // Scanner 객체를 사용하여 사용자로부터 부서 번호(deptno)를 입력 받음
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 deptno 입력 >> ");
        int deptno = sc.nextInt();  // 사용자로부터 정수 입력 받음
        sc.close();  // 입력이 완료되면 Scanner 객체를 닫아 메모리 누수 방지

        // DeptDAO 객체를 생성하여 데이터베이스 작업 수행
        DeptDAO dao = new DeptDAO();
        // 사용자가 입력한 부서 번호에 해당하는 정보를 검색하여 DeptVO 객체로 반환받음
        DeptVO bag = dao.one(deptno);

        System.out.println("검색 결과 >> deptNo = " + bag.getDeptno());
        System.out.println("검색 결과 >> dName = " + bag.getDname());
        System.out.println("검색 결과 >> LOC = " + bag.getLoc());

        // 가져온 데이터(DeptVO 객체)를 문자열 형태로 조합하여 total 변수에 저장
        //String total = bag.getDeptno() + " " + bag.getDname() + " " + bag.getLoc();
        // 조합된 데이터를 메시지 창으로 표시하여 사용자에게 보여줌
        //JOptionPane.showMessageDialog(null, total);
    }
}