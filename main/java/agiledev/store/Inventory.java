package main.java.agiledev.store;

import main.java.agiledev.countries.Countries;

/**
 * Created by varunsh on 8/23/2016.
 */
public class Inventory {

    private int initailIpodStock;
    private int initailIPhoneDStock;

    public boolean isEmpty(Countries country, Products product) {
        return false;
    }

    private void setInitialProductStock(Products product, int i, int i1) {
        switch (product){
            case IPOD:
                this.initailIpodStock = 100;
                break;
            case IPHONE:
                this.initailIPhoneDStock = 100;
                break;
            default:

                break;
        }
    }

    public void setInitailStock(Countries country) {
        switch (country) {
            case BRAZIL:
                setInitialProductStock(Products.IPOD, 100, 100);
                setInitialProductStock(Products.IPHONE, 100, 100);
                break;
            case ARGENTINA:
                setInitialProductStock(Products.IPOD, 100, 100);
                setInitialProductStock(Products.IPHONE, 100, 50);
        }
    }
}
