package org.example.IteratorPattern;

class StudentIterator implements MyIterator<Student> {

    private Student[] students;

    private int position = 0;

    public StudentIterator(Student[] students) {
        this.students = students;
    }

    @Override
    public boolean hasNext() {

        return position < students.length;
    }

    @Override
    public Student next() {

        return students[position++];
    }
}