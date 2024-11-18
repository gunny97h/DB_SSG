package org.example.jdbc4.assignments;

import java.util.Scanner;

public class ProductOneUI {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product_ID: ");
        int PID = sc.nextInt();
        sc.close();

        ProductDAO dao = new ProductDAO();
        ProductVO bag = dao.one(PID);

        if (bag != null) {
            System.out.println("검색 결과 >> ProductID = " + bag.getProductID());
            System.out.println("         >> ProductName = " + bag.getProductName());
            System.out.println("         >> Price = " + bag.getPrice());
            System.out.println("         >> Quantity = " + bag.getQuantity());
        } else {
            System.out.println("검색 결과 없음");
        }


    }
}
