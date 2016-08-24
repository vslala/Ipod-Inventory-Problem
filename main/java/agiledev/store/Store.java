package main.java.agiledev.store;

import main.java.agiledev.countries.Country;

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
                            if (brazil.isBrazillian(ui.getPassportID())) {
                                order.sellIpod(ui.getIpodQty());
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


}
