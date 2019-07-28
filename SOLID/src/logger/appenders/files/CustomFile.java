package logger.appenders.files;

abstract class CustomFile implements File {
    private StringBuilder builder;

    CustomFile() {
        this.builder = new StringBuilder();
    }

    StringBuilder getBuilder() {
        return this.builder;
    }
}
