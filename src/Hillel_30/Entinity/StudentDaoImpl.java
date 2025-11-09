package Hillel_30.Entinity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class StudentDaoImpl implements GenericDao<Student, Long> {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hillel-persistence-unit");
    private EntityManager em;

    public StudentDaoImpl() {
        this.em = emf.createEntityManager();
    }

    @Override
    public void save(Student student) {
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public Student findByEmail(String email) {
        TypedQuery<Student> query = em.createQuery(
                "SELECT s FROM Student s WHERE s.email = :email", Student.class);
        query.setParameter("email", email);
        List<Student> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public Student update(Student student) {
        try {
            em.getTransaction().begin();
            Student updated = em.merge(student);
            em.getTransaction().commit();
            return updated;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            em.getTransaction().begin();
            Student student = em.find(Student.class, id);
            if (student != null) {
                em.remove(student);
                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().rollback();
                return false;
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    // Закриття EntityManager
    public void close() {
        if (em.isOpen()) {
            em.close();
        }
    }
}
