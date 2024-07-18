package T02Encapsulation.Exercise.P05FootballTeamGenerator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Command implementation via while cycle with many checks:
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Team> teamByName = new HashMap<>();

        while (!line.equals("END")) {
            String[] array = line.split(";");
            String command = array[0];

            switch (command) {
                case "Team":
                    String teamName = array[1];
                    if (teamName == null || teamName.trim().isEmpty()) {
                        System.out.println("A name should not be empty.");
                        line = scanner.nextLine();
                        continue;
                    }

                    Team team = new Team(teamName);
                    teamByName.put(teamName, team);
                    break;
                case "Add":
                    String addingTeamName = array[1];
                    Team addingTeam = teamByName.get(addingTeamName);
                    if (addingTeam == null) {
                        System.out.printf("Team %s does not exist.\n", addingTeamName);
                        line = scanner.nextLine();
                        continue;
                    }

                    String playerName = array[2];
                    if (playerName == null || playerName.trim().isEmpty()) {
                        System.out.println("A name should not be empty.");
                        line = scanner.nextLine();
                        continue;
                    }

                    int endurance = Integer.parseInt(array[3]);
                    if (endurance < 0 || endurance > 100) {
                        System.out.println("Endurance should be between 0 and 100.");
                        line = scanner.nextLine();
                        continue;
                    }
                    int sprint = Integer.parseInt(array[4]);
                    if (sprint < 0 || sprint > 100) {
                        System.out.println("Sprint should be between 0 and 100.");
                        line = scanner.nextLine();
                        continue;
                    }
                    int dribble = Integer.parseInt(array[5]);
                    if (dribble < 0 || dribble > 100) {
                        System.out.println("Dribble should be between 0 and 100.");
                        line = scanner.nextLine();
                        continue;
                    }
                    int passing = Integer.parseInt(array[6]);
                    if (passing < 0 || passing > 100) {
                        System.out.println("Passing should be between 0 and 100.");
                        line = scanner.nextLine();
                        continue;
                    }
                    int shooting = Integer.parseInt(array[7]);
                    if (shooting < 0 || shooting > 100) {
                        System.out.println("Shooting should be between 0 and 100.");
                        line = scanner.nextLine();
                        continue;
                    }
                    Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                    addingTeam.addPlayer(player);
                    break;
                case "Remove":
                    String removingTeamName = array[1];
                    String removingPlayerName = array[2];
                    Team removingTeam = teamByName.get(removingTeamName);
                    if (removingTeam == null) {
                        System.out.printf("Team %s does not exist.\n", removingTeam);
                        line = scanner.nextLine();
                        continue;
                    }
                    removingTeam.removePlayer(removingPlayerName);
                    break;
                case "Rating":
                    String teamForShowingName = array[1];
                    Team teamForShowing = teamByName.get(teamForShowingName);
                    if (teamForShowing == null) {
                        System.out.printf("Team %s does not exist.\n", teamForShowingName);
                        line = scanner.nextLine();
                        continue;
                    }
                    double teamRating = Math.abs(teamForShowing.getRating());
                    System.out.printf("%s - %.0f\n", teamForShowingName, teamRating);
                    break;
            }

            line = scanner.nextLine();
        }
    }
}
