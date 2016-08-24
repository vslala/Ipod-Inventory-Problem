package main.java.agiledev.store;

import main.java.agiledev.countries.Country;
import main.java.agiledev.countries.Countries;

/**
 * Created by varunsh on 8/24/2016.
 */
public class Store {

    UI ui = new UI();
    Country brazil, argentina;
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
                            if (brazil.isBrazillian(passportID)) {
                                order.sellIpod(ipodQty, false);
                            }
                            if (brazil.isArgentinian(passportID)) {
                                order.sellIpod(ipodQty, true);
                            }
                            if (brazil.isBrazillian(passportID)) {
                                order.sellIphone(iphoneQty, false);
                            }
                            if (brazil.isArgentinian(passportID)) {
                                order.sellIphone(iphoneQty, true);
                            }
                            swapCountry();
                            if (argentina.isArgentinian(passportID)) {
                                order.sellIpod(ipodQty, false);
                            }
                            if (argentina.isBrazillian(passportID)) {
                                order.sellIpod(ipodQty, true);
                            }


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

    public void sellIpodAndCalculatePrice (Country country1, Country country2, String passportID,
                                           int ipodQty, int iphoneQty) {
        boolean discount = false;
        switch (country1.getCountry()) {
            case BRAZIL:
                if (country1.isBrazillian(passportID)) {
                    order.sellIpod(ipodQty, discount);
                    order.sellIphone(iphoneQty, discount);
                }
                if (country1.isArgentinian(passportID)) {
                    order.sellIpod(ipodQty, true);
                    order.sellIphone(iphoneQty, true);
                }
                    break;
            case ARGENTINA:

                break;
            default:

                break;
        }
    }


}
