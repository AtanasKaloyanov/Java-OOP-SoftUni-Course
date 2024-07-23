package T04InterfacesAndAbstraction.Exercise.P05Telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.urls.size(); i++) {
            String url = this.urls.get(i);
            char[] urlSymbols = url.toCharArray();
            boolean isNumber = false;
            for (char urlSymbol : urlSymbols) {
                if (Character.isDigit(urlSymbol)) {
                    isNumber = true;
                    break;
                }
            }
            addingBrowseMessage(sb, i, url, isNumber);
        }
        return sb.toString();
    }

    private void addingBrowseMessage(StringBuilder sb, int i, String url, boolean isNumber) {
        if (isNumber) {
            sb.append("Invalid URL!");
        } else {
            sb.append("Browsing: ").append(url).append("!");
        }
        if (i != this.urls.size() - 1) {
            sb.append("\n");
        }
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.numbers.size(); i++) {
            String telNumber = this.numbers.get(i);
            char[] urlSymbols = telNumber.toCharArray();
            boolean isNumber = true;
            for (char urlSymbol : urlSymbols) {
                if (!Character.isDigit(urlSymbol)) {
                    isNumber = false;
                    break;
                }
            }
            addingCallMessage(sb, i, telNumber, isNumber);
        }
        return sb.toString();
    }

    private void addingCallMessage(StringBuilder sb, int i, String telNumber, boolean isNumber) {
        if (!isNumber) {
            sb.append("Invalid number!");
        } else {
            sb.append("Calling... ").append(telNumber);
        }
        if (i != this.numbers.size() - 1) {
            sb.append("\n");
        }
    }
}