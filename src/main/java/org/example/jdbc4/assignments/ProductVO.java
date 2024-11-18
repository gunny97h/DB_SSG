package org.example.jdbc4.assignments;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductVO {
    private int productID;
    private String productName;
    private double price;
    private int quantity;
}
