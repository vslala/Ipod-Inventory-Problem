package main.java.agiledev.countries;

import main.java.agiledev.store.Inventory;
import main.java.agiledev.store.Products;

/**
 * Created by varunsh on 8/23/2016.
 */
public class Country {
    Inventory inventory;

    public Country() {}

    public Country(Countries country) {
        inventory = new Inventory();
        inventory.setInitailStock(country);
    }

    public boolean isInventoryEmpty(Countries country, Products product) {
        return inventory.isEmpty(country, product);
    }
}
