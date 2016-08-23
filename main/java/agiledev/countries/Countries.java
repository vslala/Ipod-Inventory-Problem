package main.java.agiledev.countries;

/**
 * Created by varunsh on 8/23/2016.
 */
public enum Countries {
    BRAZIL, ARGENTINA;

    public double getIpodSellingPrice(Countries country) {
        switch (country) {
            case BRAZIL:
                return 65.00d;
            case ARGENTINA:
                return 100.00d;
            default:
                return 00.00d;
        }
    }

    public double getIphoneSellingPrice(Countries country) {
        switch (country) {
            case BRAZIL:
                return 100.00d;
            case ARGENTINA:
                return 150.00d;
            default:
                return 00.00d;
        }
    }
}
