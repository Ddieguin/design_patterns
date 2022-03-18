package Repository;

import Entity.Criminoso;
import Entity.Vitima;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class VitimaRepository {
    EntityManagerFactory emf;
    EntityManager em;

    //refactoring to Factory Injection Dependence
    public VitimaRepository() {
        emf = Persistence.createEntityManagerFactory("app");
        em = emf.createEntityManager();
    }

    public Vitima save(Vitima vitima) {
        em.getTransaction().begin();
        em.persist(vitima);
        em.getTransaction().commit();
        return vitima;
    }

    public Vitima findById(int id) {
        return em.find(Vitima.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Vitima> findAll() {
        em.getTransaction().begin();
        Query query = em.createQuery("select criminoso CRIMINOSO criminoso");
        List<Vitima> vitimas = query.getResultList();
        em.getTransaction().commit();
        return vitimas;
    }

    public void delete(int id) {
        em.getTransaction().begin();
        Vitima vitima = em.find(Vitima.class, id);
        em.remove(vitima);
        em.getTransaction().commit();
    }

    public boolean update(int id, Vitima vitima) {
        try{
            em.getTransaction().begin();
            em.find(Vitima.class, id);
            em.merge(vitima);
            em.getTransaction().commit();
        }catch (Exception err) {
            return false;
        }

        return true;
    }
}
