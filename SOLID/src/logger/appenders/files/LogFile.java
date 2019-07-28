package logger.appenders.files;

public class LogFile extends CustomFile {

    @Override
    public void write(String message) {
        this.getBuilder()
                .append(message)
                .append(System.lineSeparator());
    }

    @Override
    public int getSize() {
        int sum = 0;
        for (int i = 0; i < this.getBuilder().length(); i++) {
            char ch = this.getBuilder().charAt(i);

            if (Character.isLetter(ch)) {
                sum += this.getBuilder().charAt(i);
            }
        }
        return sum;
    }
}
