package logger;

import logger.appenders.Appender;
import logger.appenders.ConsoleAppender;
import logger.appenders.FileAppender;
import logger.appenders.ReportLevel;
import logger.appenders.files.File;
import logger.appenders.files.LogFile;
import logger.layouts.Layout;
import logger.layouts.SimpleLayout;
import logger.layouts.XmlLayout;
import logger.loggers.Logger;
import logger.loggers.MessageLogger;

import java.util.Scanner;

class Controller {
    static void readAppender() {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Appender[] appenders = new Appender[n];

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String appenderType = data[0];
            String layoutType = data[1];

            Layout layout = null;
            if (layoutType.equals("SimpleLayout")) {
                layout = new SimpleLayout();
            } else if (layoutType.equals("XmlLayout")) {
                layout = new XmlLayout();
            }

            Appender appender = null;
            if (appenderType.equals("ConsoleAppender")) {
                appender = new ConsoleAppender(layout);
            } else if (appenderType.equals("FileAppender")) {
                appender = new FileAppender(layout);
                File file = new LogFile();
                ((FileAppender) appender).setFile(file);
            }

            if (data.length == 3 && appender != null) {
                appender.setReportLevel(ReportLevel.valueOf(data[2]));
            }
            appenders[i] = appender;
        }

        Logger logger = new MessageLogger(appenders);
        String input;

        while (!"END".equals(input = scan.nextLine())) {
            String[] data = input.split("\\|");
            String reportLevel = data[0];
            String time = data[1];
            String message = data[2];

            if ("INFO".equals(reportLevel)) {
                logger.logInfo(time, message);
            } else if ("WARNING".equals(reportLevel)) {
                logger.logWarning(time, message);
            } else if ("ERROR".equals(reportLevel)) {
                logger.logError(time, message);
            } else if ("CRITICAL".equals(reportLevel)) {
                logger.logCritical(time, message);
            } else if ("FATAL".equals(reportLevel)) {
                logger.logFatal(time, message);
            }
        }

        System.out.println("Logger info");
        for (Appender appender : logger.getAppenders()) {
            StringBuilder result = new StringBuilder(String.format(
                    "Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                    appender.getClass().getSimpleName(),
                    appender.getLayout().getClass().getSimpleName(),
                    appender.getReportLevel().name(),
                    appender.getMessagesAppended()));

            if (appender instanceof FileAppender) {
                result.append(", File size: ").append(((FileAppender) appender).getFile().getSize());
            }
            System.out.println(result);
        }
    }
}
