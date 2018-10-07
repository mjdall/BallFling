package tracksegments;

import android.graphics.Point;
import obstacles.*;

public class LabFive extends TrackBlueprint {
	public LabFive (Point screenDims) {
		super(screenDims, screenDims.x * 16 / 9, false);
	}

	@Override
	protected void setObs () {
		int gridSize = width / 9;
		Obstacle z1555141418 = new Water(0 * gridSize, 0 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z1555141418, -1);
		Obstacle z1706234409 = new Water(2 * gridSize, 0 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z1706234409, -1);
		Obstacle z1867750606 = new SandStone(6 * gridSize, 6 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z1867750606, 0);
		Obstacle z2046562126 = new SandStone(1 * gridSize, 10 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z2046562126, 0);
		Obstacle z1342443307 = new SandStone(1 * gridSize, 4 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z1342443307, 0);
		Obstacle z334410831 = new SandStone(6 * gridSize, 14 * gridSize, new Point(1 * gridSize, 2 * gridSize));
		addToObs(z334410831, 0);
		Obstacle z1199823454 = new SandStone(4 * gridSize, 5 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z1199823454, 0);
		Obstacle z932172235 = new SandStone(5 * gridSize, 11 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z932172235, 0);
		Obstacle z1147162332 = new SandStone(6 * gridSize, 1 * gridSize, new Point(3 * gridSize, 1 * gridSize));
		addToObs(z1147162332, 0);
		Obstacle z2121055129 = new SandStone(4 * gridSize, 1 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z2121055129, 0);
		Obstacle z2084435096 = new SandStone(7 * gridSize, 10 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z2084435096, 0);
		Obstacle z172898650 = new SandStone(8 * gridSize, 2 * gridSize, new Point(1 * gridSize, 13 * gridSize));
		addToObs(z172898650, 0);
		Obstacle z935044127 = new SandStone(3 * gridSize, 11 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z935044127, 0);
		Obstacle z22263611 = new Water(7 * gridSize, 2 * gridSize, new Point(1 * gridSize, 2 * gridSize));
		addToObs(z22263611, -1);
		Obstacle z2082671622 = new Water(0 * gridSize, 15 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z2082671622, -1);
		Obstacle z256504555 = new SandStone(5 * gridSize, 12 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z256504555, 0);
		Obstacle z1269832990 = new Water(7 * gridSize, 15 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z1269832990, -1);
		Obstacle z492228233 = new SandStone(2 * gridSize, 6 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z492228233, 0);
		Obstacle z112630952 = new Water(4 * gridSize, 11 * gridSize, new Point(1 * gridSize, 2 * gridSize));
		addToObs(z112630952, -1);
		Obstacle z772777458 = new Water(1 * gridSize, 14 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z772777458, -1);
		Obstacle z366491869 = new SandStone(5 * gridSize, 9 * gridSize, new Point(3 * gridSize, 1 * gridSize));
		addToObs(z366491869, 0);
		Obstacle z777874870 = new SandStone(5 * gridSize, 7 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z777874870, 0);
		Obstacle z2136326722 = new SandStone(2 * gridSize, 9 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z2136326722, 0);
		Obstacle z717533926 = new SandStone(2 * gridSize, 14 * gridSize, new Point(1 * gridSize, 2 * gridSize));
		addToObs(z717533926, 0);
		Obstacle z565760411 = new SandStone(1 * gridSize, 9 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z565760411, 0);
		Obstacle z1550209284 = new SandStone(0 * gridSize, 1 * gridSize, new Point(3 * gridSize, 1 * gridSize));
		addToObs(z1550209284, 0);
		Obstacle z87285209 = new Water(6 * gridSize, 0 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z87285209, -1);
		Obstacle z610998204 = new SandStone(4 * gridSize, 3 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z610998204, 0);
		Obstacle z2047329747 = new SandStone(3 * gridSize, 7 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z2047329747, 0);
		Obstacle z648129395 = new Water(7 * gridSize, 14 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z648129395, -1);
		Obstacle z1325895069 = new Water(7 * gridSize, 0 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z1325895069, -1);
		Obstacle z94438448 = new SandStone(4 * gridSize, 14 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z94438448, 0);
		Obstacle z787604761 = new SandStone(7 * gridSize, 4 * gridSize, new Point(1 * gridSize, 1 * gridSize));
		addToObs(z787604761, 0);
		Obstacle z396502654 = new Water(1 * gridSize, 2 * gridSize, new Point(1 * gridSize, 2 * gridSize));
		addToObs(z396502654, -1);
		Obstacle z215458186 = new SandStone(2 * gridSize, 12 * gridSize, new Point(2 * gridSize, 1 * gridSize));
		addToObs(z215458186, 0);
		Obstacle z1758903305 = new SandStone(0 * gridSize, 2 * gridSize, new Point(1 * gridSize, 13 * gridSize));
		addToObs(z1758903305, 0);
	}
}
