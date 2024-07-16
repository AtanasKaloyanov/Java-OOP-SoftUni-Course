package T02Encapsulation.Lab.P04FirstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. Input reading:
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        // 2. Creating an initialization of the class Team and
        // adding people into one of the teams (List<Person>) via addMethod:
        Team team = new Team("Programmers");
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);
            Person person = new Person(firstName, lastName, age, salary);
            team.addPlayer(person);
        }

        // 3. Getting the size of the both teams and printing the output:
        int team1Size = team.getFirstTeam().size();
        int team2Size = team.getReserveTeam().size();
        System.out.printf("First team have %d players\n", team1Size);
        System.out.printf("Reserve team have %d players", team2Size);
    }
}
