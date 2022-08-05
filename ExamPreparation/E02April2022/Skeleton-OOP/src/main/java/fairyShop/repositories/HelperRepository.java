package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class HelperRepository implements Repository {
    private Collection<Helper> helpers;

    public HelperRepository() {
        this.helpers = new ArrayList<>();
    }

    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(helpers);
    }

    public void add(Helper helper) {
        helpers.add(helper);
    }

    public boolean remove(Helper helper) {
        return helpers.remove(helper);
    }

    public Helper findByName(String name) {
        return helpers.stream()
                .filter(helper -> helper.getName().equals(name))
                .findFirst().orElse(null);
    }
}
