package org.example.dbcp;

// SSG_DB/강의자료/NEW02-MySQL-5(DBCP).pdf  p.34
public class DBCP {
    static DBCP instance;
    // 객체 생성되기 전에 클래스 이름으로 특정한 사용하는 방법
    // 외부에서 DBCP 객체를 만들 수 없음.
    // 생성자를 외부 클래스에서 접근할 수 없도록 private으로 접근제어 지정
    private DBCP() {}

    // 싱글톤
    public static DBCP getInstance() {
        // DBCP 객체가 만들어져 있으면 그것을 return
        // DBCP 객체가 만들어져 있지 않으면 객체를 만들어서 return
        if (instance == null) {
            instance = new DBCP();
        }
        return instance;
    }

}
