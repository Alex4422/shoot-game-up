package algorithm;

import metier.Bullet;
import metier.Starship;
import specifications.ShotService;
import tools.HardCodedParameters;
import tools.Position;

public class QuickShot implements ShotService {

	@Override
	public void fire(Starship starship) {
		if(HardCodedParameters.bulletSpeedRateHero != 6)HardCodedParameters.bulletSpeedRateHero = 6;
		Bullet bullet = new Bullet(new Position(starship.getPosition().x, starship.getPosition().y));
		starship.getListShot().add(bullet);
	}
	

}
