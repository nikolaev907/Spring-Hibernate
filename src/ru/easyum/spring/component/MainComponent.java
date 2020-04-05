package ru.easyum.spring.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.easyum.spring.di.Course;

public class MainComponent {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config-component.xml");
        CourseService courseService = context.getBean(CourseService.class);
        System.out.println(courseService.getActiveTeacher());

        SchoolService schoolService = context.getBean(SchoolService.class);
        System.out.println(schoolService.getJavaCourse());
        System.out.println(schoolService.getPythonCourse());

        Course course1 = context.getBean("java", Course.class);
        System.out.println(course1);
        Course course2 = context.getBean("python", Course.class);
        System.out.println(course2);
    }
}
