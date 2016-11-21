package algorithm;

import metier.Bullet;
import metier.Starship;
import specifications.ShotService;
import tools.HardCodedParameters;
import tools.Position;

public class QuickShot implements ShotService {

	@Override
	public void fire(Starship starship) {
		if(HardCodedParameters.bulletSpeedRateHero != 5)HardCodedParameters.bulletSpeedRateHero = 5;
		Bullet bullet = new Bullet(new Position(starship.getPosition().x, starship.getPosition().y));
		starship.getListShot().add(bullet);
	}
	

}
