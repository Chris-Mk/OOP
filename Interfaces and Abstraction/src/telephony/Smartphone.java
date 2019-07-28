package telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = new ArrayList<>(numbers);
        this.urls = new ArrayList<>(urls);
    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();

        for (String url : this.urls) {
            builder.append(validateURL(url));
        }
        return builder.toString().trim();
    }

    private String validateURL(String url) {
        for (char symbol : url.toCharArray()) {
            if (Character.isDigit(symbol)) {
                return "Invalid URL!" + System.lineSeparator();
            }
        }
        return "Browsing: " + url + "!" + System.lineSeparator();
    }

    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();

        for (String number : this.numbers) {
            builder.append(validateNumber(number));
        }
        return builder.toString().trim();
    }

    private String validateNumber(String number) {
        for (char symbol : number.toCharArray()) {
            if (!Character.isDigit(symbol)) {
                return "Invalid number!" + System.lineSeparator();
            }
        }
        return "Calling... " + number + System.lineSeparator();
    }
}
