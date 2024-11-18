package org.example.jdbc4.assignments;

import java.util.ArrayList;

public class ProductListUI {
    public static void main(String[] args) throws Exception {

        ProductDAO dao = new ProductDAO();
        ArrayList<ProductVO> list = dao.list();

        if (list != null) {
            System.out.println("-----------------------------");
            for (ProductVO bag : list) {
                System.out.println("검색 결과 >> ProductID = " + bag.getProductID());
                System.out.println("         >> ProductName = " + bag.getProductName());
                System.out.println("         >> Price = " + bag.getPrice());
                System.out.println("         >> Quantity = " + bag.getQuantity());
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("검색 결과 없음");
        }


    }
}
