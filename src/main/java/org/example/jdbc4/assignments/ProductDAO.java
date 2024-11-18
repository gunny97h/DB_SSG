package org.example.jdbc4.assignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// SSG_DB/문제/1112-NEW02-JDBC2.pdf
public class ProductDAO {
    Connection con;
    public ProductDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/school2";
        String id = "root";
        String pw = "1234";
        con = DriverManager.getConnection(url, id, pw);
    }

    public void insert(String productname, double price, int quantity) throws Exception {
        String sql = "insert into school2.product (ProductName, Price, Quantity) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, productname);
        ps.setDouble(2, price);
        ps.setInt(3, quantity);
        ps.executeUpdate();
    }

    public ProductVO one(int pruductID) throws Exception {
        String sql = "select * from product where ProductID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, pruductID);

        ResultSet table = ps.executeQuery();
        ProductVO bag = null;  // 반드시 초기화

        if (table.next()) {
            bag = new ProductVO();
            bag.setProductID(table.getInt("ProductID"));
            bag.setProductName(table.getString("ProductName"));
            bag.setPrice(table.getDouble("Price"));
            bag.setQuantity(table.getInt("Quantity"));
        }
        table.close();
        ps.close();
        con.close();
        return bag;
    }

    public ArrayList<ProductVO> list() throws Exception {

        ArrayList<ProductVO> list = null;

        String sql = "select * from product";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet table = ps.executeQuery();

        while (table.next()) {
            //list = new ArrayList<>();  잘못된 방법: 리스트를 매 번 새로 만들게 됨.
            if (list == null) {
                list = new ArrayList<>();
            }
            ProductVO bag = new ProductVO();
            bag.setProductID(table.getInt("ProductID"));
            bag.setProductName(table.getString("productName"));
            bag.setPrice(table.getDouble("price"));
            bag.setQuantity(table.getInt("quantity"));
            list.add(bag);
        }
        table.close();
        ps.close();
        con.close();
        return list;
    }
}
