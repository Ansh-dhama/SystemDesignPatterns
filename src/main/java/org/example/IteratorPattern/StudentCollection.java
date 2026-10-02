package org.example.IteratorPattern;

class StudentCollection {

    private Student[] students;

    public StudentCollection() {

        students = new Student[] {
                new Student("Aman"),
                new Student("Deepak"),
                new Student("Rahul"),
                new Student("Rohit")
        };
    }

    public MyIterator<Student> createIterator() {
        return new StudentIterator(students);
    }
}