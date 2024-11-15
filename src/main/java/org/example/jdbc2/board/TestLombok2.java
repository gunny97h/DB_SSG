package org.example.jdbc2.board;

public class TestLombok2 {
    public static void main(String[] args) {

        BoardVO vo = new BoardVO();

        vo.setId(1);
        vo.setContent("content");
        vo.setTitle("title");
        vo.setWriter("writer");

        int id = vo.getId();
        String content = vo.getContent();
        String title = vo.getTitle();
        String writer = vo.getWriter();

        System.out.println(id + " " + content + " " + title + " " + writer );

        System.out.println(vo);

    }
}
