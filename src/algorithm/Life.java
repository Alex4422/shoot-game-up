package algorithm;

import javafx.scene.shape.Circle;
import metier.Hero;
import metier.Player;
import metier.Starship;
import specifications.HealthService;

public class Life implements HealthService{

	@Override
	public void apply(Starship starship) {
		Player player = ((Hero) starship).getPlayer();

		System.out.println("before increment " + player.getRemainingLives());
		if (player.getRemainingLives() < 5) {
			player.setRemainingLives(player.getRemainingLives() + 1);
			System.out.println("after increment " + player.getRemainingLives());
		}
	}

	@Override
	public Circle draw() {
		// TODO Auto-generated method stub
		return null;
	}
}
