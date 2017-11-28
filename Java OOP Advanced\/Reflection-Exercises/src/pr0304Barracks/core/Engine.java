package pr0304Barracks.core;

import pr0304Barracks.contracts.*;
import pr0304Barracks.contracts.Runnable;
import pr0304Barracks.core.commands.Command;
import pr0304Barracks.core.factories.CommandInterpreterImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;
	private CommandInterpreter commandInterpreter;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
		this.commandInterpreter = new CommandInterpreterImpl(this.repository, this.unitFactory);
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpredCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | IllegalAccessException | ClassNotFoundException | InstantiationException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpredCommand(String[] data, String commandName) throws IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException {
		Executable executable = this.commandInterpreter.interpretCommand(data, commandName);
		return executable.execute();
	}

}
