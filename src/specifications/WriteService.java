/* ******************************************************
 * Project alpha - Composants logiciels 2015.
 * Copyright (C) 2015 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: specifications/WriteService.java 2015-03-11 buixuan.
 * ******************************************************/
package specifications;

import tools.Position;
import tools.Sound;

import java.util.ArrayList;

import metier.Alien;
import metier.Game;
import metier.Hero;
import metier.Map;
import metier.Player;

public interface WriteService {
	public void setHero(Hero hero);
	public void setGame(Game game);
	public void setPlayer(Player player);
	public void setStepNumber(int n);
	public void addAlien(Position p);
	public void setAliens(ArrayList<Alien> alien);
	public void setSoundEffect(Sound.SOUND s);
	public void addScore(int score);
	public void setShoot(boolean shoot);
	public void setMap(Map map);
	public void addLevelNumber(int levelNumber);
	public void setBonusService(BonusService bonus);
}
