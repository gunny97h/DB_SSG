package org.example.jdbc3.vo연습;

public class 받는DAO {

    // 가방을 전달받는 쪽
    // 파라미터 bag에 넣음
    // 값을 꺼내서 처리

    // 실무에서는 가방에 값이 제대로 들어왔는지 프린트로 확인!
    public void print(Bag bag) {

        System.out.println(bag);
        System.out.println("<<<<< 받은 데이터 프린트 >>>>>");
        System.out.println("----------------------------");
        System.out.println("받은 이름은 - " + bag.getName());
        System.out.println("받은 나이는 - " + bag.getAge());
        System.out.println("받은 취미는 - " + bag.getHobby());
        System.out.println("받은 번호는 - " + bag.getTel());
        System.out.println("----------------------------");
    }
}
