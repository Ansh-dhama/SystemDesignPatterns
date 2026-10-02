package org.example.IteratorPattern.Generic;

import java.util.List;

class MyCollectionIterator<T> implements MyIterator<T> {

    private List<T> items;
    private int position = 0;

    public MyCollectionIterator(List<T> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public T next() {
        return items.get(position++);
    }
}