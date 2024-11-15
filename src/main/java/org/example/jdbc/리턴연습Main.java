package org.example.jdbc;

import java.util.Date;

public class 리턴연습Main {
    public static void main(String[] args) throws Exception {
        리턴연습 test = new 리턴연습();
        int[] arr = test.getArray();  // int[]
        System.out.println(arr[0] + arr[1]);

//        Connection con = test.getConnection("http://www.naver.com", "root", "1234");
//        con.setAutoCommit(false);
//
//        Connection con2 = test.getConnection("http://www.naver.com");
//        System.out.println(con2.isClosed());

        Date date = test.getDate();
        System.out.println(date.getTime());

        test.getSum(1, 2);
        int i = test.getSum(1222);
        System.out.println("보너스까지 추가된 금액은 " + i);
    }
}
