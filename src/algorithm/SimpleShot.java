package algorithm;

import java.util.List;

import javafx.scene.shape.Circle;
import metier.Starship;
import specifications.ShotService;
import tools.Position;

public class SimpleShot implements ShotService {

	@Override
	public void fire(Starship starship) {
		starship.getListShot().add(new Position(starship.getPosition().x, starship.getPosition().y));
	}

}
