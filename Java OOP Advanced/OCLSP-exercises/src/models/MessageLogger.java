package models;

import abstractClasses.Appender;
import models.appenders.BaseAppender;
import abstractClasses.Logger;


import java.util.Arrays;
import java.util.List;

/**
 * Created by Venelin on 4.4.2017 г..
 */
public class MessageLogger implements Logger {

    private List<Appender> appenders;

    public MessageLogger(Appender... appenders) {
        this.setAppenders(appenders);
    }

    @Override
    public void logInfo(String date, String text) {
        Message message = new Message(date, text, ReportLevel.INFO);
        for (Appender appender : this.appenders) {
            appender.appendMessage(message);
        }
    }

    @Override
    public void logWarning(String date, String text) {
        Message message = new Message(date, text, ReportLevel.WARNING);
        for (Appender appender : this.appenders) {
            appender.appendMessage(message);
        }
    }

    @Override
    public void logError(String date, String text) {
        Message message = new Message(date, text, ReportLevel.ERROR);
        for (Appender appender : this.appenders) {
            appender.appendMessage(message);
        }
    }

    @Override
    public void logFatal(String date, String text) {
        Message message = new Message(date, text, ReportLevel.FATAL);
        for (Appender appender : appenders) {
            appender.appendMessage(message);
        }
    }

    @Override
    public void logCritical(String date, String text) {
        Message message = new Message(date, text, ReportLevel.CRITICAL);
        for (Appender appender : appenders) {
            appender.appendMessage(message);
        }
    }

    private void setAppenders(Appender[] appenders) {
        if (appenders.length <= 0) {
            throw new IllegalArgumentException("MessageLogger must have at least 1 appender!");
        }
        this.appenders = Arrays.asList(appenders);
    }
}
