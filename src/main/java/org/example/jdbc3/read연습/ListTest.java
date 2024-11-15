package org.example.jdbc3.read연습;

import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("금요일");
        list.add("툐요일");
        list.add("일요일");
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        System.out.println("-----------------------------------");

        ArrayList<MemberOneVO> list2 = new ArrayList<>();
        MemberOneVO vo1 = new MemberOneVO();
        vo1.setId("11");
        vo1.setPw("11");
        MemberOneVO vo2 = new MemberOneVO();
        vo2.setId("22");
        vo2.setPw("22");

        list2.add(vo1);
        list2.add(vo2);
        System.out.println(list2);
        System.out.println(list2.get(0));
        System.out.println(list2.get(1));
    }
}
