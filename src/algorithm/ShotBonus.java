package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import metier.Starship;
import specifications.BonusService;
import tools.HardCodedParameters;
import tools.Position;

public class ShotBonus implements BonusService{
	//FIXME voir si c'est bien une liste de String qu'on voulait
	List<String> bonusList = new ArrayList<String>();
	private Position position;

	public ShotBonus() {
		super();
		this.bonusList = Arrays.asList("SimpleShot", "QuickShot", "DoubleShot", "TripleShot");
		int x=(int)(new Random().nextInt((int)(HardCodedParameters.defaultWidth)));
		this.position = new Position(x,0);
	}
	
	@Override
	public void apply(Starship starship) {
		// TODO Auto-generated method stub

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
