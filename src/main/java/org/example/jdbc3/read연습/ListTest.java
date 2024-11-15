package org.example.jdbc3.read연습;

import org.example.jdbc2.member.MemberVO;

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

        ArrayList<MemberVO2> list2 = new ArrayList<>();
        MemberVO2 vo1 = new MemberVO2();
        vo1.setId("11");
        vo1.setPw("11");
        MemberVO2 vo2 = new MemberVO2();
        vo2.setId("22");
        vo2.setPw("22");

        list2.add(vo1);
        list2.add(vo2);
        System.out.println(list2);
        System.out.println(list2.get(0));
        System.out.println(list2.get(1));
    }
}
