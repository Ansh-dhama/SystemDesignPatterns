package org.example.IteratorPattern;

public class main {
    public static void main(String[] args) {
        StudentCollection studentCollection = new StudentCollection();

        MyIterator<Student> iterator = studentCollection.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
