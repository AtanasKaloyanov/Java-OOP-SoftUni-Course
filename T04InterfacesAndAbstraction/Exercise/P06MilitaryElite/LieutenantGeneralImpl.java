package T04InterfacesAndAbstraction.Exercise.P06MilitaryElite;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Set<PrivateImpl> privates = new TreeSet<>();

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
    }

    public void addPrivate(Private priv) {
        if (priv instanceof PrivateImpl) {
            this.privates.add((PrivateImpl) priv);
        }
    }

    @Override
    public Collection<PrivateImpl> getPrivates() {
        return this.privates;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
         result.append(super.toString()).append("\n");
                result.append("Privates:").append("\n");
                for (PrivateImpl pr : this.getPrivates()) {
                    result.append("  ").append(pr).append("\n");
                }
                return result.toString();
    }
}
