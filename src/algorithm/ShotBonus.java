package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import metier.Starship;
import specifications.BonusService;
import specifications.ShotService;
import tools.HardCodedParameters;
import tools.Position;
import java.lang.reflect.*;

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

		if (starship.getShotIndex() < this.bonusList.size() - 1) {
			starship.setShotIndex((short) (starship.getShotIndex() + 1));
		}
		
		String shot = "algorithm." + this.bonusList.get(starship.getShotIndex());
		Object shotService;
		try {
			shotService = Class.forName(shot).newInstance();
			starship.setShotService((ShotService) shotService);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(starship.getShotService());
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
