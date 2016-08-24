package main.java.agiledev.countries;

/**
 * Created by varunsh on 8/24/2016.
 */
public interface ICountries {

    public double getIPODPrice();
    public double getIPHONEPrice();
    public int getIPODStock ();
    public int getIPHONEStock();

    public int getIPODInitialStock ();
    public int getIPHONEInitialStock();

    void shipIpod(int num);
    void shipIphone(int num);
}
