package ru.easyum.spring.component;

import org.springframework.stereotype.Repository;
import ru.easyum.spring.di.Course;
import ru.easyum.spring.di.Teacher;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {

    @Override
    public Teacher getTeacher() {
        Teacher teacher = new Teacher();
        teacher.setCourse(new Course("html+css+js", 56));
        return teacher;
    }
}
