package org.example.jdbc4.clone;

public class DeptOneUI2 {
    public static void main(String[] args) throws Exception {

        DeptDAO2 dao = new DeptDAO2();
        DeptVO2 bag = dao.one(1);

        System.out.println("검색 결과 >> deptNo = " + bag.getDeptno());
        System.out.println("검색 결과 >> dName = " + bag.getDname());
        System.out.println("검색 결과 >> LOC = " + bag.getLoc());
    }
}
