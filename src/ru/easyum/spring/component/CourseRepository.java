package ru.easyum.spring.component;

import ru.easyum.spring.di.Course;

import java.util.List;

public interface CourseRepository {

    public List<Course> findAllCourses();
}
