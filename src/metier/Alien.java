package metier;

import java.util.ArrayList;

import javafx.scene.image.Image;
import tools.HardCodedParameters;
import tools.Position;

public class Alien extends Starship{
	
	private MOVE direction = MOVE.DOWN;
	private int fireX;
	private int fireY;
	
	public enum MOVE { LEFT, RIGHT,DOWN };
	
	public Alien(Position p){
		this.setPosition(p);
		this.setImage(new Image("file:src/images/alien.png"));
		this.setSizeX((int) this.getImage().getWidth()-55);
		this.setSizeY((int)this.getImage().getHeight()-15);
		this.setLife((short) HardCodedParameters.alienHealth);
		this.setListShot(new ArrayList<Bullet>());
	}
	
	public MOVE getAction(){ return direction;};
	
	public void setAction(MOVE direction){
		this.direction = direction;
	}
	
	public void fire () {
		System.out.println("alien fire");
		Bullet bullet = new Bullet(new Position(this.getPosition().x, this.getPosition().y), this.fireX, this.fireY);
		this.getListShot().add(bullet);
	}

	/**
	 * @return the direction
	 */
	public MOVE getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(MOVE direction) {
		this.direction = direction;
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
