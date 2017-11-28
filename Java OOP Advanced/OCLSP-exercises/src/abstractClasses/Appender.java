package abstractClasses;

import models.Message;
import models.ReportLevel;

/**
 * Created by Venelin on 6.4.2017 г..
 */
public interface Appender {

    void appendMessage(Message message);

    void setReportLevel(ReportLevel reportLevel);

}
