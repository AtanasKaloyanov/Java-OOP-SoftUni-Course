package T07ReflectionAndAnnotation.Lab.P05CodingTracker;

public class Main {
    public static void main(String[] args) {
        // 1. Obtain the class Tracker and invoke the static method printMethodsByAuthor:
        Class<Tracker> trackerClass = Tracker.class;
        Tracker.printMethodsByAuthor(trackerClass);
    }
}
