import abstractClasses.Appender;
import abstractClasses.Layout;
import abstractClasses.Logger;
import models.*;
import models.appenders.ConsoleAppender;
import models.layouts.SimpleLayout;
import models.layouts.XmlLayout;

/**
 * Created by Venelin on 5.4.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);
        consoleAppender.setReportLevel(ReportLevel.ERROR);

        Logger logger = new MessageLogger(consoleAppender);

        logger.logInfo("3/31/2015 5:33:07 PM", "Everything seems fine");
        logger.logWarning("3/31/2015 5:33:07 PM", "Warning: ping is too high - disconnect imminent");
        logger.logError("3/31/2015 5:33:07 PM", "Error parsing request");
        logger.logCritical("3/31/2015 5:33:07 PM", "No connection string found in App.config");
        logger.logFatal("3/31/2015 5:33:07 PM", "mscorlib.dll does not respond");

    }
}
