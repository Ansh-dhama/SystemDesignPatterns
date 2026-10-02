package org.example.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

class TreeFactory {

    private static final Map<String, TreeType> treeTypes =
            new HashMap<>();

    public static TreeType getTreeType(
            String name,
            String color,
            String texture) {

        String key = name + "-" + color + "-" + texture;

        if (!treeTypes.containsKey(key)) {

            System.out.println("Creating new TreeType");

            treeTypes.put(
                    key,
                    new TreeType(name, color, texture)
            );
        }

        return treeTypes.get(key);
    }
}