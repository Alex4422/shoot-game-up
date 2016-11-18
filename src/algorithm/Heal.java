package algorithm;

import javafx.scene.shape.Circle;
import metier.Starship;
import specifications.HealthService;
import tools.HardCodedParameters;

public class Heal implements HealthService{

	@Override
	public void apply(Starship starship) {
		System.out.println("before heal " + HardCodedParameters.heroesHealth);
		starship.setLife((short) HardCodedParameters.heroesHealth);
		System.out.println("after heal " + starship.getLife());
		
	}

	@Override
	public Circle draw() {
		// TODO Auto-generated method stub
		return null;
	}
}
