package com.example.listycity;

import java.util.Objects;
/**
 * Represents a city with a name and province.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;
    /**
     * Constructs a City with the given name and province.
     *
     * @param city     the name of the city
     * @param province the province the city is in
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
}
    /**
     * Returns the name of the city.
     *
     * @return the city name
     */
String getCityName() {
        return this.city;
}
    /**
     * Returns the province the city is in.
     *
     * @return the province name
     */
String getProvinceName() {
        return this.province;
}
    /**
     * Compares this city to another alphabetically by city name.
     *
     * @param other the other city to compare to
     * @return negative if this city comes first, positive if it comes last, 0 if equal
     */
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.city);
    }
    /**
     * Returns true if the given object is a City with the same name and province.
     *
     * @param obj the object to compare
     * @return true if equal, false otherwise
     */

    //with help from Claude
    //"I am failing all the tests for these 3 methods"
    //On February 12th

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City other = (City) obj;
        return this.city.equals(other.city)
                && this.province.equals(other.province);
    }
    /**
     * Returns a hash code based on the city name and province.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}