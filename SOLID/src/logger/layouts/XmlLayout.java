package logger.layouts;

public class XmlLayout extends Layout {
    @Override
    public String print() {
        return "<log>" +
                System.lineSeparator() +
                "   " + "<date>" + this.getTime() + "</date>" +
                System.lineSeparator() +
                "   " + "<level>" + this.getReportLevel() + "</level>" +
                System.lineSeparator() +
                "   " + "<message>" + this.getMessage() + "</message>" +
                System.lineSeparator() +
                "</log>";
    }
}
