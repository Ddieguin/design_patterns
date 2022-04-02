package controller;

import Entity.Crime;
import Repository.IRepository;

import java.util.List;

public class ControllerCrime implements IController<Crime> {

    private final IRepository<Crime> crimeRepository;

    public ControllerCrime(IRepository<Crime> crimeIRepository) {
        this.crimeRepository = crimeIRepository;
    }

    @Override
    public boolean update(int id, Crime crime) {
        return crimeRepository.update(id, crime);
    }

    @Override
    public void delete(int id) {
        crimeRepository.delete(id);
    }

    @Override
    public Crime index(int id) {
        return crimeRepository.findById(id);
    }

    @Override
    public List<Crime> find() {
        return crimeRepository.findAll();
    }

    @Override
    public Crime save(Crime crime) {
       return  crimeRepository.save(crime);
    }
}
