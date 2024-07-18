package T02Encapsulation.Exercise.P05FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        double skillSum = this.endurance + this.sprint + this.dribble + this.passing + this.shooting;
        return skillSum / 5.00;
    }
}
