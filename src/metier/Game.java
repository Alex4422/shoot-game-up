package metier;

import tools.HardCodedParameters;

public class Game {
	private short level;
	private short remainingLives;
	private int currentScore;
	private int ennemyKilled;
	
	public Game(){
		this.level = 1;
		this.remainingLives = 3;
		this.currentScore = 0;
		this.ennemyKilled = 0;
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
	
	public void startNewLevel(short level){
		if(HardCodedParameters.alienStep < 10) HardCodedParameters.alienStep += 1;
		if(HardCodedParameters.alienFrontSensor < 350) HardCodedParameters.alienFrontSensor += 10;
		if(HardCodedParameters.bulletBossAlien < 125) HardCodedParameters.bulletBossAlien += 25;
		if(HardCodedParameters.bulletAlien < 10) HardCodedParameters.bulletAlien += 1;
		if(HardCodedParameters.nbAliensSpawn < 24) HardCodedParameters.nbAliensSpawn += 3;
		HardCodedParameters.bossAlienHealth += 250;
		HardCodedParameters.alienHealth += 10;
		this.level = (short)(level + 1) ;
	}
}
