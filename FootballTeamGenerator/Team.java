package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        if (!this.players.removeIf(player -> player.getName().equals(name))) {
            throw new IllegalArgumentException("Player " + name + " is not in " + this.getName()+ " team.");
        }
    }

    public double getRating() {
        if (this.players.isEmpty()) {
            return 0d;
        }
        return Math.round(this.players.stream().mapToDouble(Player::overallSkillLevel).average().getAsDouble());
    }
}
