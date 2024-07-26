package T04InterfacesAndAbstraction.Exercise.P07CollectionHierarchy;

import java.util.List;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String element) {
        List<String> items = super.getItems();
        if (items.size() == getMaxSize()) {
           throw new UnsupportedOperationException("There is no capacity in the collection for adding.");
        }
        items.add(element);
        return items.size() - 1;
    }
}
