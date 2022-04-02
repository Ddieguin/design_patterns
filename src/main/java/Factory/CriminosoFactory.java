package Factory;

import Entity.Criminoso;
import Repository.CriminosoRepository;
import controller.ControllerCriminoso;

public class CriminosoFactory {
    private static ControllerCriminoso instance;

    public static ControllerCriminoso build() {
        if(CriminosoFactory.instance == null) {
            CriminosoRepository criminosoRepository = new CriminosoRepository();
            CriminosoFactory.instance = new ControllerCriminoso(criminosoRepository);
        }
        return CriminosoFactory.instance;
    }
}
