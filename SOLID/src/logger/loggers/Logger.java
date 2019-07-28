package logger.loggers;

import logger.appenders.Appender;

public abstract class Logger {
    private Appender[] appenders;

    Logger(Appender... appenders) {
        this.appenders = appenders;
    }

    public Appender[] getAppenders() {
        return this.appenders;
    }

    public void logInfo(String time, String message) {
        this.log(time, "INFO", message);
    }

    public void logWarning(String time, String message) {
        this.log(time, "WARNING", message);
    }

    public void logError(String time, String message) {
        this.log(time, "ERROR", message);
    }

    public void logCritical(String time, String message) {
        this.log(time, "CRITICAL", message);
    }

    public void logFatal(String time, String message) {
        this.log(time, "FATAL", message);
    }

    private void log(String time, String reportLevel, String message) {
        for (Appender appender : this.appenders) {
            appender.append(time, reportLevel, message);
        }
    }
}
