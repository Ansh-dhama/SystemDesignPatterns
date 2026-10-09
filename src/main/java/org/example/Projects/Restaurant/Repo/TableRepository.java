package org.example.Projects.Restaurant.Repo;

import org.example.Projects.Restaurant.model.Table;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class TableRepository {
    private final Map<Integer, Table> tableStore = new ConcurrentHashMap<>();

    public Table save(Table table) {
        tableStore.put(table.getTableNumber(), table);
        return table;
    }

    public Optional<Table> findByNumber(int tableNumber) {
        return Optional.ofNullable(tableStore.get(tableNumber));
    }
}