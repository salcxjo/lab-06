package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.addCity(mockCity());
        return cityList;
    }
    private City mockCity(){
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.addCity(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.addCity(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.addCity(city);
        });
    }
    @Test
    void testGetCities(){
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Saskatoon", "Saskatchewan");
        cityList.addCity(city);
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0))); // Edmonton at 0
        assertEquals(0, city.compareTo(cityList.getCities().get(1)));       // Saskatoon at 1
    }

    //With help from Claude
    //- Test to see whether hasCity is correct
    //- Test to see if delete() actually removes it from the list
    //- Test to see if the exception is actually thrown in delete()
    //- Test to see whether countCities() method is correct

    //On February 12th 2026
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        // Should find a city with the same values (tests equals() is working)
        assertTrue(cityList.hasCity(mockCity()));
        // Should not find a city that was never added
        assertFalse(cityList.hasCity(new City("Vancouver", "BC")));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        cityList.delete(mockCity());
        // Should actually be gone after deletion
        assertFalse(cityList.hasCity(mockCity()));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        // Deleting a city that doesn't exist should throw
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(new City("Vancouver", "BC"));
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        // mockCityList() adds 1 city, so expect 1
        assertEquals(1, cityList.countCities());
        cityList.addCity(new City("Calgary", "Alberta"));
        // After adding another, expect 2
        assertEquals(2, cityList.countCities());
    }
}
