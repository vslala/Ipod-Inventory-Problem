package main.java.agiledev.store;

import main.java.agiledev.countries.Country;
import main.java.agiledev.countries.Countries;

/**
 * Created by varunsh on 8/24/2016.
 */
public class Store {

    UI ui = new UI();
    Country brazil = new Country(Countries.BRAZIL), argentina = new Country(Countries.ARGENTINA);
    Order order = new Order(brazil, argentina);
    private int ch;

    public Store () {}

    public Store (Country brazil, Country argentina) {
        this.brazil = brazil;
        this.argentina = argentina;
    }

    public void init () {
        do {
            ui.mainScreen();
            ch = ui.getUserInput();
            switch (ch) {
                case 1: // brazil store
                    ui.subScreen();
                    switch (ui.getUserInput() ) {
                        case 1:
                            ui.getUserOrder();
                            String passportID = ui.getPassportID();
                            int ipodQty = ui.getIpodQty();
                            int iphoneQty = ui.getIphoneQty();
                            sellIpodAndCalculatePrice(brazil, passportID, ipodQty, iphoneQty);
                            sellIpodAndCalculatePrice(argentina, passportID, ipodQty, iphoneQty);
                            break;
                        case 2:
                            System.out.println(order.getTotalPrice());
                            break;
                        case 0:
                            System.exit(0);
                            break;
                    }
                    break;
                case 2: // argentina store

                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } while (this.ch != 0);
    }

    private void swapCountry() {
        order.setCountry1(argentina);
        order.setCountry2(brazil);
    }

    public void sellIpodAndCalculatePrice (Country country, String passportID,
                                           int ipodQty, int iphoneQty) {
        boolean discount = false;
        switch (country.getCountry()) {
            case BRAZIL:
                if (country.isBrazillian(passportID)) {
                    order.sellIpod(ipodQty, discount);
                    order.sellIphone(iphoneQty, discount);
                }
                if (country.isArgentinian(passportID)) {
                    discount = true;
                    order.sellIpod(ipodQty, discount);
                    order.sellIphone(iphoneQty, discount);
                }
                break;
            case ARGENTINA:
                if (country.isArgentinian(passportID)) {
                    discount = false;
                    order.sellIpod(ipodQty, discount);
                    order.sellIphone(iphoneQty, discount);
                }
                if (country.isBrazillian(passportID)) {
                    discount = true;
                    order.sellIpod(ipodQty, discount);
                    order.sellIphone(iphoneQty, discount);
                }
                break;
            default:

                break;
        }
    }

    public static void main (String [] args) {
        new Store(new Country(Countries.BRAZIL), new Country(Countries.ARGENTINA)).init();
    }


}
