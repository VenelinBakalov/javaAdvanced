package contracts;

import enumeration.EngineType;
import exeptions.DuplicateModelException;

/**
 * Created by Venelin on 16.4.2017 г..
 */
public interface EngineCreator {

    String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException;
}
