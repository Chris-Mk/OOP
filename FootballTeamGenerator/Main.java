package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Team> teams = new ArrayList<>();

        String input;
        while (!"END".equals(input = scan.nextLine())) {
            String[] data = input.split(";");

            switch (data[0]) {
                case "Team":
                    try {
                        Team team = new Team(data[1]);
                        teams.add(team);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add":
                    boolean addedPlayer = false;
                    for (Team team1 : teams) {
                        if (team1.getName().equals(data[1])) {
                            try {
                                Player player = new Player(data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]),
                                        Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]));
                                team1.addPlayer(player);
                                addedPlayer = true;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                addedPlayer = true;
                            }
                        }
                    }

                    if (!addedPlayer) {
                        System.out.println("Team " + data[1] + " does not exist.");
                    }
                    break;
                case "Remove":
                    for (Team team1 : teams) {
                        if (team1.getName().equals(data[1])) {
                            try {
                                team1.removePlayer(data[2]);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    break;
                case "Rating":
                    boolean isTeamPresent = false;
                    for (Team team1 : teams) {
                        if (team1.getName().equals(data[1])) {
                            System.out.println(String.format("%s - %.0f", team1.getName(), team1.getRating()));
                            isTeamPresent = true;
                            break;
                        }
                    }

                    if (!isTeamPresent) {
                        System.out.println("Team " + data[1] + " does not exist.");
                    }
                    break;
            }
        }
    }
}
