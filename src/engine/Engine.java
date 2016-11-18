/* ******************************************************
 * Project alpha - Composants logiciels 2015.
 * Copyright (C) 2015 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: engine/Engine.java 2015-03-11 buixuan.
 * ******************************************************/
package engine;

import tools.HardCodedParameters;
import tools.User;
import tools.Position;
import tools.Sound;

import specifications.EngineService;
import specifications.HealthService;
import specifications.BonusService;
import specifications.DataService;
import specifications.RequireDataService;
import specifications.ShotService;

import java.util.Timer;
import java.util.TimerTask;

import algorithm.HealthBonus;
import algorithm.ShotBonus;
import algorithm.SimpleShot;
import metier.Alien;
import metier.Starship;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Engine implements EngineService, RequireDataService{
	private static final double friction=HardCodedParameters.friction,
			heroesStep=HardCodedParameters.heroesStep,
			alienStep=HardCodedParameters.alienStep;
	private Timer engineClock;
	private DataService data;
	private Random gen;
	private short spawnedAlien;
	private boolean moveLeft,moveRight,moveUp,moveDown,shoot,isBossSpawn,dropBonus;
	private double heroesVX,heroesVY;

	public Engine(){}

	@Override
	public void bindDataService(DataService service){
		data=service;
	}

	@Override
	public void init(){
		engineClock = new Timer();
		gen = new Random();
		moveLeft = false;
		moveRight = false;
		moveUp = false;
		moveDown = false;
		shoot = false;
		isBossSpawn = false;
		dropBonus = false;
		heroesVX = 0;
		heroesVY = 0;
		spawnedAlien = 0;
	}

	@Override
	public void start(){
		engineClock.schedule(new TimerTask(){
			public void run() {
				//System.out.println("Game step #"+data.getStepNumber()+": checked.");
				if (data.getGame().getEnnemyKilled() == HardCodedParameters.nbAliensSpawn){
					data.getGame().startNewLevel(data.getGame().getLevel());
					data.getHero().setShotService(new SimpleShot());
					data.getHero().setShotIndex((short)0);
					data.getPlayer().setTotalKill(data.getGame().getEnnemyKilled() + data.getPlayer().getTotalKill());
					data.getGame().setEnnemyKilled(0);
					isBossSpawn = false;
					spawnedAlien = 0;
				} else if (!isBossSpawn &&
						data.getGame().getEnnemyKilled() == HardCodedParameters.nbAliensSpawn-1){
					spawnBoss();
					isBossSpawn = true;
				} else if(!isBossSpawn && spawnedAlien < HardCodedParameters.nbAliensSpawn-1){
					spawnAlien();
				}

				updateSpeedHeroes();
				updateCommandHeroes();
				updatePositionHeroes();
				
				if (data.getStepNumber() % 30 == 0 && data.getBonusService() == null) {
					dropBonus = true;
				}
				if (data.getBonusService() != null) {
					historiqueBonus();
				}

				if (shoot){
					data.getHero().getShotService().fire(data.getHero());
					shoot=false;
				}
				
				if (dropBonus) {
					generateRandomBonusService();
					dropBonus = false;
				}

				ArrayList<Alien> aliens = new ArrayList<Alien>();
				int score=0;

				data.setSoundEffect(Sound.SOUND.None);

				for (Alien p:data.getAliens()){
					//					PhantomService p = data.getPhantoms().get(i);
					if (p.getAction()==Alien.MOVE.LEFT) moveLeft(p);
					if (p.getAction()==Alien.MOVE.RIGHT) moveRight(p);
					if (p.getAction()==Alien.MOVE.DOWN) moveDown(p);
					collisionHerosBulletAlien(p);
					
					if (collisionHeroeAlien(p)){
						data.setSoundEffect(Sound.SOUND.HeroesGotHit);
						data.getGame().setEnnemyKilled(data.getGame().getEnnemyKilled()+1);
						score++;
					} else {
						if (p.getPosition().y < HardCodedParameters.defaultHeight -120 && p.getLife() > 0) {
							aliens.add(p);
						} else {
							data.getGame().setEnnemyKilled(data.getGame().getEnnemyKilled()+1);
						}
					}
				}

				data.addScore(score);

				data.setAliens(aliens);

				data.setStepNumber(data.getStepNumber()+1);
			}
		},0,HardCodedParameters.enginePaceMillis);
	}

	@Override
	public void stop(){
		engineClock.cancel();
	}

	@Override
	public void setHeroesCommand(User.COMMAND c){
		if (c==User.COMMAND.LEFT) moveLeft=true;
		if (c==User.COMMAND.RIGHT) moveRight=true;
		//		if (c==User.COMMAND.UP) moveUp=true;
		//		if (c==User.COMMAND.DOWN) moveDown=true;
		if (c==User.COMMAND.SHOOT) shoot=true;
	}

	@Override
	public void releaseHeroesCommand(User.COMMAND c){
		if (c==User.COMMAND.LEFT) moveLeft=false;
		if (c==User.COMMAND.RIGHT) moveRight=false;
		if (c==User.COMMAND.UP) moveUp=false;
		if (c==User.COMMAND.DOWN) moveDown=false;
		if (c==User.COMMAND.SHOOT) shoot=true;
	}

	private void updateSpeedHeroes(){
		heroesVX*=friction;
		heroesVY*=friction;
	}

	private void updateCommandHeroes(){
		if (moveLeft) heroesVX-=heroesStep;
		if (moveRight) heroesVX+=heroesStep;
		if (moveUp) heroesVY-=heroesStep;
		if (moveDown) heroesVY+=heroesStep;
		if(shoot) data.setShoot(true);
	}

	private void updatePositionHeroes(){
		if (!isHeroOutsideMapLimit()) {
			data.getHero().setPosition(new Position(data.getHero().getPosition().x+heroesVX,data.getHero().getPosition().y+heroesVY));
		}
		//		if (!isOutsideMapLimit(new Position(data.getHero().getPosition().x+heroesVX,data.getHero().getPosition().y+heroesVY))) {
		//			data.getHero().setPosition(new Position(data.getHero().getPosition().x+heroesVX,data.getHero().getPosition().y+heroesVY));
		//		}

	}

	private void spawnAlien(){
		int x=(int)(HardCodedParameters.defaultWidth);
		int y=0;
		boolean cont=true;
		while (cont) {
			x=(int)(gen.nextInt((int)(HardCodedParameters.defaultWidth)));
			cont=false;
			for (Alien p:data.getAliens()){
				if (p.getPosition().equals(new Position(x,y))) cont=true;
			}
		}
		data.addAlien(new Position(x,y));
		spawnedAlien++;
	}

	private void spawnBoss(){
		int x=(int)(HardCodedParameters.defaultWidth/2);
		int y=0;
		data.addAlien(new Position(x,y));
		data.getAliens().get(0).setSizeX((int)data.getAliens().get(0).getImage().getWidth()-45);
		data.getAliens().get(0).setSizeY((int)data.getAliens().get(0).getImage().getHeight());
		data.getAliens().get(0).setLife((short) HardCodedParameters.bossAlienHealth);
		data.getAliens().get(0).setSpeed((short)(HardCodedParameters.bossAlienStep));
		spawnedAlien++;
	}

	private void moveLeft(Alien p){
		//		if (!isOutsideMapLimit(new Position(p.getPosition().x-phantomStep,p.getPosition().y))) {
		p.setPosition(new Position(p.getPosition().x-alienStep,p.getPosition().y));
		//		}
	}

	private void moveRight(Alien p){
		//		if (p.getPosition().x + phantomStep > data.getMap().getWidth()) {
		p.setPosition(new Position(p.getPosition().x+alienStep,p.getPosition().y));			
		//		}
		//		if (!isOutsideMapLimit(new Position(p.getPosition().x+phantomStep,p.getPosition().y))) {
		//			p.setPosition(new Position(p.getPosition().x+phantomStep,p.getPosition().y));
		//		}

	}

	private void moveDown(Alien p){	
		if(isBossSpawn == true){
			double newY = p.getPosition().y+alienStep;
			if(newY<20){
				p.setPosition(new Position(p.getPosition().x,p.getPosition().y+alienStep));
			}
			//p.setPosition(new Position(p.getPosition().x,p.getPosition().y+alienStep));
			//if (p.getPosition().y>20) p.setPosition(new Position(p.getPosition().x+alienStep,20));
		}
		else{
			p.setPosition(new Position(p.getPosition().x,p.getPosition().y+alienStep));
		}
	}

	private boolean collisionHeroeAlien(Alien alien){
		return (
				(data.getHero().getPosition().x-alien.getPosition().x)*(data.getHero().getPosition().x-alien.getPosition().x)+
				(data.getHero().getPosition().y-alien.getPosition().y)*(data.getHero().getPosition().y-alien.getPosition().y) <
				0.25*(data.getHero().getSizeY()+data.getPhantomHeight())*(data.getHero().getSizeY()+data.getPhantomHeight())
				);
	}
	
	private void collisionHerosBulletAlien(Alien alien){
		for(int i = 0 ; i < data.getHero().getListShot().size() ; i++){         
			if(((alien.getPosition().x+15-data.getHero().getListShot().get(i).x)*(alien.getPosition().x+15-data.getHero().getListShot().get(i).x))+
				(alien.getPosition().y+10-data.getHero().getListShot().get(i).y)*(alien.getPosition().y+10-data.getHero().getListShot().get(i).y) <
					0.25*(alien.getSizeY()+10)*(alien.getSizeX()+10)){
				alien.setLife((short) (alien.getLife()- data.getHero().getShotStrength()));
				data.getHero().getListShot().remove(i);
			}
		}
	}
	//
	//	private boolean collisionHeroesPhantoms(){
	//		for (PhantomService p:data.getPhantoms()) if (collisionHeroesPhantom(p)) return true; return false;
	//	}

	private boolean isHeroOutsideMapLimit() {
		Starship hero = data.getHero();
		if (hero.getPosition().x + heroesVX < data.getMap().getAxeX()+25) {
			return true;
		} else if (hero.getPosition().x + heroesVX > HardCodedParameters.defaultWidth-25){
			return true;
		} else if (hero.getPosition().y + heroesVY > HardCodedParameters.defaultHeight-10) {
			return true;
		} else if (hero.getPosition().y + heroesVY  < data.getMap().getAxeY()) {
			return true;
		} else {
			return false;
		}
	}


	private boolean isBotOutsideMapLimit(Position p) {
		Starship hero = data.getHero();
		if (hero.getPosition().x + heroesVX - hero.getSizeX()/2 < data.getMap().getAxeX()) {
			return true;
		} else if (hero.getPosition().x + heroesVX + hero.getSizeX()/2 > data.getMap().getWidth()){
			return true;
		} else if (hero.getPosition().y + heroesVY + hero.getSizeY()/2 > data.getMap().getHeight()) {
			return true;
		} else if (hero.getPosition().y + heroesVY - hero.getSizeY()/2 < data.getMap().getAxeY()) {
			return true;
		} else {
			return false;
		}
	}

	private void generateRandomBonusService() {
		BonusService bonus;
		List<String> bonusList = Arrays.asList("shot", "health");
		String sBonus = bonusList.get(new Random().nextInt(bonusList.size()));
		System.out.println("random sBonus: " + sBonus);
		
		if (sBonus == "shot") {
			bonus = new ShotBonus();
		} else {
			bonus = new HealthBonus();
		}
		data.setBonusService(bonus);
	}
	

	private void historiqueBonus() {
		if (data.getBonusService().getPosition().y > HardCodedParameters.defaultHeight) {
			data.setBonusService(null);
		} else {
			data.getBonusService().getPosition().y += 10;
			collisionBonusObject(data.getBonusService());
		}
	}

	private void collisionBonusObject(BonusService bonus){
		if ((data.getHero().getPosition().x-5-bonus.getPosition().x)*(data.getHero().getPosition().x-5-bonus.getPosition().x)+
				(data.getHero().getPosition().y-bonus.getPosition().y)*(data.getHero().getPosition().y-bonus.getPosition().y) <
				0.25*(data.getHero().getSizeY()+10)*(data.getHero().getSizeY()+10)) {						

			System.out.println("*************colision hero bonus");
			
			data.getBonusService().apply(data.getHero());
			
			
			data.setBonusService(null);
			
			
		} else if (bonus.getPosition().y > HardCodedParameters.defaultHeight - 120) {
			System.out.println("********colision map bonus");
			data.setBonusService(null);
		}
	}


}
