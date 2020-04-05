package ru.a.spring.demo.school2;

public class Teacher1 {
    private String nameT;
    private String sNameT;
    private Course1 course1;

    public Teacher1(String nameT, String sNameT, Course1 course1) {
        this.nameT = nameT;
        this.sNameT = sNameT;
        this.course1 = course1;
    }

    public String getNameT() {
        return nameT;
    }

    public void setNameT(String nameT) {
        this.nameT = nameT;
    }

    public String getsNameT() {
        return sNameT;
    }

    public void setsNameT(String sNameT) {
        this.sNameT = sNameT;
    }

    public Course1 getCourse1() {
        return course1;
    }

    public void setCourse1(Course1 course1) {
        this.course1 = course1;
    }


    @Override
    public String toString() {
        return String.format("Teacher %s %s is giving a course %s", nameT, sNameT, course1.getName());

    }
}
