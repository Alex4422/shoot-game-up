package metier;

import javafx.scene.shape.Rectangle;

public class Map {

	private int width;
	private int height;
	private int axeX;
	private int axeY;
	
	public Map(){
		
	}
	
	public Rectangle draw(){
		//FIXME faire la methode qui dessine la map
		return null;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the axeX
	 */
	public int getAxeX() {
		return axeX;
	}

	/**
	 * @param axeX the axeX to set
	 */
	public void setAxeX(int axeX) {
		this.axeX = axeX;
	}

	/**
	 * @return the axeY
	 */
	public int getAxeY() {
		return axeY;
	}

	/**
	 * @param axeY the axeY to set
	 */
	public void setAxeY(int axeY) {
		this.axeY = axeY;
	}
}
