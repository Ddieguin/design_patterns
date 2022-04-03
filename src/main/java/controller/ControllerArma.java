package controller;

import Entity.Arma;
import Repository.IRepository;

import java.util.List;

public class ControllerArma implements  IController<Arma> {

    private final IRepository<Arma> armaRepository;

    public ControllerArma(IRepository<Arma> armaRepository) {
        this.armaRepository = armaRepository;
    }

    @Override
    public Arma save(Arma arma) {
        return armaRepository.save(arma);
    }

    @Override
    public Arma findByName(String name) {
        return armaRepository.findByName(name);
    }

    @Override
    public Arma index(int id) {
        return armaRepository.findById(id);
    }

    @Override
    public List<Arma> find() {
        return armaRepository.findAll();
    }

    @Override
    public void delete(int id) {
        armaRepository.delete(id);
    }

    @Override
    public boolean update(int id, Arma arma) {
        return armaRepository.update(id, arma);
    }
}
