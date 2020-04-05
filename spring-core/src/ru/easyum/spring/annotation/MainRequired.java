package ru.easyum.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.easyum.spring.di.Course;
import ru.easyum.spring.di.Student;
import ru.easyum.spring.di.Teacher;

public class MainRequired {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/annotation/spring-config-annotation.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);

        Teacher teacher = context.getBean("teacher", Teacher.class);
        System.out.println(teacher);

        Course java = (Course) context.getBean("course-java");
        System.out.println(java + " " + Course.cache);
        Course python = (Course) context.getBean("course-python");
        System.out.println(python + " " + Course.cache);
    }
}
