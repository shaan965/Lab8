package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        CustomList cityList = MockCityList();
        City newCity = new City("Yellowknife", "Northwest Territories");
        cityList.addCity(newCity);
        assertTrue(cityList.hasCity(newCity));
        assertFalse(cityList.hasCity(new City("Vancouver", "BC")));
    }

    @Test
    void testDelete() {
        CustomList cityList = MockCityList();
        City newCity = new City("Yellowknife", "Northwest Territories");
        cityList.addCity(newCity);
        cityList.deleteCity(newCity);
        assertFalse(cityList.hasCity(newCity));
    }

    @Test
    void testCountCities() {
        CustomList cityList = MockCityList();

        // Assert that the initial count of cities is 0
        assertEquals(0, cityList.countCities());

        // Add a new city to the list and assert that the count increases by 1
        City newCity = new City("Yellowknife", "Northwest Territories");
        cityList.addCity(newCity);
        assertEquals(1, cityList.countCities());

    }

}
