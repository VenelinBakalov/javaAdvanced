package workForce;

import workForce.commands.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        JobRepository jobRepository = new JobRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Executor commandExecutor = new CommandExecutor();

        while (!"End".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" ");
            String commandType = commandArgs[0];

            switch (commandType) {
                case "Job":
                    commandExecutor.executeCommand(new CreateJobCommand(commandArgs, jobRepository, employeeRepository));
                    break;
                case "StandartEmployee":
                    commandExecutor.executeCommand(new CreateStandartEmployeeCommand(commandArgs, employeeRepository));
                    break;
                case "PartTimeEmployee":
                    commandExecutor.executeCommand(new CreatePartTimeEmployeeCommand(commandArgs, employeeRepository));
                    break;
                case "Pass":
                    commandExecutor.executeCommand(new PassWeekCommand(commandArgs, jobRepository));
                    break;
                case "Status":
                    commandExecutor.executeCommand(new StatusCommand(commandArgs, jobRepository));
                    break;

            }
        }
    }
}
