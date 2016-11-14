/* ******************************************************
 * Project alpha - Composants logiciels 2015.
 * Copyright (C) 2015 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: specifications/ReadService.java 2015-03-11 buixuan.
 * ******************************************************/
package specifications;

import tools.Position;
import tools.Sound;

import java.util.ArrayList;
import java.util.List;

import metier.Map;
import metier.Starship;

public interface ReadService {
	public Position getHeroesPosition();
	public Starship getHero();
	public double getHeroesWidth();
	public double getHeroesHeight();
	public double getPhantomWidth();
	public double getPhantomHeight();
	public int getStepNumber();
	public int getScore();
	public Map getMap();
	public boolean getShoot();
	public ArrayList<PhantomService> getPhantoms();
	public Sound.SOUND getSoundEffect();
	public List<Position> getListShoot();
}
