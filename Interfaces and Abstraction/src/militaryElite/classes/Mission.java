package militaryElite.classes;

import militaryElite.enumerators.State;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    public String getCodeName() {
        return this.codeName;
    }

    public State getState() {
        return this.state;
    }

    public void completeMission() {
        this.state = State.FINISHED;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.getCodeName(),
                this.getState()
                        .name()
                        .toLowerCase()
                        .replaceAll("_p", "P"));
    }
}
