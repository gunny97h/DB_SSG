package org.example.jdbc3.read연습;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 부서 정보를 저장하기 위한 데이터 객체(VO) 클래스
@Setter
@Getter
@ToString
public class DeptVO {
    // 부서 번호, 부서 이름, 위치 정보를 저장하는 필드 정의
    private int deptno;
    private String dname;
    private String loc;
}

//package org.example.jdbc3.read연습;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//@Setter
//@Getter
//@ToString
//public class DeptVO {
//    private int deptno;
//    private String dname;
//    private String loc;
//}


