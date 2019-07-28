package militaryElite.classes;

import militaryElite.enumerators.Corps;
import militaryElite.interfaces.Engineer;

import java.util.*;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(Integer id, String firstName, String lastName, Double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(System.lineSeparator())
                .append("Corps: ")
                .append(this.getCorps().name().charAt(0))
                .append(this.getCorps().name().substring(1).toLowerCase().replace("_", ""))
                .append(System.lineSeparator())
                .append("Repairs:")
                .append(System.lineSeparator());
        this.getRepairs()
                .stream()
                .sorted(Comparator.comparingInt(Repair::getHoursWorked))
                .forEach(repair -> builder.append("  ").append(repair.toString()).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}
