import Entity.*;
import Repository.ArmaRepository;
import Repository.CriminosoRepository;
import Repository.VitimaRepository;


public class Main {
    public static void main(String[] args)  {


        CriminosoRepository criminosoRepository = new CriminosoRepository();
        VitimaRepository vitimaRepository = new VitimaRepository();
        ArmaRepository armaRepository = new ArmaRepository();

        Vitima vitima = new Vitima.Builder().setNome("Karina Da Silva").build();
        Criminoso criminoso = new Criminoso.Builder().setNome("Joao Da Silva Vieira").build();
        Arma arma = new Arma.Builder().setNome("faca").setClasse("Arma Branca").build();

        Vitima vitima1 = vitimaRepository.save(vitima);
        Arma arma1 = armaRepository.save(arma);
        Criminoso criminoso1 = criminosoRepository.save(criminoso);

        System.out.println(vitimaRepository.findById(vitima1.getId()));
        System.out.println(armaRepository.findById(arma1.getId()));
        System.out.println(criminosoRepository.findById(criminoso1.getId()));
    }
}
