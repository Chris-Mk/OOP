package militaryElite.classes;

public class Repair {
    private String partName;
    private Integer hoursWorked;

    public Repair(String partName, Integer hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    public String getPartName() {
        return this.partName;
    }

    public Integer getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d",
                this.getPartName(),
                this.getHoursWorked());
    }
}
