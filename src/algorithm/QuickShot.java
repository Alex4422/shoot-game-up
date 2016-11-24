package algorithm;

import metier.Bullet;
import metier.Hero;
import metier.Starship;
import specifications.ShotService;
import tools.HardCodedParameters;
import tools.Position;

public class QuickShot implements ShotService {

	@Override
	public void fire(Starship starship) {
		if(HardCodedParameters.bulletSpeedRateHero != 6 && starship instanceof Hero) {
			starship.setShotSpeedRate((short) 6);
			
		}
		Bullet bullet = new Bullet(new Position(starship.getPosition().x, starship.getPosition().y));
		starship.getListShot().add(bullet);
	}
	

}
