package T01WorkingWithAbstraction.Exercise.P04TrafficLights;

import java.util.List;

public class TrafficLight {
    private List<Color> colors;

    public TrafficLight(List<Color> colors) {
        this.colors = colors;
    }

    public void changeColors(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < this.colors.size(); j++) {
                Color color = this.colors.get(j);
                changeColor(j, color);
            }
            printChangedLights();
        }
    }

    private void printChangedLights() {
        System.out.println(this.colors.toString().replaceAll("[\\[\\],]", ""));
    }

    private void changeColor(int index, Color color) {
        if (color.equals(Color.RED)) {
            this.colors.set(index, Color.GREEN);
        } else if (color.equals(Color.YELLOW)) {
            this.colors.set(index, Color.RED);
        } else {
            this.colors.set(index, Color.YELLOW);
        }
    }
}
