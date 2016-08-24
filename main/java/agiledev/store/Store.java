package main.java.agiledev.store;

import main.java.agiledev.countries.Country;

/**
 * Created by varunsh on 8/24/2016.
 */
public class Store {
    UI ui = new UI();
    Order order = new Order();
    Country country;
    private int ch;

    public Store () {}

    public Store (Country country) {
        this.country = country;
    }

    public void init () {
        do {
            ui.mainScreen();
            ch = ui.getUserInput();
            switch (ch) {
                case 1:
                    ui.getUserOrder();
                    if (country.isBrazillian(ui.getPassportID())) {
                        country.sellIpod(ui.getIpodQty());
                    }
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


}
