package name.lemerdy.eric.tennis.model;


public class TennisGameInitialization {

    private String winnerPlayerName;
    private String looserPlayerName;
    private Choice winnerChoice;

    public TennisGameInitialization(String winnerPlayerName, String looserPlayerName) {
        this.winnerPlayerName = winnerPlayerName;
        this.looserPlayerName = looserPlayerName;
    }

    public String winner() {
        return winnerPlayerName;
    }

    public void winnerChooseToServeOrReceive() {
        winnerChoice = Choice.SERVE_OR_RECEIVE;
    }

    public String looser() {
        return looserPlayerName;
    }

    public Boolean looserMustChooseFieldSide() {
        return winnerChoice == Choice.SERVE_OR_RECEIVE;
    }

    public void winnerChooseTheFieldSize() {
    }

    public Boolean looserMustChooseToServerOrReceive() {
        return null;
    }

}
