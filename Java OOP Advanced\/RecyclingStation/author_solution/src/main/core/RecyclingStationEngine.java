package main.core;


import main.contracts.CommandHandler;
import main.contracts.Engine;
import main.contracts.ui.Reader;
import main.contracts.ui.Writer;
import main.ui.ConsoleReader;
import main.ui.ConsoleWriter;

import java.lang.reflect.Method;

public class RecyclingStationEngine implements Engine {
    private CommandHandler commandHandler;
    private Reader reader;
    private Writer writer;

    public RecyclingStationEngine(CommandHandler commandHandler, Reader reader, Writer writer){
        this.setCommandHandler(commandHandler);
        this.setReader(reader);
        this.setWriter(writer);
    }

    public RecyclingStationEngine()
    {
        this(new RecyclingStationCommandHandler(),new ConsoleReader(),new ConsoleWriter());
    }

    private void setCommandHandler(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    private void setReader(Reader reader) {
        this.reader = reader;
    }

    private void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override

    public CommandHandler getCommandHandler() {
        return this.commandHandler;
    }

    @Override
    public Reader getReader() {
        return this.reader;
    }

    @Override
    public Writer getWriter() {
        return this.writer;
    }

    @Override
    public void run() {
        String line = this.getReader().readLine();
        while (!line.equals("TimeToRecycle"))
        {
            String[] tokens = line.split(" ");
            String methodName = tokens[0];
            Object[] invokeParams = new Object[0];
            if (tokens.length > 1)
            {
                invokeParams = new Object[1];
                invokeParams[0] = tokens[1].split("\\|");
            }

            try
            {
                Method methodToCall = null;
                Method[] methods = this.getCommandHandler().getClass().getMethods();
                for (Method method : methods) {
                    if(method.getName().equals(methodName)){
                        methodToCall = method;
                        break;
                    }
                }
                this.getWriter().writeLine((String)methodToCall.invoke(this.getCommandHandler(), invokeParams));
            }
            catch (Exception ex)
            {
                this.getWriter().writeLine("The passed in command is invalid!");
                this.getWriter().writeLine(ex.getMessage());
            }

            line = this.getReader().readLine();
        }
    }
}
