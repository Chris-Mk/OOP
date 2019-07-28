package militaryElite.classes;

import militaryElite.enumerators.Corps;
import militaryElite.interfaces.Commando;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missions;

    public CommandoImpl(Integer id, String firstName, String lastName, Double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(System.lineSeparator())
                .append("Corps: ")
                .append(this.getCorps().name().charAt(0))
                .append(this.getCorps().name().substring(1).toLowerCase().replace("_", ""))
                .append(System.lineSeparator())
                .append("Missions:")
                .append(System.lineSeparator());
        this.getMissions()
                .stream()
                .filter(mission -> mission.getState().name().equals("IN_PROGRESS"))
                .forEach(mission -> builder.append("  ").append(mission.toString()).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}
