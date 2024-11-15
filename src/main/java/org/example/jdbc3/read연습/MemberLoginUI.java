package org.example.jdbc3.read연습;

import java.util.Scanner;

/*
#### SSG_DB/강의자료/NEW02-MySQL-5(JDBC).pdf  p.65 ####
-- id, pw가 동일해야 로그인 성공

-- 방법1. id를 주고 검색을 해서 pw를 찾아온 후
-- 	  자바에서 pw가 동일한지 체크 --> 입력 pw 1234 == db 검색 pw 1234
select pw from member where id = 'ice'; -- > db에서 처리
-- 입력 pw 1234 == db검색pw 1234 --> 자바처리 : 권장x

-- 방법2. id, pw 둘 다 넣어서 db에서 검색하여 id가 있으면 로그인 성공
select id from member where id = 'ice' and pw = '1234';
-- db에서 처리할 수 있으면 다 처리해서 결과만 자바로 받아오는 것이 좋음.
-- 로그인 후 정보를 가져오려면 2번 방법

-- 방법3. id, pw 둘 다 넣어서 db에서 검색하여 몇 개 있는지 세어서 1이면 로그인 성공
select count(*) from member where id = 'ice' and pw = '1234';
select 1 from member where id = 'ice' and pw = '1234';  -- 조건이 맞아야 1이 출력
select 1 from member where id = 'ice2' and pw = '1234';
-- 단순히 로그인만 한다면 3번 방법
 */
public class MemberLoginUI {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("로그인 할 ID 입력 >> ");
        String id = sc.next();
        System.out.print("로그인 할 PW 입력 >> ");
        String pw = sc.next();
        sc.close();

        MemberOneDAO dao = new MemberOneDAO();
        // vo 쓰는 기준!!!
        // 가방 만들고
        MemberOneVO bag = new MemberOneVO();
        // 값 넣고
        bag.setId(id);
        bag.setPw(pw);
        // 전달하고
        boolean result = dao.login(bag);
        // 결과 출력 UI에 해야함.
        if (result) {
            System.out.println("로그인 성공!");
        } else {
            System.out.println("로그인 실패!");
        }


    }
}
