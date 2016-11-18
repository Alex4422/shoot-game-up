package algorithm;

import metier.Starship;
import specifications.ShotService;
import tools.HardCodedParameters;
import tools.Position;

public class SimpleShot implements ShotService {

	@Override
	public void fire(Starship starship) {
		if(HardCodedParameters.bulletSpeedRateHero != 3)HardCodedParameters.bulletSpeedRateHero = 3;
		starship.getListShot().add(new Position(starship.getPosition().x, starship.getPosition().y));
	}

}
