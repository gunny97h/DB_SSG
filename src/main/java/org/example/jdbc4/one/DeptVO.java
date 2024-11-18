package org.example.jdbc4.one;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 부서 정보를 저장하기 위한 데이터 객체(VO) 클래스
@Setter
@Getter
@ToString

// ORM 규칙
public class DeptVO {
    // 부서 번호, 부서 이름, 위치 정보를 저장하는 필드 정의
    private int deptno;
    private String dname;
    private String loc;
}



