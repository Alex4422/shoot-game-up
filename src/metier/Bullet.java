package metier;

import tools.Position;

public class Bullet {
	private Position position;
	private int fireX;
	private int fireY;
	
	/* Constructor */
	public Bullet() {
	}
	
	public Bullet (Position position) {
		this.position = position;
	}
	
	public Bullet(Position position, int fireX, int fireY) {
		this.position = position;
		this.fireX = fireX;
		this.fireY = fireY;
	}
	
	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	/**
	 * @return the fireX
	 */
	public int getFireX() {
		return fireX;
	}
	/**
	 * @param fireX the fireX to set
	 */
	public void setFireX(int fireX) {
		this.fireX = fireX;
	}
	/**
	 * @return the fireY
	 */
	public int getFireY() {
		return fireY;
	}
	/**
	 * @param fireY the fireY to set
	 */
	public void setFireY(int fireY) {
		this.fireY = fireY;
	}
	
	

}
