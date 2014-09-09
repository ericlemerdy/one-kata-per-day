package name.lemerdy.model;

public class Winner {

	private String playerName;

	private String reason;

	public Winner(String playerName, String reason) {
		this.playerName = playerName;
		this.reason = reason;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getReason() {
		return reason;
	}

}
