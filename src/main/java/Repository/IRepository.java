package Repository;

import java.util.List;

public interface IRepository<T> {
    public T save(T object);
    public T findById(int id);
    public List<T> findAll();
    public void delete(int id);
    public boolean update(int id, T object);
    public T findByName(String nome);
}