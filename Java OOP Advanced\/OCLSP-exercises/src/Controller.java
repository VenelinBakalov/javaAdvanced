import abstractClasses.Appender;
import abstractClasses.Layout;
import models.ReportLevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 6.4.2017 г..
 */
public class Controller {

    private static final String APPENDERS_FILE_PATH = "models.appenders.";
    private static final String LAYOUTS_FILE_PATH = "models.layouts.";

    public Appender readAppender(String[] input) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String layoutType = input[1];
        Class<Layout> layoutClass = (Class<Layout>) Class.forName(LAYOUTS_FILE_PATH + layoutType);
        Layout layout = layoutClass.newInstance();

        String appenderType = input[0];
        Class<Appender> appenderClass = (Class<Appender>) Class.forName(APPENDERS_FILE_PATH + appenderType);
        Constructor<Appender> appenderConstructor = appenderClass.getDeclaredConstructor(Layout.class);
        Appender appender = appenderConstructor.newInstance(layout);

        if (input.length > 2) {
            appender.setReportLevel(ReportLevel.valueOf(input[2]));
        }

        return appender;
    }
}
