package T04InterfacesAndAbstraction.Exercise.P05Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            boolean correctNumber = true;
            char[] charArray = number.toCharArray();

            for (char currentChar : charArray) {
                if (!Character.isDigit(currentChar)) {
                    correctNumber = false;
                    break;
                }
            }

            if (correctNumber) {
                sb.append(String.format("Calling... %s", number));
                sb.append("\n");
            } else {
                sb.append("Invalid number!");
                sb.append("\n");
            }
        }

        return sb.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            char[] array = url.toCharArray();
            boolean correctUrl = true;
            for (char currentChar : array) {
                if (Character.isDigit(currentChar)) {
                    correctUrl = false;
                    break;
                }
            }

            if (correctUrl) {
                sb.append(String.format("Browsing: %s!", url));
                sb.append("\n");
            } else {
                sb.append(String.format("Invalid URL!"));
                sb.append("\n");
            }
        }

        return sb.toString().trim();
    }
}
