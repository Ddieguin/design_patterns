package Factory;


import Repository.VitimaRepository;
import controller.ControllerVitima;

public class VitimaFactory {
    private static ControllerVitima instance;

    public ControllerVitima build() {
        if(VitimaFactory.instance == null) {
            VitimaRepository vitimaRepository = new VitimaRepository();
            VitimaFactory.instance = new ControllerVitima(vitimaRepository);
            return VitimaFactory.instance;
        }
        return VitimaFactory.instance;
    }
}
