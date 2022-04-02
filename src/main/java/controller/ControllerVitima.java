package controller;

import Entity.Vitima;
import Repository.IRepository;

import java.util.List;

public class ControllerVitima implements IController<Vitima> {
    private final IRepository<Vitima> vitimaRepository;

    public ControllerVitima(IRepository<Vitima> vitimaRepository) {
        this.vitimaRepository = vitimaRepository;
    }

    @Override
    public void delete(int id) {
        vitimaRepository.delete(id);
    }

    @Override
    public Vitima index(int id) {
        return vitimaRepository.findById(id);
    }

    @Override
    public Vitima save(Vitima vitima) {
        return vitimaRepository.save(vitima);
    }

    @Override
    public boolean update(int id, Vitima vitima) {
        return vitimaRepository.update(id, vitima);
    }

    @Override
    public List<Vitima> find() {
        return vitimaRepository.findAll();
    }
}
