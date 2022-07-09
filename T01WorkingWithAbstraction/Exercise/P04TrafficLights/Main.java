package T01WorkingWithAbstraction.Exercise.P04TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] colors = scanner.nextLine().split("\\s+");
        int numberChanges = Integer.parseInt(scanner.nextLine());

        List<Light> trafficLight = new ArrayList<>();

        for (String color : colors) {
            Light light = new Light(Color.valueOf(color));
            trafficLight.add(light);
        }

        for (int i = 1; i <= numberChanges ; i++) {
            trafficLight.forEach(element -> {
                element.changeColor();
                System.out.print(element.getColor() + " ");
            });
            System.out.println();
        }
    }
}
