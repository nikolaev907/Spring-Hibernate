package ru.easyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.easyum.domain.Course;
import ru.easyum.domain.Teacher;
import ru.easyum.repository.CourseRepository;
import ru.easyum.service.CourseService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CourseController {

    @Autowired
    CourseService service;
    @Autowired
    CourseRepository repository;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String allCourses(@RequestParam(defaultValue = "0") Integer pageNo,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             Model model) {
        Long total = repository.count();
        List<Course> courses = service.getPage(pageNo, pageSize);
        model.addAttribute("courses", courses);
        model.addAttribute("pages", new Integer[(int) Math.ceil((double) total / 5)]);
        return "courses";
    }

    @GetMapping(path = "/course/add")
    public String addCourse(Model model) {
        return "courseAdd";
    }

    @PostMapping(path = "/course/save")
    public String saveCourse(@RequestParam String name, @RequestParam int duration) {
        service.saveCourse(new Course(name, duration));
        return "redirect:/courses";
    }

    @RequestMapping(path = "/courses/{courseName}")
    public String getJavaTeachers(@PathVariable String courseName, Model model) {
        List<Teacher> teachers = service.getTeachersByCourseName(courseName);
        model.addAttribute("teachers", teachers);
        return "/jsp/teachers";
    }

    @RequestMapping("/course/get")
    public String findCourse(@RequestParam("courseId") int courseId, Model model) {
        Course course = service.findCourse(courseId);
        model.addAttribute("course", course);
        return "/jsp/course";
    }

    @GetMapping("/coursesAll")
    @ResponseBody
    public String allCourses() {
        return "Course list: " + service.findAllCourses().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "", ""));
    }

    @GetMapping("/setCookie")
    public String setCourseCookie(@CookieValue("JSESSIONID") String cookie,
                                  @RequestHeader("Accept-Encoding") String encoding) {
        System.out.println("Cookie MyCookie -> " + cookie);
        System.out.println("Header Accept-Enconding ->" + encoding);
        return "/jsp/index";
    }

    @GetMapping("/create")
    public String create() {
        return "/jsp/create";
    }

}
