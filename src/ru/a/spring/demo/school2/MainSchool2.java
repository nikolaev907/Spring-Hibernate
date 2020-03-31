package ru.a.spring.demo.school2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSchool2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ru/a/spring/demo/spring-config-a-school2.xml");
        Course1 course1 = context.getBean("course1", Course1.class);
        System.out.println(course1);

        Student1 student1 = context.getBean("student1", Student1.class);
        System.out.println(student1);

        Teacher1 teacher1 = context.getBean("teacher1", Teacher1.class);
        System.out.println(teacher1);
    }
}
