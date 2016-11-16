package metier;

import tools.HardCodedParameters;

public class Hero extends Starship {
	
	private Player player;
	
	
	public Hero(Player player){
		this.player = player;
		
		this.setSizeX(HardCodedParameters.heroesWidth);
		this.setSizeY(HardCodedParameters.heroesHeight);
		this.setShotStrength((short) HardCodedParameters.bulletHero);
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
}
