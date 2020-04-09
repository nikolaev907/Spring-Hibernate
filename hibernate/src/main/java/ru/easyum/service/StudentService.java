package ru.easyum.service;

import ru.easyum.dao.StudentDAO;
import ru.easyum.domain.Student;

import java.util.List;

public class StudentService {

    private StudentDAO dao = new StudentDAO();

    public Student findStudent(int id) {
        return dao.findById(id);
    }

    public List<Student> findAllStudents() {
        return dao.findAll();
    }

    public void saveStudent(Student student) {
        dao.save(student);
    }
}
