package metier;

public class Heroe extends Starship {
	private Player player;
	
	public Heroe(){
		player = new Player();
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
