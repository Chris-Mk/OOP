package logger.appenders.files;

public interface File {

    void write(String message);

    int getSize();
}
