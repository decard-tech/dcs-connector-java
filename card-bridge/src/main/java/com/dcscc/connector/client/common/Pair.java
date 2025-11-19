/*
 * dcs Java Connector
 * Pair utility class for key-value pairs
 *
 * The version of the dcs API: 1.0.0
 */

package com.dcscc.connector.client.common;

import java.util.Objects;

/**
 * A simple utility class to represent key-value pairs.
 * 
 * <p>This class is used internally by the dcs connector to represent
 * HTTP parameters, headers, and other key-value data structures.
 * @author DCS Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class Pair {

    /** The key/name of the pair */
    private String name;
    
    /** The value of the pair */
    private String value;

    /**
     * Default constructor.
     */
    public Pair() {
    }

    /**
     * Constructs a new Pair with the specified name and value.
     *
     * @param name the name/key of the pair
     * @param value the value of the pair
     */
    public Pair(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Gets the name/key of the pair.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name/key of the pair.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of the pair.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the pair.
     *
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(name, pair.name) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
