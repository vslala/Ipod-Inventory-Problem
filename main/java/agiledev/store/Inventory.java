package main.java.agiledev.store;

import main.java.agiledev.countries.Countries;
import main.java.agiledev.countries.Country;

import java.util.List;

/**
 * Created by varunsh on 8/23/2016.
 */
public interface Inventory {
    public void sellIphone(Country... countries);
    public void sellIpod(Country... countries);
    public void sellIphone();
    public void sellIpod();
    public void sellIphone(int num);
    public void sellIpod(int num);
    public void addIphone(int num, Country... countries);
    public void addIpod(int num, Country... countries);
    public void addIphone(int num);
    public void addIpod(int num);
    public void addIphone();
    public void addIpod();
}
