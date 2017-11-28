package models.layouts;

import abstractClasses.Layout;
import models.Message;

/**
 * Created by Venelin on 6.4.2017 г..
 */
public class XmlLayout implements Layout {
    @Override
    public String formatMessage(Message message) {
        return String.format("<log>%n   <date>%s</date>%n   <level>%s</level>%n   <message>%s</message>%n</log>",
                message.getDate(), message.getReportLevel(), message.getText());
    }
}
