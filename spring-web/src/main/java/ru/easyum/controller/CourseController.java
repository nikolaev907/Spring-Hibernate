package ru.easyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.easyum.domain.Course;
import ru.easyum.domain.Teacher;
import ru.easyum.service.CourseService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CourseController {

    @Autowired
    CourseService service;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String allCourses(Model model) {
        List<Course> courses = service.findAllCourses();
        model.addAttribute("courses", courses);
        return "/jsp/courses";
    }

    @RequestMapping(path = "/courses/{courseName}")
    public String getJavaTeachers(@PathVariable String courseName, Model model) {
        List<Teacher> teachers = service.getTeachersByCourseName(courseName);
        model.addAttribute("teachers", teachers);
        return "/jsp/teachers";
    }

    @RequestMapping(path = "/course/add", method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course) {
        service.saveCourse(course);
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

    @PostMapping("/course/save")
    public String save(@RequestParam String name, @RequestParam int duration) {
        Course course = service.saveCourse(new Course(name, duration));
        return "redirect:/course/get?courseId=" + course.getId();
    }

}
