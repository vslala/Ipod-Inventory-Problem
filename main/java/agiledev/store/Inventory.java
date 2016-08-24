package main.java.agiledev.store;

/**
 * Created by varunsh on 8/23/2016.
 */
public interface Inventory {
    public void sellIpod(int qty, boolean discont);
    public void sellIphone(int qty, boolean discount);
    public void addIpod (int qty);
    public void addIphone (int qty);
}
