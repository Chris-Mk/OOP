package logger.layouts;

public class SimpleLayout extends Layout {

    @Override
    public String print() {
        return String.format("%s - %s - %s",
                this.getTime(),
                this.getReportLevel(),
                this.getMessage());
    }
}
