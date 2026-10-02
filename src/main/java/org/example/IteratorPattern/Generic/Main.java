package org.example.IteratorPattern.Generic;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> names = new LinkedList<>();

        names.add("Aman");
        names.add("Deepak");
        names.add("Rahul");

        MyCollection<String> collection =
                new MyCollection<>(names);
        MyIterator< String> iterator =
                collection.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}