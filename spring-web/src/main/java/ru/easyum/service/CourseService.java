package ru.easyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.easyum.domain.Course;
import ru.easyum.domain.Teacher;
import ru.easyum.repository.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public Course findCourse(int id) {
        return repository.findById(id).get();
    }

    public List<Course> findAllCourses() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    public List<Teacher> getTeachersByCourseName(String courseName) {
        List<Course> courses = repository.findByName(courseName);
        return courses.stream().map((c) -> c.getTeacher()).collect(Collectors.toList());
    }
}
