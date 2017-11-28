package models;

/**
 * Created by Venelin on 5.4.2017 г..
 */
public class Message {

    private String date;
    private String text;
    private ReportLevel reportLevel;

    public Message(String date, String text, ReportLevel reportLevel) {
        this.date = date;
        this.text = text;
        this.reportLevel = reportLevel;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public ReportLevel getReportLevel() {
        return reportLevel;
    }
}
