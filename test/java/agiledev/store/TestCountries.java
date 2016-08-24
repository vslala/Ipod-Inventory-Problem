package test.java.agiledev.store;

import main.java.agiledev.countries.Countries;
import main.java.agiledev.countries.Country;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by varunsh on 8/23/2016.
 */
public class TestCountries {
    @Test
    public void itShouldReturnIPODPriceForGivenCountry() {
        Country country = new Country(Countries.BRAZIL);
    }
}
