package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public class MissionImpl implements Mission{

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        ArrayDeque<String> items = new ArrayDeque<>(planet.getItems());

        for (Astronaut currentAstrounaut : astronauts) {
              while (currentAstrounaut.canBreath() && !items.isEmpty()) {
                  currentAstrounaut.breath();
                  String currentItem = items.poll();
                  currentAstrounaut.getBag().getItems().add(currentItem);
                  planet.getItems().remove(currentItem);
              }

              if (items.isEmpty()) {
                  break;
              }
        }
    }
}

//ArrayDeque<String> exhibits = new ArrayDeque<>(state.getExhibits());

//for (Explorer explorer : explorers) {
//            while (explorer.canSearch() && !exhibits.isEmpty()) {
//                explorer.search();
//                String currentExhibit = exhibits.poll();
//                explorer.getSuitcase().getExhibits().add(currentExhibit);
//                state.getExhibits().remove(currentExhibit);
//            }
//            if (exhibits.isEmpty()) {
//                break;
//            }
//
//        }
