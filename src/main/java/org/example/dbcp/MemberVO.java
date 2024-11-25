package org.example.dbcp;

public class MemberVO {
    private String id;
    private String pw;
    private String name;
    private String tel;

    // 넣을 때 사용하는 메서드 set변수명()
    public void setId(String id) {
        this.id = id;  // 입력된 id를 전역변수 id에 넣기
    }
    // 꺼낼 때 사용하는 메서드  get변수명()
    public String getId() {
        return id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getPw() {
        return pw;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getTel() {
        return tel;
    }
}
