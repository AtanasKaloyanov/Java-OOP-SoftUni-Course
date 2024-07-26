package T04InterfacesAndAbstraction.Exercise.P07CollectionHierarchy;

import java.util.List;

public class AddRemoveCollection extends Collection implements AddRemovable {

    @Override
    public String remove() {
        List<String> items = super.getItems();
        if (items.isEmpty()) {
            throw new UnsupportedOperationException("The list is empty.");
        }

        return items.remove(items.size() - 1);
    }

    @Override
    public int add(String element) {
        List<String> items = super.getItems();
        if (items.size() == getMaxSize()) {
            throw new UnsupportedOperationException("There is no capacity in the collection for adding.");
        }
        items.add(0, element);
        return 0;
    }
}
