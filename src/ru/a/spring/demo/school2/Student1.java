package ru.a.spring.demo.school2;

public class Student1 {
    private String name;
    private String sName;
    private Course1 course;
    private Teacher1 teacher1;

    public Student1() {
    }

    public Student1(String name, String sName, Course1 course, Teacher1 teacher1) {
        this.name = name;
        this.sName = sName;
        this.course = course;
        this.teacher1 = teacher1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Course1 getCourse() {
        return course;
    }

    public void setCourse(Course1 course) {
        this.course = course;
    }

    public Teacher1 getTeacher1() {
        return teacher1;
    }

    public void setTeacher1(Teacher1 teacher1) {
        this.teacher1 = teacher1;
    }

    @Override
    public String toString() {
        return String.format("Student %s %s have course %s with teacher %s", name, sName, course.getName(), teacher1.getsNameT());

    }
}
