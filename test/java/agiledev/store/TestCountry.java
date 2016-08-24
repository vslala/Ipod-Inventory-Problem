package test.java.agiledev.store;

import main.java.agiledev.countries.Countries;
import main.java.agiledev.countries.Country;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by varunsh on 8/23/2016.
 */
public class TestCountry {
    Country country;
    @Test
    public void itShouldCheckIfIPODInventoryOfGivenCountryIsEmpty(){
        country = new Country(Countries.BRAZIL);
        boolean flag = false;
        for (int i=0; i < country.getIPHONEInitialStock(); i++) {
            country.sellIpod();
            country.getIPODStock();
        }
        if (country.getIPODStock() == 0) {
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
        country1.sellIpod();
        country1.sellIphone();
        country2.sellIpod();
        country2.sellIphone();
        Assert.assertEquals(99, country1.getIPODStock());
        Assert.assertEquals(99, country1.getIPHONEStock());
        Assert.assertEquals(99, country2.getIPODStock());
        Assert.assertEquals(49, country2.getIPHONEStock());
    }

    @Test
    public void itShouldAddOneToTheExisitingStock() {
        country = new Country(Countries.BRAZIL);
        country.sellIpod();
        country.sellIphone();

        country.addIpod();
        country.addIphone();

        Assert.assertEquals(100, country.getIPODStock());
        Assert.assertEquals(100, country.getIPHONEStock());
    }

    @Test
    public void itShouldBorrowTenIPODSFromOtherCountryIfItsIPODInventoryGetsEmpty() {
        country = new Country(Countries.BRAZIL);
        Country country1 = new Country(Countries.ARGENTINA);
        country.sellIpod(100);
        country.sellIpod(country1);
        Assert.assertEquals(90, country1.getIPODStock());
    }

    @Test (expected = Country.OutOfStockException.class)
    public void itShouldThrowOutOfStockExceptionIFOtherCountryStockIsLessThan10() {
        country = new Country(Countries.BRAZIL);
        Country country1 = new Country(Countries.ARGENTINA);
        country.sellIpod(100);
        country1.sellIpod(95);
        country.sellIpod(country1);
    }

}
