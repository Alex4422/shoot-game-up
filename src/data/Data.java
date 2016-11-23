/* ******************************************************
 * Project alpha - Composants logiciels 2015.
 * Copyright (C) 2015 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: data/Data.java 2015-03-11 buixuan.
 * ******************************************************/
package data;

import tools.HardCodedParameters;
import tools.Position;
import tools.Sound;
import specifications.BonusService;
import specifications.DataService;
import javafx.scene.image.Image;
import metier.Alien;
import metier.Bullet;
import metier.Game;
import metier.Hero;
import metier.Map;
import metier.Player;
import metier.Starship;

import java.util.ArrayList;
import java.util.Random;

public class Data implements DataService{

	private int stepNumber, score, levelNumber;
	private ArrayList<Alien> aliens;
	private double phantomWidth,phantomHeight;
	private Sound.SOUND sound;
	private Starship hero;
	private Game game;
	private Player player;
	private Map map;
	private boolean shoot;
	private BonusService bonus;

	public Data(){}

	@Override
	public void init(){
		aliens = new ArrayList<Alien>();
		stepNumber = 0;
		score = 0;
		levelNumber = 1;
		phantomWidth = HardCodedParameters.phantomWidth;
		phantomHeight = HardCodedParameters.phantomHeight;
		sound = Sound.SOUND.None;
		map = new Map();
		bonus = null;

		//*********** STARSHIP ****************
		player = new Player();
		game = new Game();
		hero = new Hero(player);
		hero.setPosition(new Position(HardCodedParameters.heroesStartX,HardCodedParameters.heroesStartY));
		hero.setImage(new Image("file:src/images/spaceship-hero.png"));
		hero.setListShot(new ArrayList<Bullet>());

	}

	@Override
	public double getPhantomWidth(){ return phantomWidth; }

	@Override
	public double getPhantomHeight(){ return phantomHeight; }

	@Override
	public int getStepNumber(){ return stepNumber; }

	@Override
	public int getScore(){ return score; }

	@Override
	public Sound.SOUND getSoundEffect() { return sound; }

	@Override
	public void setStepNumber(int n){ stepNumber=n; }

	@Override
	public void addScore(int score){ this.score+=score; }

	@Override
	public void setSoundEffect(Sound.SOUND s) { sound=s; }

	@Override
	public Starship getHero() {return this.hero;}

	@Override
	public void setHero(Hero hero) {this.hero = hero;}

	@Override
	public boolean getShoot() {return this.shoot;}

	@Override
	public void setShoot(boolean shoot) {this.shoot = shoot;}

	@Override
	public Map getMap() {return this.map;}

	@Override
	public void setMap(Map map) {this.map = map;}

	@Override
	public ArrayList<Alien> getAliens() {return this.aliens;}

	@Override
	public void addAlien(Position p) {aliens.add(new Alien(p));}

	@Override
	public void setAliens(ArrayList<Alien> alien) {this.aliens = alien;}

	@Override
	public Game getGame() {return this.game;}

	@Override
	public Player getPlayer() {return this.player;}

	@Override
	public void setGame(Game game) {this.game = game;}

	@Override
	public void setPlayer(Player player) {this.player = player;}


	public int getLevelNumber() {return levelNumber;}

	public void addLevelNumber(int levelNumber) {this.levelNumber += levelNumber;}

	@Override
	public BonusService getBonusService() {
		return this.bonus;
	}

	@Override
	public void setBonusService(BonusService bonus) {

		if (bonus != null) {
			int x=(int) ((int)(new Random().nextInt(((int)(HardCodedParameters.defaultWidth)-50))) + this.map.getAxeX());
			System.out.println("bonus x :" + x);
			Position position = new Position(x,0);
			bonus.setPosition(position);			
		}
		
		this.bonus = bonus;
		
	}

}
