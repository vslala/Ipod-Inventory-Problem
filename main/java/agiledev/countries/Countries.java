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

    public int getIpodStock(Countries country) {
        switch (country) {
            case BRAZIL:
                return 100;
            case ARGENTINA:
                return 100;
            default:
                return 00;
        }
    }

    public int getIphoneStock(Countries country) {
        switch (country) {
            case BRAZIL:
                return 100;
            case ARGENTINA:
                return 50;
            default:
                return 00;
        }
    }
}
