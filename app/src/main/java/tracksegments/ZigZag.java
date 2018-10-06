package tracksegments;

import android.graphics.Point;
import obstacles.*;

public class ZigZag extends TrackBlueprint {
	public ZigZag (Point screenDims) {
		super(screenDims, screenDims.x * 16 / 9, false);
	}

	@Override
	protected void setObs () {
		int gridSize = width / 9;
		Obstacle z1629438326 = new Wall(1 * gridSize, 0 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z1629438326, 0);
		Obstacle z186370060 = new Wall(1 * gridSize, 3 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z186370060, 0);
		Obstacle z2094548389 = new Wall(2 * gridSize, 4 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z2094548389, 0);
		Obstacle z261871363 = new LongGrass(3 * gridSize, 0 * gridSize, new Point(3 * gridSize, 1 * gridSize));
		addToObs(z261871363, -1);
		Obstacle z529708664 = new Wall(0 * gridSize, 15 * gridSize, new Point(3 * gridSize, 1 * gridSize));
		addToObs(z529708664, 0);
		Obstacle z1198108826 = new LongGrass(5 * gridSize, 12 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z1198108826, -1);
		Obstacle z741490676 = new LongGrass(3 * gridSize, 15 * gridSize, new Point(3 * gridSize, 1 * gridSize));
		addToObs(z741490676, -1);
		Obstacle z12583336 = new Wall(8 * gridSize, 1 * gridSize, new Point(1 * gridSize, 15 * gridSize));
		addToObs(z12583336, 0);
		Obstacle z231913052 = new LongGrass(1 * gridSize, 5 * gridSize, new Point(2 * gridSize, 5 * gridSize));
		addToObs(z231913052, -1);
		Obstacle z935044127 = new Wall(5 * gridSize, 7 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z935044127, 0);
		Obstacle z2043883641 = new Water(1 * gridSize, 1 * gridSize, new Point(2 * gridSize, 2 * gridSize));
		addToObs(z2043883641, -1);
		Obstacle z939047814 = new Wall(4 * gridSize, 6 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z939047814, 0);
		Obstacle z1337393784 = new Water(6 * gridSize, 1 * gridSize, new Point(2 * gridSize, 2 * gridSize));
		addToObs(z1337393784, -1);
		Obstacle z431358405 = new LongGrass(6 * gridSize, 11 * gridSize, new Point(2 * gridSize, 3 * gridSize));
		addToObs(z431358405, -1);
		Obstacle z2108649195 = new Wall(3 * gridSize, 5 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z2108649195, 0);
		Obstacle z777874870 = new Wall(7 * gridSize, 9 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z777874870, 0);
		Obstacle z596512160 = new LongGrass(1 * gridSize, 4 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z596512160, -1);
		Obstacle z824318977 = new LongGrass(4 * gridSize, 7 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z824318977, -1);
		Obstacle z1334475606 = new Wall(6 * gridSize, 0 * gridSize, new Point(3 * gridSize, 1 * gridSize));
		addToObs(z1334475606, -1);
		Obstacle z1550209284 = new LongGrass(3 * gridSize, 6 * gridSize, new Point(1 * gridSize, 3 * gridSize));
		addToObs(z1550209284, -1);
		Obstacle z87285209 = new Wall(6 * gridSize, 10 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z87285209, 0);
		Obstacle z1942644431 = new Wall(0 * gridSize, 0 * gridSize, new Point(1 * gridSize, 15 * gridSize));
		addToObs(z1942644431, 0);
		Obstacle z636718843 = new LongGrass(1 * gridSize, 10 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z636718843, -1);
		Obstacle z445051664 = new Wall(7 * gridSize, 3 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z445051664, 0);
		Obstacle z1051754482 = new Wall(4 * gridSize, 12 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z1051754482, 0);
		Obstacle z1349277885 = new Wall(5 * gridSize, 11 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z1349277885, 0);
		Obstacle z1775282496 = new LongGrass(7 * gridSize, 10 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z1775282496, -1);
		Obstacle z1026648998 = new Wall(6 * gridSize, 15 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z1026648998, 0);
		Obstacle z1267032395 = new LongGrass(7 * gridSize, 14 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z1267032395, -1);
	}
}
