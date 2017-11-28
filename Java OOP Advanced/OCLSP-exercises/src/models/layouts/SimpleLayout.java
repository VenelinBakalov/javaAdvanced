package models.layouts;

import abstractClasses.Layout;
import models.Message;

/**
 * Created by Venelin on 4.4.2017 г..
 */
public class SimpleLayout implements Layout {
    @Override
    public String formatMessage(Message message) {
        return String.format("%s - %s - %s", message.getDate(), message.getReportLevel().name(), message.getText());
    }
}
