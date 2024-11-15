package org.example.jdbc2.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//  1.
//    BoardVO를 만들어보세요.
//    int no, String title, String content, String writer
//
//    롬복이용하여 getter/setter/ToString 어노테이션으로 코드 자동  생성!
//
//  2.
//    TestLombok2에 메인을 만들어 BoardVO에 대한 vo를 생성하여
//    값을 넣어보고 값을 꺼내어 출력해보고, vo안에 어떤 값들이 들어있는지 출력!

@Setter
@Getter
@ToString

public class BoardVO {
    private int id;
    private String title;
    private String content;
    private String writer;


}
