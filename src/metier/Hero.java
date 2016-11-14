package metier;

import tools.HardCodedParameters;

public class Hero extends Starship {
	private Player player;
	
	public Hero(){
		player = new Player();
		
		this.setSizeX(HardCodedParameters.heroesStartX);
		this.setSizeY(HardCodedParameters.heroesStartY);
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