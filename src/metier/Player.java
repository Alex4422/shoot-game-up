package metier;

public class Player {
	private int score;
	private int totalKill;
	private String pseudo;
	private String timePlayed;
	private int remainingLives;

	public Player(){
		this.remainingLives = 3;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the totalKill
	 */
	public int getTotalKill() {
		return totalKill;
	}

	/**
	 * @param totalKill the totalKill to set
	 */
	public void setTotalKill(int totalKill) {
		this.totalKill = totalKill;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the timePlayed
	 */
	public String getTimePlayed() {
		return timePlayed;
	}

	/**
	 * @param timePlayed the timePlayed to set
	 */
	public void setTimePlayed(String timePlayed) {
		this.timePlayed = timePlayed;
	}

	
	/**
	 * @return the remainingLives
	 */
	public int getRemainingLives() {
		return remainingLives;
	}

	/**
	 * @param remainingLives the remainingLives to set
	 */
	public void setRemainingLives(int remainingLives) {
		this.remainingLives = remainingLives;
	}
}
