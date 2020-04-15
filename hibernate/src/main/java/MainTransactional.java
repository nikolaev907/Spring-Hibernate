import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.easyum.domain.Course;
import ru.easyum.domain.Student;
import ru.easyum.domain.Teacher;
import ru.easyum.service.ModuleService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainTransactional {

    public static void main(final String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ModuleService moduleService = context.getBean(ModuleService.class);

        Course junior = new Course("Java junior", 64);
        List<Course> courses = new ArrayList();
        courses.add(junior);

        Student student = new Student("John", new Date(123456), 1000L, courses);
        junior.setStudent(student);
        List<Student> students = new ArrayList<>();
        students.add(student);

        Teacher teacher = new Teacher("1", "1", courses);

        moduleService.createModule(teacher, junior, students);
    }
}
