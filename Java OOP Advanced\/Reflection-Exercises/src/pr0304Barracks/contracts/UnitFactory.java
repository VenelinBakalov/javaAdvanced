package pr0304Barracks.contracts;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ClassNotFoundException, IllegalAccessException, InstantiationException;
}