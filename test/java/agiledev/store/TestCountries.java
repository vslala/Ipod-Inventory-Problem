package test.java.agiledev.store;

import main.java.agiledev.countries.Countries;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by varunsh on 8/23/2016.
 */
public class TestCountries {
    @Test
    public void itShouldReturnIPODPriceForGivenCountry() {
        System.out.println(Countries.BRAZIL.getIpodSellingPrice(Countries.BRAZIL));
    }
}
