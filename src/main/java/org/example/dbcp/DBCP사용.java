package org.example.dbcp;

public class DBCP사용 {
    public static void main(String[] args) {
        // DBCP dbcp = new DBCP();
        DBCP dbcp1 = DBCP.getInstance();  // 없으면 만들어서 return, 있으면 있는 거 return.
        DBCP dbcp2 = DBCP.getInstance();
        System.out.println(dbcp1);
        System.out.println(dbcp2);
    }
}
