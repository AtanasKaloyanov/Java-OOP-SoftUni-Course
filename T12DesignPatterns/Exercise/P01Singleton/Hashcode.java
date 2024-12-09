package T12DesignPatterns.Exercise.P01Singleton;

import java.util.Objects;

public class Hashcode {
    private static Hashcode instance;
    private final String point;

    private Hashcode() {
        this.point = String.valueOf(hashCode());
    }

    public static Hashcode getInstance() {
        if (instance == null) {
            instance = new Hashcode();
        }

        return instance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hashcode hashcode)) return false;
        return Objects.equals(point, hashcode.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
