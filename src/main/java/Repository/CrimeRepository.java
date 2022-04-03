package Repository;

import Entity.Arma;
import Entity.Crime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CrimeRepository implements IRepository<Crime> {

    EntityManagerFactory emf;
    EntityManager em;


    public CrimeRepository() {
        emf = Persistence.createEntityManagerFactory("app");
        em = emf.createEntityManager();
    }

    public Crime save(Crime crime) {
        em.getTransaction().begin();
        em.persist(crime);
        em.getTransaction().commit();
        return crime;
    }

    public Crime findById(int id) {
        return em.find(Crime.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Crime> findAll() {
        em.getTransaction().begin();
        Query query = em.createQuery("select crime Crime crime");
        List<Crime> crimes = query.getResultList();
        em.getTransaction().commit();
        return crimes;
    }

    public Crime findByName(String localCrime) {
        return findAll().get(0);
    }

    public void delete(int id) {
        em.getTransaction().begin();
        Crime crime = em.find(Crime.class, id);
        em.remove(crime);
        em.getTransaction().commit();
    }

    public boolean update(int id, Crime crime) {
        try{
            em.getTransaction().begin();
            em.find(Crime.class, id);
            em.merge(crime);
            em.getTransaction().commit();
        }catch (Exception err) {
            return false;
        }

        return true;
    }

}
