import abstractClasses.Appender;
import abstractClasses.Layout;
import abstractClasses.Logger;
import models.*;
import models.appenders.ConsoleAppender;
import models.layouts.SimpleLayout;
import models.layouts.XmlLayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 5.4.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Controller controller = new Controller();
        List<Appender> appenders = new ArrayList<>();

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            Appender appender = controller.readAppender(reader.readLine().split(" "));
            appenders.add(appender);
        }

        Logger logger = new MessageLogger(appenders.toArray(new Appender[appenders.size()]));

        String command;

        while (!"END".equals(command = reader.readLine())) {
            String[] commandArgs = command.split("\\|");
            ReportLevel reportLevel = ReportLevel.valueOf(commandArgs[0]);
            String date = commandArgs[1];
            String text = commandArgs[2];
            String methodName = "";
            switch (reportLevel) {
                case INFO: methodName = "logInfo"; break;
                case WARNING: methodName = "logWarning"; break;
                case ERROR: methodName = "logError"; break;
                case CRITICAL: methodName = "logCritical"; break;
                case FATAL: methodName = "logFatal"; break;
            }

            Method method = Logger.class.getDeclaredMethod(methodName, String.class, String.class);
            method.invoke(logger, date, text);
        }

        System.out.println(logger);
    }
}
