package org.example.Projects.Restaurant.model;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    private final String name;
    private final Map<Integer, Table> tables = new HashMap<>();

    public Restaurant(String name, int totalTables) {
        this.name = name;
        for (int i = 1; i <= totalTables; i++) {
            tables.put(i, new Table(i));
        }
    }

    public Table getTable(int tableNumber) {
        Table table = tables.get(tableNumber);
        if (table == null) throw new IllegalArgumentException("Invalid table number");
        return table;
    }
}