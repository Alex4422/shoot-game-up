package specifications;

import metier.Starship;
import tools.Position;

public interface BonusService {

	public void apply(Starship starship);
	public void setPosition(Position p);
	public Position getPosition();
}
