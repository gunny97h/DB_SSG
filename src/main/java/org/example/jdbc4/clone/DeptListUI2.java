package org.example.jdbc4.clone;

import java.util.ArrayList;

public class DeptListUI2 {
    public static void main(String[] args) throws Exception {

        DeptDAO2 dao = new DeptDAO2();
        ArrayList<DeptVO2> list = dao.list();

        System.out.println("-----------------------------");
        for (DeptVO2 bag : list) {
            System.out.println("검색 결과 >> deptNo = " + bag.getDeptno());
            System.out.println("         >> dName = " + bag.getDname());
            System.out.println("         >> LOC = " + bag.getLoc());
            System.out.println("-----------------------------");
        }
    }
}
