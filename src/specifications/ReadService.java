/* ******************************************************
 * Project alpha - Composants logiciels 2015.
 * Copyright (C) 2015 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: specifications/ReadService.java 2015-03-11 buixuan.
 * ******************************************************/
package specifications;

import tools.Sound;

import java.util.ArrayList;

import metier.Alien;
import metier.Game;
import metier.Map;
import metier.Player;
import metier.Starship;

public interface ReadService {
	public Starship getHero();
	public Game getGame();
	public Player getPlayer();
	public double getPhantomWidth();
	public double getPhantomHeight();
	public int getStepNumber();
	public int getScore();
	public Map getMap();
	public boolean getShoot();
	public ArrayList<Alien> getAliens();
	public Sound.SOUND getSoundEffect();
	public int getLevelNumber();
	public BonusService getBonusService();
}
