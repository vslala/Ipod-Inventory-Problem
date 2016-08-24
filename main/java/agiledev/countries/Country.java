package main.java.agiledev.countries;

import main.java.agiledev.store.Inventory;
import main.java.agiledev.store.Products;

/**
 * Created by varunsh on 8/23/2016.
 */
public class Country implements ICountries, Inventory {
    Countries country;
    private int iphoneStock;
    private int ipodStock;

    public Country(Countries country) {
        this.country = country;
        iphoneStock = getIPHONEInitialStock();
        ipodStock = getIPODInitialStock();
    }

    @Override
    public double getIPODPrice() {
        return country.getIpodSellingPrice(country);
    }

    @Override
    public double getIPHONEPrice() {
        return country.getIphoneSellingPrice(country);
    }

    @Override
    public int getIPODStock() {
        return ipodStock;
    }

    @Override
    public int getIPHONEStock() {
        return iphoneStock;
    }

    @Override
    public int getIPODInitialStock() {
        return country.getIpodStock(country);
    }

    @Override
    public int getIPHONEInitialStock() {
        return country.getIphoneStock(country);
    }

    @Override
    public void shipIpod(int num) {
        this.ipodStock -= num;
    }

    @Override
    public void sellIphone(Country... countries) {
        sellIphone();
    }

    @Override
    public void sellIpod(Country... countries) {
        if (ipodStock <= 0) {
            for (Country country: countries) {
                if (country.ipodStock > 10) {
                    country.shipIpod(10);
                    this.addIpod(10);
                    return;
                }
            }
            throw new OutOfStockException();
        }
        sellIpod();

    }

    @Override
    public void sellIphone() {
        iphoneStock -= 1;
    }

    @Override
    public void sellIpod() {
        ipodStock -= 1;
    }

    @Override
    public void sellIphone(int num) {
        iphoneStock -= num;
    }

    @Override
    public void sellIpod(int num) {
        ipodStock -= num;
    }

    @Override
    public void addIphone(int num, Country... countries) {
        iphoneStock += num;
    }

    @Override
    public void addIpod(int num, Country... countries) {
        ipodStock += num;
    }

    @Override
    public void addIphone(int num) {
        ipodStock += num;
    }

    @Override
    public void addIpod(int num) {
        ipodStock += num;
    }

    @Override
    public void addIphone() {
        iphoneStock += 1;
    }

    @Override
    public void addIpod() {
        ipodStock += 1;
    }


    public boolean isBrazillian (String passportID) {
        return (passportID.matches("B[0-9]{3}[A-Z]{2}[A-Z0-9]{7}"));
    }

    public boolean isArgentinian(String passportID) {
        return (passportID.matches("A[A-Z]{2}[A-Z0-9]{9}"));
    }


    public class OutOfStockException extends RuntimeException {
    }
}
