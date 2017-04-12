package app.logger;

/**
 * Created by Venelin on 12.4.2017 г..
 */
public class EventLogger extends Logger {

    private Handler successor;

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.EVENT) {
            System.out.println(type.name() + ": " + message);
        } else {
            super.passToSuccessor(type, message);
        }
    }

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
