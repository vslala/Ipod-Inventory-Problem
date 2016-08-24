package main.java.agiledev.store;

import main.java.agiledev.countries.Countries;
import main.java.agiledev.countries.Country;

/**
 * Created by varunsh on 8/24/2016.
 */
public class Order implements Inventory{

    private Country country1;
    private Country country2;
    private double totalSale = 0.00d;

    public Order() {}

    public Order(Country... country) {
        this.setCountry1(country[0]);
        this.setCountry2(country[1]);
    }
    @Override
    public void sellIpod(int qty) {
        if (isIpodInStock(qty)) {
            getCountry1().setIpodStock(getCountry1().getIPODStock() - qty);
            return;
        } else {
            if (! borrowIpod(qty, getCountry2())) {
                throw new Country.OutOfStockException();
            };
        }
    }

    private boolean borrowIpod(int qty, Country country) {
        if (country.getIPODStock() > 10) {
            country.shipIpod(10);
            this.addIpod(10);
            this.sellIpod(qty);
            return true;
        }
        return false;
    }

    private boolean isIpodInStock(int qty) {
        return getCountry1().getIPODStock() >= qty;
    }

    public boolean isBrazillian (String passportID) {
        return (passportID.matches("B[0-9]{3}[A-Z]{2}[A-Z0-9]{7}"));
    }

    public boolean isArgentinian(String passportID) {
        return (passportID.matches("A[A-Z]{2}[A-Z0-9]{9}"));
    }

    @Override
    public void sellIphone(int qty) {
        if (isIphoneInStock(qty)) {
            getCountry1().setIphoneStock(getCountry1().getIPHONEStock() - qty);
            return;
        }

        if (isIphoneNotInStock(qty)) {
            if (!borrowIphone(getCountry2(), qty))
                throw new Country.OutOfStockException();
        }
    }

    private boolean borrowIphone(Country country, int qty) {
        if (country.getIPHONEStock() > 10) {
            country.shipIpod(10);
            this.addIphone(10);
            this.sellIpod(qty);
            return true;
        }
        return false;
    }

    private boolean isIphoneNotInStock(int qty) {
        return getCountry1().getIPHONEStock() < qty;
    }

    private boolean isIphoneInStock(int qty) {
        return getCountry1().getIPHONEStock() >= qty;
    }

    @Override
    public void addIpod(int qty) {
        getCountry1().setIpodStock(getCountry1().getIPODStock() + qty);
    }

    @Override
    public void addIphone(int qty) {
        getCountry1().setIphoneStock(getCountry1().getIPHONEStock() + qty);
    }

    public Country getCountry1() {
        return country1;
    }

    public void setCountry1(Country country1) {
        this.country1 = country1;
    }

    public Country getCountry2() {
        return country2;
    }

    public void setCountry2(Country country2) {
        this.country2 = country2;
    }
}
