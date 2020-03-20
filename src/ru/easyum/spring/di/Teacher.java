package ru.easyum.spring.di;

public class Teacher {

    private Course course;
    private Student student;

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Учитель";
    }
}
