package main.java.agiledev.store;

import java.util.Scanner;

/**
 * Created by varunsh on 8/24/2016.
 */
public class UI {
    Scanner in;
    private int iphoneQty;
    private String passportID;
    private int ipodQty;
    private int ch;

    public void getUserOrder() {
        in = new Scanner(System.in);
        System.out.println("Enter passport ID");
        this.setPassportID(in.nextLine());
        System.out.println("Enter the quantity for IPOD");
        this.setIpodQty(Integer.parseInt(in.nextLine()));
        System.out.println("Enter the quantity for IPHONE");
        this.setIphoneQty(Integer.parseInt(in.nextLine()));
    }

    public void mainScreen () {
        System.out.println("1. Make an Order");
        System.out.println("0. Exit");
    }

    public int getUserInput () {
        in = new Scanner(System.in);
        this.ch = Integer.parseInt(in.nextLine());
        return ch;
    }

    public int getIphoneQty() {
        return iphoneQty;
    }

    public void setIphoneQty(int iphoneQty) {
        this.iphoneQty = iphoneQty;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public int getIpodQty() {
        return ipodQty;
    }

    public void setIpodQty(int ipodQty) {
        this.ipodQty = ipodQty;
    }
}
