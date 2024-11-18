package org.example.jdbc4.assignments;

import java.util.Scanner;

public class ProductInsertUI {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("ProductName 입력 >> ");
        String productName = sc.next();
        System.out.print("Price 입력 >> ");
        double price = sc.nextDouble();
        System.out.print("Quantity 입력 >> ");
        int quantity = sc.nextInt();
        sc.close();

        ProductDAO dao = new ProductDAO();
        dao.insert(productName, price, quantity);

    }
}
