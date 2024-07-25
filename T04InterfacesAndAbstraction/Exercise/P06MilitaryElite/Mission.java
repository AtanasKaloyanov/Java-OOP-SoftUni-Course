package T04InterfacesAndAbstraction.Exercise.P06MilitaryElite;

public class Mission {
    private String codeName;
    private State state;

    public void completeMission() {
        this.state = State.finished;
    }

    public Mission(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.codeName,
                this.state);
    }
}
