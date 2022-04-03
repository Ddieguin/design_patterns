package controller;

import Entity.Criminoso;
import Repository.IRepository;

import java.util.List;

public class ControllerCriminoso implements IController<Criminoso> {

    private final IRepository<Criminoso> criminosoRepository;

    public ControllerCriminoso(IRepository<Criminoso> crimonosoRepository) {
        this.criminosoRepository = crimonosoRepository;
    }

    @Override
    public Criminoso findByName(String name) {
        return criminosoRepository.findByName(name);
    }

    @Override
    public Criminoso index(int id) {
       return criminosoRepository.findById(id);
    }

    @Override
    public Criminoso save(Criminoso criminoso) {
       return criminosoRepository.save(criminoso);
    }

    @Override
    public List<Criminoso> find() {
        return criminosoRepository.findAll();
    }

    @Override
    public void delete(int id) {
        criminosoRepository.delete(id);
    }

    @Override
    public boolean update(int id, Criminoso criminoso) {
        return criminosoRepository.update(id, criminoso);
    }
}
