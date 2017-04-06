package models.appenders;

import abstractClasses.Layout;
import models.Message;
import models.ReportLevel;

/**
 * Created by Venelin on 4.4.2017 г..
 */
public class ConsoleAppender extends BaseAppender {


    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void appendMessage(Message message) {
        if (message.getReportLevel().ordinal() < super.getThreshold().ordinal()) {
            return;
        }
        System.out.println(super.getLayout().formatMessage(message));
        super.increaseMessagesAppended();
    }
}
