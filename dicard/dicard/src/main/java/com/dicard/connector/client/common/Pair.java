package com.dicard.connector.client.common;

/**
 * Simple name/value pair used for query parameters.
 */
public class Pair {

    private final String name;
    private final Object value;

    public Pair(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

