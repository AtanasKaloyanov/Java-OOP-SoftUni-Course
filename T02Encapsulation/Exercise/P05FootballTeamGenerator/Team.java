package T02Encapsulation.Exercise.P05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players = new ArrayList<>();

    public Team(String name) {
        setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String removingPlayerName) {
        Player playerForRemoving = null;
        for (Player player : this.players) {
            String currentPlayerName = player.getName();
            if (currentPlayerName.equals(removingPlayerName)) {
                playerForRemoving = player;
                break;
            }
        }

        boolean isRemoved = this.players.remove(playerForRemoving);
        if (!isRemoved) {
            String teamName = this.name;
            System.out.printf("Player %s is not in %s team.\n", removingPlayerName, teamName);
        }
    }

    public double getRating() {
        double overallRating = 0;
        for (Player player : this.players) {
            overallRating += player.overallSkillLevel();
        }
        return overallRating;
    }

}
