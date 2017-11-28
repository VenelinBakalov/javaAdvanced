package app.logger;

/**
 * Created by Venelin on 12.4.2017 г..
 */
public interface Handler {

    void handle(LogType type, String message);

    void setSuccessor(Handler successor);
}
