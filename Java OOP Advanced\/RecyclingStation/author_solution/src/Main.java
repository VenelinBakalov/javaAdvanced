import main.contracts.*;
import main.core.RecyclingStationEngine;

public class Main {
    public static void main(String[] args){
        Engine engine = new RecyclingStationEngine();
        engine.run();
    }
}
