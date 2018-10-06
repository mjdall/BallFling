package tracksegments;

import android.graphics.Point;
import obstacles.*;

public class OceanPlaza extends TrackBlueprint {
	public OceanPlaza (Point screenDims) {
		super(screenDims, screenDims.x * 16 / 9, false);
	}

	@Override
	protected void setObs () {
		int gridSize = width / 9;
		Obstacle z1054916419 = new Wall(1 * gridSize, 7 * gridSize, new Point(2 * gridSize, 2 * gridSize));
		addToObs(z1054916419, 0);
		Obstacle z261871363 = new Water(8 * gridSize, 10 * gridSize, new Point(1 * gridSize, 3 * gridSize));
		addToObs(z261871363, 0);
		Obstacle z529708664 = new Wall(3 * gridSize, 4 * gridSize, new Point(3 * gridSize, 1 * gridSize));
		addToObs(z529708664, 0);
		Obstacle z1871700805 = new LongGrass(6 * gridSize, 13 * gridSize, new Point(2 * gridSize, 2 * gridSize));
		addToObs(z1871700805, 0);
		Obstacle z26638581 = new Water(0 * gridSize, 3 * gridSize, new Point(1 * gridSize, 3 * gridSize));
		addToObs(z26638581, 0);
		Obstacle z225731262 = new Wall(0 * gridSize, 6 * gridSize, new Point(1 * gridSize, 4 * gridSize));
		addToObs(z225731262, 0);
		Obstacle z255480459 = new LongGrass(3 * gridSize, 9 * gridSize, new Point(3 * gridSize, 2 * gridSize));
		addToObs(z255480459, 0);
		Obstacle z244695133 = new Wall(3 * gridSize, 11 * gridSize, new Point(3 * gridSize, 1 * gridSize));
		addToObs(z244695133, 0);
		Obstacle z251198698 = new LongGrass(1 * gridSize, 6 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z251198698, 0);
		Obstacle z814604357 = new LongGrass(1 * gridSize, 1 * gridSize, new Point(2 * gridSize, 2 * gridSize));
		addToObs(z814604357, 0);
		Obstacle z852685323 = new Water(8 * gridSize, 3 * gridSize, new Point(1 * gridSize, 3 * gridSize));
		addToObs(z852685323, 0);
		Obstacle z682222874 = new LongGrass(6 * gridSize, 6 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z682222874, 0);
		Obstacle z2061554731 = new LongGrass(6 * gridSize, 1 * gridSize, new Point(2 * gridSize, 2 * gridSize));
		addToObs(z2061554731, 0);
		Obstacle z255642902 = new Wall(8 * gridSize, 6 * gridSize, new Point(1 * gridSize, 4 * gridSize));
		addToObs(z255642902, 0);
		Obstacle z1576185211 = new Wall(8 * gridSize, 13 * gridSize, new Point(1 * gridSize, 3 * gridSize));
		addToObs(z1576185211, 0);
		Obstacle z1993438508 = new LongGrass(1 * gridSize, 13 * gridSize, new Point(2 * gridSize, 2 * gridSize));
		addToObs(z1993438508, 0);
		Obstacle z2136326722 = new Wall(6 * gridSize, 15 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z2136326722, 0);
		Obstacle z717533926 = new Wall(1 * gridSize, 0 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z717533926, 0);
		Obstacle z67241031 = new Wall(0 * gridSize, 13 * gridSize, new Point(1 * gridSize, 3 * gridSize));
		addToObs(z67241031, 0);
		Obstacle z272329440 = new Wall(8 * gridSize, 1 * gridSize, new Point(1 * gridSize, 2 * gridSize));
		addToObs(z272329440, 0);
		Obstacle z1550404388 = new Wall(0 * gridSize, 0 * gridSize, new Point(1 * gridSize, 3 * gridSize));
		addToObs(z1550404388, 0);
		Obstacle z840353964 = new Wall(6 * gridSize, 7 * gridSize, new Point(2 * gridSize, 2 * gridSize));
		addToObs(z840353964, 0);
		Obstacle z703281155 = new Wall(6 * gridSize, 0 * gridSize, new Point(3 * gridSize, 1 * gridSize));
		addToObs(z703281155, 0);
		Obstacle z507531025 = new Wall(1 * gridSize, 15 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z507531025, 0);
		Obstacle z661379941 = new Water(0 * gridSize, 10 * gridSize, new Point(1 * gridSize, 3 * gridSize));
		addToObs(z661379941, 0);

		Obstacle iceBack = new Ice(00.0, 0.0, new Point(width, height));
		addToObs(iceBack, MIN_PRIORITY);
	}
}
