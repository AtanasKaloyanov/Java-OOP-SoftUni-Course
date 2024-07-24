package T04InterfacesAndAbstraction.Exercise.P06MilitaryElite;

/*
enum Corps - Airforces, Marines
class Repair - String partName, int hoursWorked
enum State - inProgress, finished
class Mission - String codeName, State state
 */
public class Main {
    public static void main(String[] args) {

    }
}

/*
                                                                                          interface Soldier - int getId(), String getFirstName(), String getLastName()
                                                                                            class SoldierImpl - int id, String firstName, String lastName / Overriden - 3 getters()



                                                           interface Private - double getSalary()                                                                                    interface Spy - getCode()
                                                               class PrivateImpl - double salary / 1 O. getter()                                                                         class SpyImpl - O. 1 getter()


interface LietenantGeneral -   Set<Private> getPrivates()                                                  interface SpecialisedSoldier - Corps getCorps()
   class LitenantGeneralImpl - Set<Private> privates                                                          class SpecialisedSoldierImpl - Corps corps / 1 O. getter()
                              / 1 O getter(),
                              void addPrivate(Private private)

                                                                          interface Engineer - Set<Repair> getRepairs()                                interface Commando - Set<Mission> getMissions()
                                                                             class EngineerImpl - Set<Repair> repairs                                     class CommandoImpl - Set<Mission> missions, /
                                                                            O. void addRepair(Repair repair), Collection<Repair> getRepairs()               void addMission(Mission mission), O. Set<Mission> getMission()


 */