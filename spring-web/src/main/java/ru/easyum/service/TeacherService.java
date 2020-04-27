package ru.easyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.easyum.domain.Teacher;
import ru.easyum.repository.TeacherRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public Teacher findTeacher(int id) {
        return repository.findById(id).get();
    }

    public List<Teacher> findAllTeachers() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void saveTeacher(Teacher teacher) {
        repository.save(teacher);
    }

    public List<Teacher> findTeachersByFio(String fio) {
        return repository.findByFio(fio);
    }

    public List<Teacher> findByAbout(String about) {
        return repository.findByAboutPartialMatch(about);
    }
}
