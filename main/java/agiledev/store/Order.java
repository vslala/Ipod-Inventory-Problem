package main.java.agiledev.store;

import main.java.agiledev.countries.Country;

/**
 * Created by varunsh on 8/24/2016.
 */
public class Order implements Inventory{

    private Country country1;
    private Country country2;
    private double totalPrice = 0.00d;
    private boolean isShipped = true;
    private final double shippingCost = 400.00d;
    private final double shippingCostAfterDiscount = 400 - ( (400.00d * 20) / 100 );

    public Order() {}

    public Order(Country... country) {
        this.setCountry1(country[0]);
        this.setCountry2(country[1]);
    }
    @Override
    public void sellIpod(int qty, boolean discount) {
        if (isIpodInStock(qty)) {
            calculateTotalPrice(qty, discount);
            getCountry1().setIpodStock(getCountry1().getIPODStock() - qty);
            return;
        } else if ((! isIpodStockEmpty()) && qty > country1.getIPODStock()) {
            qty -= country1.getIPODStock();
            sellIpod(country1.getIPODStock(), discount);
            calculateTotalPrice(qty, discount);
            country1.setIpodStock(0);
            return;
        }else {
            isShipped = true;
            if (! borrowIpod(qty, getCountry2())) {
                isShipped = false;
                throw new Country.OutOfStockException();
            };
        }
    }

    private boolean isIpodStockEmpty() {
        return country1.getIPODStock() <= 0;
    }

    private void calculateTotalPrice(int qty, boolean discount) {
        if (isShipped) {
            if (discount)
                totalPrice = (qty * country1.getIPODPrice() + shippingCostAfterDiscount);
            else
                totalPrice = (qty * country1.getIPODPrice() + 400.00d);
        }
    }

    private boolean borrowIpod(int qty, Country country) {
        if (country.getIPODStock() > 10) {
            country.shipIpod(10);
            this.addIpod(10);
            this.sellIpod(qty, false);
            return true;
        }
        return false;
    }

    private boolean isIpodInStock(int qty) {
        return country1.getIPODStock() >= qty;
    }

    public boolean isBrazillian (String passportID) {
        return (passportID.matches("B[0-9]{3}[A-Z]{2}[A-Z0-9]{7}"));
    }

    public boolean isArgentinian(String passportID) {
        return (passportID.matches("A[A-Z]{2}[A-Z0-9]{9}"));
    }



    @Override
    public void sellIphone(int qty, boolean discount) {
        if (isIphoneInStock(qty)) {
            getCountry1().setIphoneStock(getCountry1().getIPHONEStock() - qty);
            calculateTotalPrice(qty, discount);
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
            this.sellIpod(qty, false);
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

    public double getTotalPrice() {
        return totalPrice;
    }


}
