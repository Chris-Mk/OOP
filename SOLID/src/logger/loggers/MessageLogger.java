package logger.loggers;

import logger.appenders.Appender;

public class MessageLogger extends Logger {

    public MessageLogger(Appender... appenders) {
        super(appenders);
    }
}
