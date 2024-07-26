package T04InterfacesAndAbstraction.Exercise.P07CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private static final int MAX_SIZE = 100;
    private List<String> items = new ArrayList<>();

    public List<String> getItems() {
        return this.items;
    }

    public static int getMaxSize() {
        return MAX_SIZE;
    }
}
