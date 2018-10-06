package tracksegments;

import android.graphics.Point;
import obstacles.*;

public class LabThree extends TrackBlueprint {
	public LabThree (Point screenDims) {
		super(screenDims, screenDims.x * 16 / 9, false);
	}

	@Override
	protected void setObs () {
		int gridSize = width / 9;
		Obstacle z1555141418 = new Wall(6 * gridSize, 15 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z1555141418, -1555141418);
		Obstacle z1555195409 = new Wall(0 * gridSize, 1 * gridSize, new Point(1 * gridSize, 15 * gridSize));
		addToObs(z1555195409, 1555195409);
		Obstacle z686967007 = new Wall(1 * gridSize, 14 * gridSize, new Point(2 * gridSize, 2 * gridSize));
		addToObs(z686967007, 686967007);
		Obstacle z1134609425 = new Wall(2 * gridSize, 6 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z1134609425, -1134609425);
		Obstacle z1376639155 = new Wall(2 * gridSize, 2 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z1376639155, -1376639155);
		Obstacle z1675773683 = new Wall(1 * gridSize, 8 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z1675773683, 1675773683);
		Obstacle z135706274 = new Wall(2 * gridSize, 10 * gridSize, new Point(3 * gridSize, 1 * gridSize));
		addToObs(z135706274, 135706274);
		Obstacle z1520521866 = new Wall(1 * gridSize, 12 * gridSize, new Point(6 * gridSize, 2 * gridSize));
		addToObs(z1520521866, 1520521866);
		Obstacle z1751075917 = new Wall(6 * gridSize, 2 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z1751075917, 1751075917);
		Obstacle z1721490444 = new Wall(1 * gridSize, 4 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z1721490444, 1721490444);
		Obstacle z1534379598 = new Wall(4 * gridSize, 1 * gridSize, new Point(1 * gridSize, 9 * gridSize));
		addToObs(z1534379598, -1534379598);
		Obstacle z1942644431 = new Wall(8 * gridSize, 1 * gridSize, new Point(1 * gridSize, 15 * gridSize));
		addToObs(z1942644431, 1942644431);
		Obstacle z535294921 = new Water(6 * gridSize, 3 * gridSize, new Point(1 * gridSize, 9 * gridSize));
		addToObs(z535294921, 535294921);
		Obstacle z185074812 = new Wall(0 * gridSize, 0 * gridSize, new Point(3 * gridSize, 1 * gridSize));
		addToObs(z185074812, -185074812);
		Obstacle z894059835 = new Wall(6 * gridSize, 0 * gridSize, new Point(3 * gridSize, 1 * gridSize));
		addToObs(z894059835, 894059835);
	}
}
