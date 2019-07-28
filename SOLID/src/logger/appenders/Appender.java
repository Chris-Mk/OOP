package logger.appenders;

import logger.layouts.Layout;

public abstract class Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesAppended;

    Appender(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
    }

    public int getMessagesAppended() {
        return this.messagesAppended;
    }

    private void setMessagesAppended(int messagesAppended) {
        this.messagesAppended = messagesAppended;
    }

    public Layout getLayout() {
        return this.layout;
    }

    public final ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public final void append(String time, String reportLevel, String message) {
        if (ReportLevel.valueOf(reportLevel).ordinal() >= this.getReportLevel().ordinal()) {
            this.getLayout().setTime(time);
            this.getLayout().setReportLevel(reportLevel);
            this.getLayout().setMessage(message);
            this.setMessagesAppended(this.getMessagesAppended() + 1);
            this.operate();
        }
    }

    protected abstract void operate();
}
