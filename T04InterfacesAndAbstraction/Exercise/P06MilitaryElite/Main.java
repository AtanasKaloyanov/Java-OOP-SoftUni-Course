package T04InterfacesAndAbstraction.Exercise.P06MilitaryElite;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
enum Corps - Airforces, Marines
class Repair - String partName, int hoursWorked
enum State - inProgress, finished
class Mission - String codeName, State state
 */
public class Main {
    public static void main(String[] args) {
        // 1. Input reading via While cycle, objects creating by the field className and object printint.
        // If the object is private => putting it into a map by id.
        // By this way we can add the private as an argument when it is needed:
        Map<Integer, PrivateImpl> privatesById = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] array = line.split(" ");
            String className = array[0];
            int id = Integer.parseInt(array[1]);
            String firstName = array[2];
            String lastName = array[3];

            switch (className) {
                case "Private":
                    double privateSalary = Double.parseDouble(array[4]);
                    PrivateImpl privateImpl = new PrivateImpl(id, firstName, lastName, privateSalary);
                    privatesById.put(id, privateImpl);
                    System.out.println(privateImpl);
                    break;

                case "LieutenantGeneral":
                    double lieutenantGeneralSalary = Double.parseDouble(array[4]);
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, lieutenantGeneralSalary);
                    for (int i = 5; i < array.length; i++) {
                        int privateId = Integer.parseInt(array[i]);
                        PrivateImpl privateImp = privatesById.get(privateId);
                        lieutenantGeneral.addPrivate(privateImp);
                    }

                    System.out.print(lieutenantGeneral);
                    break;

                case "Engineer":
                    String engineerCorpsName = array[5];
                    if (!engineerCorpsName.equals(Corps.Airforces.name()) && !engineerCorpsName.equals(Corps.Marines.name())) {
                        line = scanner.nextLine();
                        continue;
                    }

                    Corps engineerCorps = Corps.valueOf(engineerCorpsName);

                    double engineerSalary = Double.parseDouble(array[4]);
                    EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, engineerSalary, engineerCorps);
                    for (int i = 6; i < array.length; i += 2) {
                        String repairPart = array[i];
                        int workedHour = Integer.parseInt(array[i + 1]);
                        Repair repair = new Repair(repairPart, workedHour);
                        engineer.addRepair(repair);
                    }

                    System.out.print(engineer);
                    break;

                case "Commando":
                    String commandoCorpsName = array[5];
                    if (!commandoCorpsName.equals(Corps.Airforces.name()) && !commandoCorpsName.equals(Corps.Marines.name())) {
                        line = scanner.nextLine();
                        continue;
                    }

                    Corps commandoCorps = Corps.valueOf(commandoCorpsName);
                    double commandoSalary = Double.parseDouble(array[4]);
                    CommandoImpl commando = new CommandoImpl(id, firstName, lastName, commandoSalary, commandoCorps);
                    for (int i = 6; i < array.length; i += 2) {
                        String missionStateName = array[i + 1];
                        if (!missionStateName.equals(State.finished.name()) && !missionStateName.equals(State.inProgress.name())) {
                            continue;
                        }

                        State missionState = State.valueOf(missionStateName);
                        String missionName = array[i];
                        Mission mission = new Mission(missionName, missionState);
                        commando.addMission(mission);
                    }

                    System.out.print(commando);
                    break;

                case "Spy":
                    String spyCode = array[4];
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, spyCode);
                    System.out.println(spy);
                    break;
            }

            line = scanner.nextLine();
        }
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


Input 1 -> Output 1:
  1. Private 1 Peter Petrov 22.22
      -> Name : Perter Petrov Id: 1 Salary: 22.22
  2. Commando 13 Stam Stamov 13.1 Airforces
      -> Name: Stam Stamov Id: 13 Salary: 13.10
         Corps: Airforces
         Missions:
  3. Private 222 Tom Tomson 80.08
      -> Name: Tom Tomson Id: 222 Salary: 80.08
  4. LieutenantGeneral 3 John Johnson 100 222 1
      -> Name: John Johnson Id: 3 Salary 100
         Privates:
             Name: Tom Tomson Id: 222 Salary: 80.08
             Name : Perter Petrov Id: 1 Salary: 22.22

Input 2 -> Output 2:
   1. Engineer 7 Peter Petrov 12.23 Marines Boat 2 Crane 17
      -> Name: Peter Petrov Id: 7 Salary: 12.23
         Corps: Marines
         Repairs:
         Part Name: Boat Hours Worked: 2
         Part Name: Crane Hours Worked: 17

   2. Commando 19 Sara Johnson 150.15 Airforces HairyFoot finished Freedom inProgress
      -> Name: Sara Johnson Id: 19 Salary: 150.15
         Corps: Airforces
         Missions:
           Code Name: HairyFoot State: finished
           Code Name: Freedom State: inProgress

Input 3 -> Output 3:
    1. LieutenantGeneral 17 No Units 500.01
       -> Name: No Units Id: 17 Salary: 500.01
          Privates:

    2. Spy 7 James Bond 007
       -> Name: James Bond Id: 7
          Code Number: 007

    3. Spy 8 James Boned 008
       -> Name: James Boned Id: 8
          Code Number: 008

 */