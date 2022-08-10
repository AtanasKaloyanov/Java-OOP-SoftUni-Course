package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.*;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    private PlanetRepository planetRepository;
    private AstronautRepository astronautRepository;
    private int exploredPlanets;

    public ControllerImpl() {
        astronautRepository = new AstronautRepository();
        planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;

        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;

            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;

            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED,type, astronautName);

    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);

        for (String item : items) {
            planet.getItems().add(item);
        }

        planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);

        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        astronautRepository.remove(astronaut);

        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);

        }


    @Override
    public String explorePlanet(String planetName) {
       List<Astronaut> astronautList = new ArrayList<>();

        for (Astronaut currentAstrounaut : astronautRepository.getModels()) {
            if (currentAstrounaut.getOxygen() > 60) {
                astronautList.add(currentAstrounaut);
            }
        }

        if (astronautList.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Planet planet = planetRepository.findByName(planetName);
        Mission mission = new MissionImpl();
        mission.explore(planet, astronautList);

        long deadAstronauts = 0;

        for (Astronaut currenAstronaut : astronautList) {
            if (!currenAstronaut.canBreath()) {
                deadAstronauts++;
            }
        }

        exploredPlanets++;

        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deadAstronauts);

        //  List<Explorer> explorers = new ArrayList<>();
        //
        //        for (Explorer currentExplorer : explorerRepository.getCollection()) {
        //            if (currentExplorer.getEnergy() > 50) {
        //                explorers.add(currentExplorer);
        //            }
        //        }
        //
        //        if (explorers.isEmpty()) {
        //            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        //        }
        //
        //        State state = stateRepository.byName(stateName);
        //        Mission mission = new MissionImpl();
        //        mission.explore(state, explorers);
        //
        //        long retiredExplorers = 0;
        //
        //        for (Explorer currentExplorer : explorers) {
        //            if (!currentExplorer.canSearch()) {
        //                retiredExplorers++;
        //            }
        //        }
        //
        //        exploreStateCount++;
        //
        //        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retiredExplorers);

    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, exploredPlanets));
        sb.append("\n");
        sb.append(ConstantMessages.REPORT_ASTRONAUT_INFO);
        sb.append("\n");

        for (Astronaut currentAstronaut : astronautRepository.getModels()) {
            sb.append(currentAstronaut.toString());
            sb.append("\n");
        }

        return sb.toString().trim();
    }
}
