package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.*;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private int exploreStateCount;

    public ControllerImpl() {
        stateRepository = new StateRepository();
        explorerRepository = new ExplorerRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = null;

        if (type.equals("AnimalExplorer")) {
            explorer = new AnimalExplorer(explorerName);
        } else if (type.equals("GlacierExplorer")) {
            explorer = new GlacierExplorer(explorerName);
        } else if (type.equals("NaturalExplorer")) {
            explorer = new NaturalExplorer(explorerName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }

        explorerRepository.add(explorer);
        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);

        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }

        stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);

        if (explorer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        explorerRepository.remove(explorer);

        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }


    @Override
    public String exploreState(String stateName) {
        List<Explorer> explorers = new ArrayList<>();

        for (Explorer currentExplorer : explorerRepository.getCollection()) {
            if (currentExplorer.getEnergy() > 50) {
                explorers.add(currentExplorer);
            }
        }

        if (explorers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        State state = stateRepository.byName(stateName);
        Mission mission = new MissionImpl();
        mission.explore(state, explorers);

        long retiredExplorers = 0;

        for (Explorer currentExplorer : explorers) {
            if (!currentExplorer.canSearch()) {
                retiredExplorers++;
            }
        }

        exploreStateCount++;

        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retiredExplorers);

    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, exploreStateCount));
        sb.append("\n");
        sb.append(ConstantMessages.FINAL_EXPLORER_INFO);
        sb.append("\n");

        for (Explorer explorer : explorerRepository.getCollection()) {
            sb.append(explorer.tosString());
            sb.append("\n");
        }

        return sb.toString().trim();

//        return String.format(ConstantMessages.FINAL_STATE_EXPLORED, exploreStateCount) + System.lineSeparator() +
//                ConstantMessages.FINAL_EXPLORER_INFO + System.lineSeparator() +
//                explorerRepository.getCollection().stream().map(Explorer::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}
