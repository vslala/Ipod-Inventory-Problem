package main.java.agiledev.countries;

/**
 * Created by varunsh on 8/23/2016.
 */
public class Country implements ICountries {
    Countries country;
    private int iphoneStock;
    private int ipodStock;

    public Country(Countries country) {
        this.country = country;
        setIphoneStock(getIPHONEInitialStock());
        setIpodStock(getIPODInitialStock());
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
        return getIpodStock();
    }

    @Override
    public int getIPHONEStock() {
        return getIphoneStock();
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
        this.setIpodStock(this.getIpodStock() - num);
    }

    @Override
    public void shipIphone(int num) {
        this.setIphoneStock(this.getIPHONEStock() - num);
    }


    public boolean isBrazillian (String passportID) {
        return (passportID.matches("B[0-9]{3}[A-Z]{2}[A-Z0-9]{7}"));
    }

    public boolean isArgentinian(String passportID) {
        return (passportID.matches("A[A-Z]{2}[A-Z0-9]{9}"));
    }

    public int getIphoneStock() {
        return iphoneStock;
    }

    public void setIphoneStock(int iphoneStock) {
        this.iphoneStock = iphoneStock;
    }

    public int getIpodStock() {
        return ipodStock;
    }

    public void setIpodStock(int ipodStock) {
        this.ipodStock = ipodStock;
    }


    public static class OutOfStockException extends RuntimeException {
    }
}
