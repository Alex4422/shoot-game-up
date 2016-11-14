package metier;

public class Game {
	private short level;
	private short remainingLives;
	private int currentScore;
	private int ennemyKilled;
	
	public Game(){
		
	}

	/**
	 * @return the level
	 */
	public short getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(short level) {
		this.level = level;
	}

	/**
	 * @return the remainingLives
	 */
	public short getRemainingLives() {
		return remainingLives;
	}

	/**
	 * @param remainingLives the remainingLives to set
	 */
	public void setRemainingLives(short remainingLives) {
		this.remainingLives = remainingLives;
	}

	/**
	 * @return the currentScore
	 */
	public int getCurrentScore() {
		return currentScore;
	}

	/**
	 * @param currentScore the currentScore to set
	 */
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	/**
	 * @return the ennemyKilled
	 */
	public int getEnnemyKilled() {
		return ennemyKilled;
	}

	/**
	 * @param ennemyKilled the ennemyKilled to set
	 */
	public void setEnnemyKilled(int ennemyKilled) {
		this.ennemyKilled = ennemyKilled;
	}
}
