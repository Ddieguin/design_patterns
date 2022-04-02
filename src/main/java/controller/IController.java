package controller;

import java.util.List;

public interface IController<T> {
    public T save(T object);
    public T index(int id);
    public List<T> find();
    public void delete(int id);
    public boolean update(int id, T object);
}
