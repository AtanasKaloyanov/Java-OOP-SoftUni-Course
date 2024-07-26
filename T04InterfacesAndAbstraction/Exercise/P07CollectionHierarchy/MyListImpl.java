package T04InterfacesAndAbstraction.Exercise.P07CollectionHierarchy;

import java.util.List;

public class MyListImpl extends Collection implements MyList {

    @Override
    public String remove() {
        List<String> items = super.getItems();
        if (items.isEmpty()) {
            throw new UnsupportedOperationException("The list is empty.");
        }

        return items.remove(0);
    }

    @Override
    public int add(String element) {
        if (this.getUsed() == getMaxSize()) {
            throw new UnsupportedOperationException("There is no capacity in the collection for adding.");
        }
        super.getItems().add(0, element);
        return 0;
    }

    @Override
    public int getUsed() {
        return super.getItems().size();
    }
}
