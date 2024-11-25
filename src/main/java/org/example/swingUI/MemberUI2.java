package org.example.swingUI;

import org.example.dbcp.MemberDAO;
import org.example.dbcp.MemberVO;
import org.example.jdbc3.read연습.MemberDAO2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// SSG_DB/강의자료/NEW02-MySQL-5(DBCP).pdf  p.39
public class MemberUI2 extends JFrame {

    JLabel top, l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JButton b1, b2, b3;

    MemberUI2() {
        // 객체 생성 시 화면을 만들자.
        setTitle("Member UI");
        setSize(800, 750);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  // 수동으로 위치를 잡아주어야 함.

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

        // setLayout(null); --> add 하기 전에 위치를 잡아주어야 한다.
//        top.setBounds(100, 50, 300, 100);
        top.setBounds(255, 20, 400, 100);

        l1.setBounds(100, 150, 200, 40);
        t1.setBounds(350, 150, 350, 40);

        l2.setBounds(100, 220, 200, 40);
        t2.setBounds(350, 220, 350, 40);

        l3.setBounds(100, 290, 200, 40);
        t3.setBounds(350, 290, 350, 40);

        l4.setBounds(100, 360, 200, 40);
        t4.setBounds(350, 360, 350, 40);

        b1.setBounds(100, 450, 600, 60);
        b2.setBounds(100, 530, 600, 60);
        b3.setBounds(100, 610, 600, 60);


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

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 클릭했을 때 처리할 내용이 구현되어있어야함.
                // 1. id, pw, name, tel 입력한 것 가지고 와서
                String id = t1.getText();
                String pw = t2.getText();
                String name = t3.getText();
                String tel = t4.getText();
                // 2. vo에 넣어주어야 함.
                MemberVO bag = new MemberVO();
                bag.setId(id);
                bag.setPw(pw);
                bag.setName(name);
                bag.setTel(tel);
                // 3. vo를 전달하면서 insert해달라고 요청!
                try {
                    MemberDAO dao = new MemberDAO();
                    dao.insert(bag);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 클릭했을 때 처리할 내용이 구현되어있어야함.
                // 1. id, tel 입력한 것 가지고 와서
                String id = t1.getText();
                String tel = t4.getText();
                // 2. vo에 넣어주어야 함.
                //    --> update는 vo 사용 x
                // 3. update해달라고 요청!
                try {
                    MemberDAO dao = new MemberDAO();
                    dao.update(id, tel);
                    t1.setText("");
                    t4.setText("");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 클릭했을 때 처리할 내용이 구현되어있어야함.
                //1. id입력한 값 가지고 온다.
                String id = t1.getText();
                //2. dao에게 id주면서 검색해달라고 요청
                try {
                    MemberDAO dao = new MemberDAO();
                    MemberVO bag = dao.one(id);
                    //3. dao로부터 받아온 vo를 ui에 보여지게 하자.
                    t1.setText(bag.getId());
                    t2.setText(bag.getPw());
                    t3.setText(bag.getName());
                    t4.setText(bag.getTel());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {  // test용
        new MemberUI2();

    }
}
