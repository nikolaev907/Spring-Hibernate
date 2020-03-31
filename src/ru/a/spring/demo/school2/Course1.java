package ru.a.spring.demo.school2;

public class Course1 {
    private String name;
    private String duration;

    public Course1() {
    }

    public Course1(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("Course name %s with duration %s", name, duration);
    }
}
