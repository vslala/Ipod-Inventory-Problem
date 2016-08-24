package main.java.agiledev.store;

import main.java.agiledev.countries.Countries;
import main.java.agiledev.countries.Country;

import java.util.List;

/**
 * Created by varunsh on 8/23/2016.
 */
public interface Inventory {
    public void sellIpod (int qty);
    public void sellIphone (int qty);
    public void addIpod (int qty);
    public void addIphone (int qty);
}
