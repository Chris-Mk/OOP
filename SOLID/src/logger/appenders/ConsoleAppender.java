package logger.appenders;

import logger.layouts.Layout;

public class ConsoleAppender extends Appender {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void operate() {
        System.out.println(this.getLayout().print());
    }
}
