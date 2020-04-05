package ru.a.spring.demo.school2;

public class Course1 {
    private String name;
    private int duration;

    public Course1(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("Course name %s with duration %s months", name, duration);
    }
}
