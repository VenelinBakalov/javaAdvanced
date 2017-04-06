package models.appenders;

import abstractClasses.File;
import abstractClasses.Layout;
import models.Message;

/**
 * Created by Venelin on 4.4.2017 г..
 */
public class FileAppender extends BaseAppender {

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void appendMessage(Message message) {
        this.file.write(super.getLayout().formatMessage(message));
    }

    public void setFile(File file) {
        this.file = file;
    }
}
