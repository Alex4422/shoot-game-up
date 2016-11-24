package algorithm;

import metier.Bullet;
import metier.Starship;
import specifications.ShotService;
import tools.HardCodedParameters;
import tools.Position;

public class SimpleShot implements ShotService {

	@Override
	public void fire(Starship starship) {
		if(HardCodedParameters.bulletSpeedRateHero != 3)HardCodedParameters.bulletSpeedRateHero = 3;
		Bullet bullet = new Bullet(new Position(starship.getPosition().x, starship.getPosition().y));
		starship.getListShot().add(bullet);
	}

}
