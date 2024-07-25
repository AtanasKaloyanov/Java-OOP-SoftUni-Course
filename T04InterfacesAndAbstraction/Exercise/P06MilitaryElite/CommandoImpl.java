package T04InterfacesAndAbstraction.Exercise.P06MilitaryElite;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Set<Mission> missions = new LinkedHashSet<>();

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
    }

    public  void addMission(Mission mission) {
       this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(super.toString()).append("\n");
        result.append("Missions:").append("\n");
        for (Mission mission : this.getMissions()) {
            result.append("  ").append(mission).append("\n");
        }
        return result.toString();
    }
}
