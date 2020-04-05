package ru.easyum.spring.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.easyum.spring.di.Course;

@Component
public class SchoolService {

    @Bean(name = "java")
//    @Qualifier("java")
    public Course getJavaCourse() {
        return new Course("Spring+hibernate", 32);
    }

    @Bean (name = "python")
 //   @Qualifier("python")
    public Course getPythonCourse() {
        return new Course("python+web", 124);
    }

}
