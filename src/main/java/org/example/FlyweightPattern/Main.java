package org.example.FlyweightPattern;

public class Main {

    public static void main(String[] args) {

        TreeType mangoType =
                TreeFactory.getTreeType(
                        "Mango",
                        "Green",
                        "mango.png"
                );
        TreeType type =
                TreeFactory.getTreeType(
                        "Mango",
                        "Green",
                        "mango.png"
                );
        System.out.println(mangoType == type);

        Tree tree1 = new Tree(10, 20, mangoType);
        Tree tree2 = new Tree(30, 40, mangoType);
        Tree tree3 = new Tree(50, 60, mangoType);

        tree1.draw();
        tree2.draw();
        tree3.draw();
    }
}