package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayDeque;
import java.util.Collection;

public class MissionImpl implements Mission {

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        ArrayDeque<String> exhibits = new ArrayDeque<>(state.getExhibits());

        for (Explorer explorer : explorers) {
            while (explorer.canSearch() && !exhibits.isEmpty()) {
                explorer.search();
                String currentExhibit = exhibits.poll();
                explorer.getSuitcase().getExhibits().add(currentExhibit);
                state.getExhibits().remove(currentExhibit);
            }
            if (exhibits.isEmpty()) {
                break;
            }

        }
    }
}
