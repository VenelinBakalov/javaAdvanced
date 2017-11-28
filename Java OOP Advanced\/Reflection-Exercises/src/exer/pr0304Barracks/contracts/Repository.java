package exer.pr0304Barracks.contracts;

import pr0304Barracks.contracts.*;

public interface Repository {

	void addUnit(pr0304Barracks.contracts.Unit unit);

	String getStatistics();

	void removeUnit(String unitType);
}
