package exer.pr0304Barracks.contracts;

import pr0304Barracks.contracts.*;

public interface CommandInterpreter {

	pr0304Barracks.contracts.Executable interpretCommand(String[] data, String commandName);
}
