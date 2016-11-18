package algorithm;

import metier.Starship;
import specifications.ShotService;
import tools.HardCodedParameters;
import tools.Position;

public class QuickShot implements ShotService {

	@Override
	public void fire(Starship starship) {
		if(HardCodedParameters.bulletSpeedRateHero != 5)HardCodedParameters.bulletSpeedRateHero = 5;
		starship.getListShot().add(new Position(starship.getPosition().x, starship.getPosition().y));
	}
	

}
