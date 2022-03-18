package Repository;

import Entity.Arma;
import Entity.Criminoso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class ArmaRepository implements IRepository<Arma>{
    EntityManagerFactory emf;
    EntityManager em;

    //refactoring to Factory Injection Dependence
    public ArmaRepository() {
        emf = Persistence.createEntityManagerFactory("app");
        em = emf.createEntityManager();
    }

    public Arma save(Arma arma) {
        em.getTransaction().begin();
        em.persist(arma);
        em.getTransaction().commit();
        return arma;
    }

    public Arma findById(int id) {
        return em.find(Arma.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Arma> findAll() {
        em.getTransaction().begin();
        Query query = em.createQuery("select criminoso CRIMINOSO criminoso");
        List<Arma> armas = query.getResultList();
        em.getTransaction().commit();
        return armas;
    }

    public void delete(int id) {
        em.getTransaction().begin();
        Arma arma = em.find(Arma.class, id);
        em.remove(arma);
        em.getTransaction().commit();
    }

    public boolean update(int id, Arma arma) {
        try{
            em.getTransaction().begin();
            em.find(Arma.class, id);
            em.merge(arma);
            em.getTransaction().commit();
        }catch (Exception err) {
            return false;
        }

        return true;
    }
}
