package fairyShop.repositories;

import fairyShop.models.Present;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class PresentRepository implements Repository{
    Collection<Present> presents;

    public PresentRepository() {
        this.presents = new ArrayList<>();
    }

    public Collection<Present> getModels() {
        return Collections.unmodifiableCollection(presents);
    }

    public void add(Present present) {
         presents.add(present);
    }

    public boolean remove(Present present) {
        return presents.remove(present);
    }

    public Present findByName(String name) {
        return presents.stream()
                .filter(present -> present.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
