package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import metier.Starship;
import specifications.BonusService;

public class ShotBonus implements BonusService{
	//FIXME voir si c'est bien une liste de String qu'on voulait
	List<String> bonusList = new ArrayList<String>();

	public ShotBonus() {
		super();
		this.bonusList = Arrays.asList("SimpleShot", "QuickShot", "DoubleShot", "TripleShot");
	}

	@Override
	public void apply(Starship starship) {
		// TODO Auto-generated method stub

	}

}
