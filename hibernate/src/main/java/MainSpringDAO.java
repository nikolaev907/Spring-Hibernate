import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.easyum.domain.Teacher;
import ru.easyum.service.CourseService;
import ru.easyum.service.TeacherService;

import java.util.List;

public class MainSpringDAO {

    public static void main(final String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        CourseService courseService = context.getBean(CourseService.class);
        System.out.println(courseService.findAllCourses());

        TeacherService teacherService = context.getBean(TeacherService.class);
        teacherService.saveTeacher(new Teacher("Яков Петрович", "Заслуженный учитель России", null));
        System.out.println(teacherService.findAllTeachers());

        List<Teacher> result = teacherService.findTeachersByFio("Яков Петрович");
        System.out.println(result);

        result = teacherService.findByAbout("учитель");
        System.out.println(result);
    }
}
