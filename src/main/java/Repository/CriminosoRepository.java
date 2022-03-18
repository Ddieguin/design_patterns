package Repository;

import javax.persistence.*;
import Entity.Criminoso;
import java.util.List;

public class CriminosoRepository implements IRepository<Criminoso> {

    EntityManagerFactory emf;
    EntityManager em;

    //refactoring to Factory Injection Dependence
    public CriminosoRepository() {
        emf = Persistence.createEntityManagerFactory("app");
        em = emf.createEntityManager();
    }

    public Criminoso save(Criminoso criminoso) {
        em.getTransaction().begin();
        em.persist(criminoso);
        em.getTransaction().commit();
        return criminoso;
    }

    public Criminoso findById(int id) {
        return em.find(Criminoso.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Criminoso> findAll() {
        em.getTransaction().begin();
        Query query = em.createQuery("select criminoso CRIMINOSO criminoso");
        List<Criminoso> criminosos = query.getResultList();
        em.getTransaction().commit();
        return criminosos;
    }

    public void delete(int id) {
        em.getTransaction().begin();
        Criminoso criminoso = em.find(Criminoso.class, id);
        em.remove(criminoso);
        em.getTransaction().commit();
    }

    public boolean update(int id, Criminoso criminoso) {
        try{
            em.getTransaction().begin();
            em.find(Criminoso.class, id);
            em.merge(criminoso);
            em.getTransaction().commit();
        }catch (Exception err) {
            return false;
        }

        return true;
    }
}
