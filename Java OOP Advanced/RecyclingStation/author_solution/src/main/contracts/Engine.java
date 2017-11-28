package main.contracts;


import main.contracts.ui.Reader;
import main.contracts.ui.Writer;

public interface Engine extends Runnable {

    CommandHandler getCommandHandler();

    Reader getReader();

    Writer getWriter();
}
