package metier;

import algorithm.SimpleShot;
import specifications.BonusService;
import specifications.HealthService;
import specifications.ShotService;
import specifications.StarshipService;

public abstract class Starship implements StarshipService {
	private short sizeX;
	private short sizeY;
	private short speed;
	private short life;
	private short frontSensor;
	private short sideSensor;
	private String starshipSkinModel;
	private short shotSpeedRate;
	private short shotStrength;
	private short shotIndex = 0;
	protected BonusService bonusService;
	protected HealthService healthService;
	protected ShotService shotService = new SimpleShot();
	
	//Constructeur par defaut
	public Starship(){}
	
	/**
	 * @return the sizeX
	 */
	public short getSizeX() {
		return sizeX;
	}

	/**
	 * @param sizeX the sizeX to set
	 */
	public void setSizeX(short sizeX) {
		this.sizeX = sizeX;
	}

	/**
	 * @return the sizeY
	 */
	public short getSizeY() {
		return sizeY;
	}

	/**
	 * @param sizeY the sizeY to set
	 */
	public void setSizeY(short sizeY) {
		this.sizeY = sizeY;
	}

	/**
	 * @return the speed
	 */
	public short getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(short speed) {
		this.speed = speed;
	}

	/**
	 * @return the life
	 */
	public short getLife() {
		return life;
	}

	/**
	 * @param life the life to set
	 */
	public void setLife(short life) {
		this.life = life;
	}

	/**
	 * @return the frontSensor
	 */
	public short getFrontSensor() {
		return frontSensor;
	}

	/**
	 * @param frontSensor the frontSensor to set
	 */
	public void setFrontSensor(short frontSensor) {
		this.frontSensor = frontSensor;
	}

	/**
	 * @return the sideSensor
	 */
	public short getSideSensor() {
		return sideSensor;
	}

	/**
	 * @param sideSensor the sideSensor to set
	 */
	public void setSideSensor(short sideSensor) {
		this.sideSensor = sideSensor;
	}

	/**
	 * @return the starshipSkinModel
	 */
	public String getStarshipSkinModel() {
		return starshipSkinModel;
	}

	/**
	 * @param starshipSkinModel the starshipSkinModel to set
	 */
	public void setStarshipSkinModel(String starshipSkinModel) {
		this.starshipSkinModel = starshipSkinModel;
	}

	/**
	 * @return the shotSpeedRate
	 */
	public short getShotSpeedRate() {
		return shotSpeedRate;
	}

	/**
	 * @param shotSpeedRate the shotSpeedRate to set
	 */
	public void setShotSpeedRate(short shotSpeedRate) {
		this.shotSpeedRate = shotSpeedRate;
	}

	/**
	 * @return the shotStrength
	 */
	public short getShotStrength() {
		return shotStrength;
	}

	/**
	 * @param shotStrength the shotStrength to set
	 */
	public void setShotStrength(short shotStrength) {
		this.shotStrength = shotStrength;
	}

	/**
	 * @return the bonusService
	 */
	public BonusService getBonusService() {
		return bonusService;
	}

	/**
	 * @param bonusService the bonusService to set
	 */
	public void setBonusService(BonusService bonusService) {
		this.bonusService = bonusService;
	}

	/**
	 * @return the healthService
	 */
	public HealthService getHealthService() {
		return healthService;
	}

	/**
	 * @param healthService the healthService to set
	 */
	public void setHealthService(HealthService healthService) {
		this.healthService = healthService;
	}

	/**
	 * @return the shotService
	 */
	public ShotService getShotService() {
		return shotService;
	}

	/**
	 * @param shotService the shotService to set
	 */
	public void setShotService(ShotService shotService) {
		this.shotService = shotService;
	}

	public short getShotIndex() {
		return shotIndex;
	}

	public void setShotIndex(short shotIndex) {
		this.shotIndex = shotIndex;
	}

	@Override
	public boolean isEnnemyDetected(){
		//TODO detecter la presence d'un ennemi
		return true;
	}
	
	@Override
	public void move(String direction){
		//TODO faire la methode pour bouger le vaisseau
	}
}
