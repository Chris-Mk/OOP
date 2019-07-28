package logger.appenders;

import logger.appenders.files.File;
import logger.layouts.Layout;

public class FileAppender extends Appender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = null;
    }

    @Override
    public void operate() {
        this.file.write(this.getLayout().print());
    }

    public final File getFile() {
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
