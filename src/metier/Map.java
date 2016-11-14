package metier;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Map {

	private double width;
	private double height;
	private double axeX;
	private double axeY;
	
	public Map(){
		
	}
	
	public Map(double axeX, double axeY, double width, double height) {
		this.width = width;
		this.height = height;
		this.axeX = axeX;
		this.axeY = axeY;
	}
	
	//construct the map
	public Rectangle draw(){
		Rectangle rectangle = new Rectangle(this.width, this.height);
		rectangle.setFill(Color.WHITE);
		rectangle.setStroke(Color.DIMGRAY);
		rectangle.setTranslateX(this.axeX);
	    rectangle.setTranslateY(this.axeY);
		return rectangle;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the axeX
	 */
	public double getAxeX() {
		return axeX;
	}

	/**
	 * @param axeX the axeX to set
	 */
	public void setAxeX(double axeX) {
		this.axeX = axeX;
	}

	/**
	 * @return the axeY
	 */
	public double getAxeY() {
		return axeY;
	}

	/**
	 * @param axeY the axeY to set
	 */
	public void setAxeY(double axeY) {
		this.axeY = axeY;
	}
}
