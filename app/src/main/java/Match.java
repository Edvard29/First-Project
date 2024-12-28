public class Match {
    private String teamA;
    private String teamB;
    private String date;

    public Match(String teamA, String teamB, String date) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public String getDate() {
        return date;
    }
}
