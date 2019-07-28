package logger.layouts;

public abstract class Layout {
    private String time;
    private String message;
    private String reportLevel;

    String getTime() {
        return this.time;
    }

    String getMessage() {
        return this.message;
    }

    String getReportLevel() {
        return this.reportLevel;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setReportLevel(String reportLevel) {
        this.reportLevel = reportLevel;
    }

    public abstract String print();
}
