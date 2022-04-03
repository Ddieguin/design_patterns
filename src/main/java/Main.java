import Entity.Arma;
import Entity.Crime;
import Entity.Criminoso;
import Entity.Vitima;
import Factory.ArmaFactory;
import Repository.ArmaRepository;
import Repository.CrimeRepository;
import Repository.CriminosoRepository;
import Repository.VitimaRepository;
import Visual.InterfaceGrafica;


public class Main {

    public static void main(String[] args)  {
        // init the window
//        InterfaceGrafica controladorInterface = new InterfaceGrafica();

        CriminosoRepository criminosoRepository = new CriminosoRepository();
        VitimaRepository vitimaRepository = new VitimaRepository();
        ArmaRepository armaRepository = new ArmaRepository();
        CrimeRepository crimeRepository = new CrimeRepository();

        Vitima vitima = new Vitima.Builder().setNome("Karina Da Silva").build();
        Criminoso criminoso = new Criminoso.Builder().setNome("Joao Da Silva Vieira").build();
        Arma arma = new Arma.Builder().setNome("faca").setClasse("Arma Branca").build();
        Arma arma2 = new Arma.Builder().setNome("canivete").setClasse("Arma Branca").build();

        Vitima vitima1 = vitimaRepository.save(vitima);
        Arma arma1 = armaRepository.save(arma);
        armaRepository.save(arma2);
        Criminoso criminoso1 = criminosoRepository.save(criminoso);

        Crime crime = new Crime.Builder().setCriminoso(criminoso1).setArma(arma1).setVitima(vitima1).build();
        crimeRepository.save(crime);

        System.out.println(vitimaRepository.findById(vitima1.getId()));

//        for(Arma arm: ArmaFactory.build().find()) {
//            System.out.println(arm.toString());
//        };



        System.out.println(crimeRepository.findById(crime.getId()));
        System.out.println(criminoso1.getCrimes().size());
    }


}
