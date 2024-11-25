package org.example.swingUI;

import javax.swing.*;
import java.awt.*;
// SSG_DB/강의자료/NEW02-MySQL-5(DBCP).pdf  p.39
public class MemberUI extends JFrame {

    JLabel top, l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JButton b1, b2, b3;

    MemberUI() {
        // 객체 생성 시 화면을 만들자.
        setTitle("Member UI");
        setSize(400, 750);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // JLabel 5개, JTextField 4개, JButton 3개 전역변수
        top = new JLabel("Member");
        top.setFont(new Font("굴림", Font.BOLD, 70));
        Font font = new Font("굴림", Font.BOLD, 40);

        l1 = new JLabel("아이디");
        l2 = new JLabel("패스워드");
        l3 = new JLabel("이름");
        l4 = new JLabel("연락처");
        l1.setFont(font);
        l2.setFont(font);
        l3.setFont(font);
        l4.setFont(font);

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t1.setFont(font);
        t2.setFont(font);
        t3.setFont(font);
        t4.setFont(font);

        b1 = new JButton("회원가입");
        b2 = new JButton("회원수정");
        b3 = new JButton("회원검색");
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);

        add(top);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(b1);
        add(b2);
        add(b3);

        getContentPane().setBackground(Color.gray);

        setVisible(true);
    }

    public static void main(String[] args) {  // test용
        new MemberUI();

    }
}
