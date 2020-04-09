package ru.easyum.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.easyum.HibernateSessionSingleton;
import ru.easyum.domain.Student;

import java.util.List;

public class StudentDAO {

    public Student findById(int id) {
        return HibernateSessionSingleton.getSessionFactory().openSession().get(Student.class, id);
    }

    public List<Student> findAll() {
        return (List<Student>) HibernateSessionSingleton.getSessionFactory().openSession().createQuery("FROM Student").list();
    }

    public void save(Student student) {
        Session session = HibernateSessionSingleton.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
    }

}
