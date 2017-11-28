package abstractClasses;

/**
 * Created by Venelin on 5.4.2017 г..
 */
public interface Logger {

    void logInfo(String date, String text);

    void logWarning(String date, String text);

    void logError(String date, String text);

    void logFatal(String date, String text);

    void logCritical(String date, String text);
}
