import core.EmergencyManagementSystem;
import core.ManagementSystem;
import engines.Engine;
import interpreters.CommandInterpreter;
import interpreters.Interpreter;
import io.ConsoleReader;
import io.ConsoleWriter;
import io.Reader;
import io.Writer;

/**
 * Created by Venelin on 19.4.2017 г..
 */
public class Main {
    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        ManagementSystem managementSystem = new EmergencyManagementSystem();
        Interpreter interpreter = new CommandInterpreter(managementSystem);

        Runnable engine = new Engine(reader, writer, interpreter);
        engine.run();
    }
}
