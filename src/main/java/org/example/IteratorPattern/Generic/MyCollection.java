package org.example.IteratorPattern.Generic;

import java.util.LinkedList;
import java.util.List;

class MyCollection<T> {

    private List<T> items;

    public MyCollection(List<T> items) {
        this.items = items;
    }

    public MyIterator<T> createIterator() {
        return new MyCollectionIterator<>(items);
    }
}