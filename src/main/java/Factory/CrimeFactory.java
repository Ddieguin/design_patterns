package Factory;

import Repository.CrimeRepository;
import controller.ControllerCrime;

public class CrimeFactory {
    private static ControllerCrime instance;

    public static ControllerCrime build() {
        if(CrimeFactory.instance == null) {
            CrimeRepository crimeRepository = new CrimeRepository();
            CrimeFactory.instance = new ControllerCrime(crimeRepository);
            return CrimeFactory.instance;
        }
        return CrimeFactory.instance;
    }
}
