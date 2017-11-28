package app.logger;

/**
 * Created by Venelin on 12.4.2017 г..
 */
public abstract class Logger implements Handler{

    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected void passToSuccessor(LogType type, String message) {
        if (this.successor != null) {
            this.successor.handle(type, message);
        }
    }
}
