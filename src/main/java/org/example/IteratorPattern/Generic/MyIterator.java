package org.example.IteratorPattern.Generic;

interface MyIterator<T> {

    boolean hasNext();

    T next();
}