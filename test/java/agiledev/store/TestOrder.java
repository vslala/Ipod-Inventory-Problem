package test.java.agiledev.store;

import main.java.agiledev.countries.Countries;
import main.java.agiledev.countries.Country;
import main.java.agiledev.store.Order;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by varunsh on 8/24/2016.
 */
public class TestOrder {
    Order order;
    Country brazil = new Country(Countries.BRAZIL);
    Country argentina = new Country(Countries.ARGENTINA);
    @Test
    public void itShouldCheckIfIPODInventoryOfGivenCountryIsEmpty(){
        order = new Order(brazil, argentina);
        boolean flag = false;
        order.sellIpod(100);
        if (brazil.getIPODStock() == 0) {
            flag = true;
            Assert.assertTrue(flag);
            return;
        }
        Assert.assertFalse(flag);
    }

    @Test
    public void itShouldDeductOneFromTheIpodStockOfTheGivenCountry() {
        Country country1 = new Country(Countries.BRAZIL);
        Country country2 = new Country(Countries.ARGENTINA);
        order = new Order(country1, country2);
        order.sellIpod(1);
        order.sellIphone(1);
        order.setCountry1(country2);
        order.setCountry2(country1);
        order.sellIpod(1);
        order.sellIphone(1);
        Assert.assertEquals(99, country1.getIPODStock());
        Assert.assertEquals(99, country1.getIPHONEStock());
        Assert.assertEquals(99, country2.getIPODStock());
        Assert.assertEquals(49, country2.getIPHONEStock());
    }

    @Test
    public void itShouldAddOneToTheExisitingStock() {
        Country country1 = new Country(Countries.BRAZIL);
        Country country2 = new Country(Countries.ARGENTINA);
        order = new Order(country1, country2);
        order.sellIpod(1);
        order.sellIphone(1);

        order.addIpod(1);
        order.addIphone(1);

        Assert.assertEquals(100, country1.getIPODStock());
        Assert.assertEquals(100, country1.getIPHONEStock());
    }

    @Test
    public void itShouldBorrowTenIPODSFromOtherCountryIfItsIPODInventoryGetsEmpty() {
        Country country1 = new Country(Countries.BRAZIL);
        Country country2 = new Country(Countries.ARGENTINA);
        order = new Order(country1, country2);
        order.sellIpod(110);
        Assert.assertEquals(90, country2.getIPODStock());
    }

    @Test (expected = Country.OutOfStockException.class)
    public void itShouldThrowOutOfStockExceptionIFOtherCountryStockIsLessThan10() {
        Country country1 = new Country(Countries.BRAZIL);
        Country country2 = new Country(Countries.ARGENTINA);
        order = new Order(country1, country2);
        order.sellIpod(100);
        order.sellIpod(95);
        order.sellIpod(1);
    }


}
