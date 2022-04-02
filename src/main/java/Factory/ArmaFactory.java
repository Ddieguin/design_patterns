package Factory;

import Repository.ArmaRepository;
import controller.ControllerArma;

public class ArmaFactory {

    private static ControllerArma instance;


    public static ControllerArma build() {
        if(ArmaFactory.instance == null) {
            ArmaRepository armaRepository = new ArmaRepository();
            ArmaFactory.instance = new ControllerArma(armaRepository);
            return ArmaFactory.instance;
        }
            return ArmaFactory.instance;
    }
}
