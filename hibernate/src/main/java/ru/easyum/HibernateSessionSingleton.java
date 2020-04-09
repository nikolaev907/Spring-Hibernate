package ru.easyum;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.easyum.domain.Course;
import ru.easyum.domain.Student;

public class HibernateSessionSingleton {

    private static SessionFactory sessionFactory;

    private HibernateSessionSingleton() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Course.class);
                configuration.configure();
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                System.out.println("Ошибка инициализации hibernate конфигурации!");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
