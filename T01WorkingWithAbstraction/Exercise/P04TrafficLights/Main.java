package T01WorkingWithAbstraction.Exercise.P04TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading -  Colors and n:
        Scanner scanner = new Scanner(System.in);
        List<Color> colorList = readList(scanner);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Creating object of type TrafficLight and
        TrafficLight trafficLight = new TrafficLight(colorList);
        trafficLight.changeColors(n);
    }

    private static List<Color> readList(Scanner scanner) {
        List<Color> colors = new ArrayList<>();
        String line = scanner.nextLine();
        String[] colorText = line.split(" ");
        for (String t : colorText) {
            Color color = Color.valueOf(t);
            colors.add(color);
        }
        return colors;
    }
}
