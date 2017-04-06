package models.appenders;

import abstractClasses.Appender;
import abstractClasses.Layout;
import models.Message;
import models.ReportLevel;

/**
 * Created by Venelin on 4.4.2017 г..
 */
public abstract class BaseAppender implements Appender {

    private Layout layout;
    private ReportLevel threshold;

    protected BaseAppender(Layout layout, ReportLevel... threshold) {
        this.layout = layout;
        this.setReportLevel(threshold);
    }

    @Override
    public void setReportLevel(ReportLevel... reportLevel) {
        if (reportLevel.length > 1) {
            throw new IllegalArgumentException("Report level threshold must be no more than 1 parameter long.");
        }
        if (reportLevel.length == 1) {
            this.threshold = reportLevel[0];
            return;
        }
        this.threshold = ReportLevel.INFO;
    }

    protected Layout getLayout() {
        return this.layout;
    }

    protected ReportLevel getThreshold() {
        return this.threshold;
    }
}
