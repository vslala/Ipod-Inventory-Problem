package main.java.agiledev.store.database;

import main.java.agiledev.store.constants.ProductConstant;
import main.java.agiledev.store.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by varunsh on 8/23/2016.
 */
public class Products {
    final static Products products = new Products();
    public List<Product> productsList = new ArrayList<Product>();

    private Products () { initProducts(); }

    public static Products getInstance() {
        return products;
    }

    public void initProducts() {
        for (int i=0; i < 100; i++) {
            productsList.add(new Product(ProductConstant.IPOD, 100));
            productsList.add(new Product(ProductConstant.IPHONE, 100));
        }
    }
}
