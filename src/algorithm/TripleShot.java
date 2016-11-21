package algorithm;

import metier.Bullet;
import metier.Starship;
import specifications.ShotService;
import tools.Position;

public class TripleShot implements ShotService{

	@Override
	public void fire(Starship starship) {
		Bullet bullet1 = new Bullet(new Position(starship.getPosition().x, starship.getPosition().y-10));
		Bullet bullet2 = new Bullet(new Position((starship.getPosition().x- (starship.getSizeX()/2))+16, starship.getPosition().y));
		Bullet bullet3 = new Bullet(new Position((starship.getPosition().x+ (starship.getSizeX()/2))-16, starship.getPosition().y));
		
		starship.getListShot().add(bullet1);
		starship.getListShot().add(bullet2);
		starship.getListShot().add(bullet3);
	}


}
