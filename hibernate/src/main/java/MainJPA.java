import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MainJPA {

    //TODO move factory code to singleton
    public static void main(final String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myPersistentDB");
        EntityManager entityManager = factory.createEntityManager();
        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            String sql = "SELECT about FROM teacher WHERE fio = :fio";
            List<Object> teachers = entityManager.createNativeQuery(sql)
                    .setParameter("fio", "Михаил Михайлов").getResultList();
            System.out.println(teachers);

            sql = "UPDATE teacher SET about = :about WHERE fio = :fio";
            entityManager.createNativeQuery(sql)
                    .setParameter("about", "Учитель со стажем > 20 лет")
                    .setParameter("fio", "Михаил Михайлов").executeUpdate();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            factory.close();
        }
    }
}
