package app.logger;

/**
 * Created by Venelin on 12.4.2017 г..
 */
public class ErrorLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ERROR) {
            System.out.println(type.name() + ": " + message);
        } else {
            super.passToSuccessor(type, message);
        }
    }
}
