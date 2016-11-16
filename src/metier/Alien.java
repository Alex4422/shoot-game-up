package metier;

import javafx.scene.image.Image;
import tools.HardCodedParameters;
import tools.Position;

public class Alien extends Starship{
	
	private MOVE direction = MOVE.DOWN;
	
	public enum MOVE { LEFT, RIGHT,DOWN };
	
	public Alien(Position p){
		this.setPosition(p);
		this.setSizeX(HardCodedParameters.alienWidth);
		this.setSizeY(HardCodedParameters.alienHeight);
		this.setImage(new Image("file:src/images/spaceship-hero.png"));
	}
	
	public MOVE getAction(){ return direction;};
	
	public void setAction(MOVE direction){
		this.direction = direction;
	}
	
}
