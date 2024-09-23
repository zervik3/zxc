import javax.persistence.*;
import java.util.List;

public class PersonDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonPU");


    public void addPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }


    public void updatePerson(Long id, String name, int age) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if (person != null) {
            person.setName(name);
            person.setAge(age);
            em.merge(person);
        }
        em.getTransaction().commit();
        em.close();
    }


    public void deletePerson(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if (person != null) {
            em.remove(person);
        }
        em.getTransaction().commit();
        em.close();
    }


    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = em.createQuery("FROM Person", Person.class).getResultList();
        em.close();
        return persons;
    }


    public void close() {
        emf.close();
    }
}
