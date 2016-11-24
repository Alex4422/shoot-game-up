package algorithm;

import metier.Bullet;
import metier.Starship;
import specifications.ShotService;
import tools.Position;

public class DoubleShot implements ShotService{

	@Override
	public void fire(Starship starship) {
		Bullet pos1 = new Bullet(new Position((starship.getPosition().x- (starship.getSizeX()/2))+16, starship.getPosition().y));
		Bullet pos2 = new Bullet(new Position((starship.getPosition().x+ (starship.getSizeX()/2))-16, starship.getPosition().y));
		starship.getListShot().add(pos1);
		starship.getListShot().add(pos2);
	}
	


}
