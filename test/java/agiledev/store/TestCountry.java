package test.java.agiledev.store;

import main.java.agiledev.countries.Countries;
import main.java.agiledev.countries.Country;
import org.junit.Test;

/**
 * Created by varunsh on 8/23/2016.
 */
public class TestCountry {
    Country country = new Country();
    @Test
    public void itShouldCheckIfInventoryOfGivenCountryIsEmpty(){
        country.isInventoryEmpty(Countries.BRAZIL);
    }
}
