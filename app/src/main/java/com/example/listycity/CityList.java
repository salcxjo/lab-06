package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * Adds a city to the list.
     * @param city the city to add
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void addCity(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists");
        }
        cities.add(city);
        }
    /**
     * Returns a sorted copy of the city list.
     *
     * @return sorted list of cities
     */
        public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
        }
    /**
     * Returns whether the given city is in the list.
     *
     * @param city the city to search for
     * @return true if the city is in the list, false otherwise
     */
        public boolean hasCity(City city){
            return cities.contains(city);
        }
    /**
     * Deletes the given city from the list.
     *
     * @param city the city to delete
     * @throws IllegalArgumentException if the city is not in the list
     */
        public void delete(City city){
            if (cities.contains(city)){cities.remove(city);}
            else {throw new IllegalArgumentException("City does not exist");}
        }
    /**
     * Returns the number of cities in the list.
     *
     * @return the city count
     */
        public int countCities(){
            return cities.size();
        }

}
