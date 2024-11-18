package org.example.jdbc4.list;

import org.example.jdbc4.one.DeptDAO;
import org.example.jdbc4.one.DeptVO;

import java.util.ArrayList;

public class DeptListUI {
    public static void main(String[] args) throws Exception {
        DeptDAO dao = new DeptDAO(); // 1,2단계
        // 모든 리스트를 가지고 오자.
        ArrayList<DeptVO> list = dao.list();
        // list에서 vo를 반복해서 꺼내 출력
        for (DeptVO bag : list) {
            System.out.println("검색 결과 >> deptNo = " + bag.getDeptno());
            System.out.println("검색 결과 >> dName = " + bag.getDname());
            System.out.println("검색 결과 >> LOC = " + bag.getLoc());
            System.out.println("------------------------");
        }
    }
}
