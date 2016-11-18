package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import metier.Starship;
import specifications.BonusService;
import specifications.HealthService;
import tools.HardCodedParameters;
import tools.Position;

public class HealthBonus implements BonusService{
	//FIXME voir si c'est bien une liste de String qu'on voulait
	List<HealthService> bonusList = new ArrayList<HealthService>();
	private Position position;
	
	public HealthBonus() {
		this.bonusList = Arrays.asList(new Heal(), new Life());
		
		int x=(int)(new Random().nextInt((int)(HardCodedParameters.defaultWidth)));		
		this.position = new Position(x,0);
	}
	
	public HealthService getHealthBonus() {
		HealthService healthBonus = this.bonusList.get(new Random().nextInt(this.bonusList.size()));
		
		return healthBonus;		
	}
	
	@Override
	public void apply(Starship starship) {
		this.getHealthBonus().apply(starship);

	}

	@Override
	public void setPosition(Position p) {
		this.position = p;		
	}

	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

}
