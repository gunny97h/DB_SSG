package org.example.jdbc2.member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TestLombok {
    public static void main(String[] args) {
        // 1. 가방을 만든다.
        ProductVO vo = new ProductVO();

        // 2. 가방에 데이터를 넣는다.
        vo.setNo(1);
        vo.setName("신발");
        vo.setContent("부츠");
        vo.setPrice(10000);

        // 3. 가방을 전달한다.


        // 4. 가방에서 데이터를 꺼내자.
        int no = vo.getNo();
        String name = vo.getName();
        String content = vo.getContent();
        int price = vo.getPrice();

        System.out.println(no + " " + name + " " + content + " " + price);
        System.out.println(vo);
    }
}
