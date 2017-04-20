package app.waste_disposal.engines;

import app.waste_disposal.commands.Executable;
import app.waste_disposal.contracts.*;
import app.waste_disposal.io.Reader;
import app.waste_disposal.io.Writer;

import java.io.IOException;

/**
 * Created by Venelin on 20.4.2017 г..
 */
public class Engine implements Runnable {

    private Reader reader;
    private Writer writer;
    private Interpreter interpreter;

    public Engine(Reader reader, Writer writer, Interpreter interpreter) {
        this.reader = reader;
        this.writer = writer;
        this.interpreter = interpreter;
    }

    @Override
    public void run() {
        try {
            String command = this.reader.read();
            while (true) {
                if ("TimeToRecycle".equals(command)) break;

                Executable executable = this.interpreter.interpretCommand(command);
                String result = executable.execute();

                this.writer.write(result);

                command = this.reader.read();
            }
        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
