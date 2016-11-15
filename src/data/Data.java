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

import specifications.DataService;
import specifications.PhantomService;

import data.ia.MoveLeftPhantom;
import javafx.scene.image.Image;
import metier.Hero;
import metier.Map;
import metier.Starship;

import java.util.ArrayList;
import java.util.List;

public class Data implements DataService{
  //private Heroes hercules;
  private Position heroesPosition;
  private int stepNumber, score;
  private ArrayList<PhantomService> phantoms;
  private double heroesWidth,heroesHeight,phantomWidth,phantomHeight;
  private Sound.SOUND sound;
  private Starship hero;
  private Map map;
  private boolean shoot;
  
  public Data(){}

  @Override
  public void init(){
    //hercules = new Heroes;
    heroesPosition = new Position(HardCodedParameters.heroesStartX,HardCodedParameters.heroesStartY);
    phantoms = new ArrayList<PhantomService>();
    stepNumber = 0;
    score = 0;
    heroesWidth = HardCodedParameters.heroesWidth;
    heroesHeight = HardCodedParameters.heroesHeight;
    phantomWidth = HardCodedParameters.phantomWidth;
    phantomHeight = HardCodedParameters.phantomHeight;
    sound = Sound.SOUND.None;
    map = new Map();
    
    //*********** STARSHIP ****************
    hero = new Hero();
    hero.setPosition(new Position(HardCodedParameters.heroesStartX,HardCodedParameters.heroesStartY));
    hero.setImage(new Image("file:src/images/spaceship-hero.png"));
    hero.setListShot(new ArrayList<Position>());
    
  }

  @Override
  public Position getHeroesPosition(){ return heroesPosition; }
  
  @Override
  public double getHeroesWidth(){ return heroesWidth; }
  
  @Override
  public double getHeroesHeight(){ return heroesHeight; }
  
  @Override
  public double getPhantomWidth(){ return phantomWidth; }
  
  @Override
  public double getPhantomHeight(){ return phantomHeight; }

  @Override
  public int getStepNumber(){ return stepNumber; }
  
  @Override
  public int getScore(){ return score; }

  @Override
  public ArrayList<PhantomService> getPhantoms(){ return phantoms; }
  
  @Override
  public Sound.SOUND getSoundEffect() { return sound; }

  @Override
  public void setHeroesPosition(Position p) { heroesPosition=p; }
  
  @Override
  public void setStepNumber(int n){ stepNumber=n; }
  
  @Override
  public void addScore(int score){ this.score+=score; }

  @Override
  public void addPhantom(Position p) { phantoms.add(new MoveLeftPhantom(p)); }
  
  @Override
  public void setPhantoms(ArrayList<PhantomService> phantoms) { this.phantoms=phantoms; }
  
  @Override
  public void setSoundEffect(Sound.SOUND s) { sound=s; }

@Override
public Starship getHero() {
	// TODO Auto-generated method stub
	return this.hero;
}

@Override
public void setHero(Hero hero) {
	this.hero = hero;
	
}

@Override
public boolean getShoot() {return this.shoot;}

@Override
public void setShoot(boolean shoot) {this.shoot = shoot;}

@Override
public Map getMap() {return this.map;}

@Override
public void setMap(Map map) {this.map = map;}


}
