package specifications;

import javafx.scene.shape.Circle;
import metier.Starship;

public interface HealthService {

	public void apply(Starship starship);
	public Circle draw();
}
