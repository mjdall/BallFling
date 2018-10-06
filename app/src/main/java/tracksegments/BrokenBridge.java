package tracksegments;

import android.graphics.Point;
import obstacles.*;

public class BrokenBridge extends TrackBlueprint {
    public BrokenBridge (Point screenDims) {
        super(screenDims, screenDims.x * 32 / 18, false);
    }

    @Override
    protected void setObs () {
        int gridSize = width / 18;
        Obstacle z1076285081 = new Wall(4 * gridSize, 0 * gridSize, new Point(1 * gridSize, 4 * gridSize));
        addToObs(z1076285081, 0);
        Obstacle z1176285081 = new Water(4 * gridSize, 4 * gridSize, new Point(1 * gridSize, 1 * gridSize));
        addToObs(z1176285081, 0);
        Obstacle z1257952979 = new Wall(5 * gridSize, 0 * gridSize, new Point(1 * gridSize, 5 * gridSize));
        addToObs(z1257952979, 0);
        Obstacle z1257953979 = new Wall(4 * gridSize, 8 * gridSize, new Point(1 * gridSize, 20 * gridSize));
        addToObs(z1257953979, 0);
        Obstacle z1247953979 = new Wall(5 * gridSize, 8 * gridSize, new Point(1 * gridSize, 19 * gridSize));
        addToObs(z1247953979, 0);
        Obstacle z84877471 = new Wall(12 * gridSize, 0 * gridSize, new Point(1 * gridSize, 23 * gridSize));
        addToObs(z84877471, 0);
        Obstacle z2118736131 = new Wall(13 * gridSize, 0 * gridSize, new Point(1 * gridSize, 32 * gridSize));
        addToObs(z2118736131, 0);
        Obstacle z1831708068 = new Wall(5 * gridSize, 7 * gridSize, new Point(3 * gridSize, 1 * gridSize));
        addToObs(z1831708068, 0);
        Obstacle z1410242102 = new Wall(5 * gridSize, 29 * gridSize, new Point(1 * gridSize, 3 * gridSize));
        addToObs(z1410242102, 0);
        Obstacle z101678674 = new Wall(4 * gridSize, 30 * gridSize, new Point(1 * gridSize, 2 * gridSize));
        addToObs(z101678674, 0);
        Obstacle z2071402480 = new Wall(6 * gridSize, 4 * gridSize, new Point(1 * gridSize, 2 * gridSize));
        addToObs(z2071402480, 0);
        Obstacle z919733152 = new Wall(12 * gridSize, 26 * gridSize, new Point(1 * gridSize, 6 * gridSize));
        addToObs(z919733152, 0);
        Obstacle z1759492962 = new Water(4 * gridSize, 5 * gridSize, new Point(2 * gridSize, 2 * gridSize));
        addToObs(z1759492962, -1);
        Obstacle z612630118 = new Water(7 * gridSize, 5 * gridSize, new Point(1 * gridSize, 2 * gridSize));
        addToObs(z612630118, -1);
        Obstacle z1497050908 = new Water(6 * gridSize, 27 * gridSize, new Point(2 * gridSize, 3 * gridSize));
        addToObs(z1497050908, -20);
        Obstacle z1451514507 = new Water(8 * gridSize, 15 * gridSize, new Point(2 * gridSize, 3 * gridSize));
        addToObs(z1451514507, -10);
        Obstacle z926370429 = new Water(6 * gridSize, 6 * gridSize, new Point(1 * gridSize, 1 * gridSize));
        addToObs(z926370429, -1);
        Obstacle z551743337 = new Water(14 * gridSize, 0 * gridSize, new Point(4 * gridSize, 32 * gridSize));
        addToObs(z551743337, -1);
        Obstacle z650401522 = new Water(10 * gridSize, 23 * gridSize, new Point(3 * gridSize, 3 * gridSize));
        addToObs(z650401522, -20);
        Obstacle z758810138 = new Water(8 * gridSize, 6 * gridSize, new Point(1 * gridSize, 2 * gridSize));
        addToObs(z758810138, -20);
        Obstacle z1192424850 = new Water(0 * gridSize, 0 * gridSize, new Point(4 * gridSize, 32 * gridSize));
        addToObs(z1192424850, -1);
        Obstacle z112619603 = new Water(9 * gridSize, 7 * gridSize, new Point(1 * gridSize, 1 * gridSize));
        addToObs(z112619603, -20);
        Obstacle z203015733 = new Water(5 * gridSize, 27 * gridSize, new Point(1 * gridSize, 2 * gridSize));
        addToObs(z203015733, -1);
        Obstacle z141332063 = new Water(4 * gridSize, 28 * gridSize, new Point(1 * gridSize, 2 * gridSize));
        addToObs(z141332063, -1);
        Obstacle z1634132110 = new Water(4 * gridSize, 7 * gridSize, new Point(1 * gridSize, 1 * gridSize));
        addToObs(z1634132110, -1);
        Obstacle z1734132110 = new GroundShadow(7 * gridSize, 15 * gridSize, new Point(1 * gridSize, 3 * gridSize));
        addToObs(z1734132110, -5);
        Obstacle z1774132110 = new GroundShadow(7 * gridSize, 18 * gridSize, new Point(3 * gridSize, 1 * gridSize));
        addToObs(z1774132110, -5);
        Obstacle z1754132110 = new GroundShadowCover(7 * gridSize, 14 * gridSize, new Point(3 * gridSize, 1 * gridSize));
        addToObs(z1754132110, 100);
        Obstacle z1754132111 = new GroundShadowCover(10 * gridSize, 17 * gridSize, new Point(1 * gridSize, 2 * gridSize));
        addToObs(z1754132111, 100);
        Obstacle z1774152110 = new GroundShadow(6 * gridSize, 30 * gridSize, new Point(2 * gridSize, 1 * gridSize));
        addToObs(z1774152110, -10);
        Obstacle z1784132111 = new GroundShadowCover(8 * gridSize, 29 * gridSize, new Point(1 * gridSize, 2 * gridSize));
        addToObs(z1784132111, 100);
        Obstacle z1774052110 = new GroundShadow(9 * gridSize, 26 * gridSize, new Point(3 * gridSize, 1 * gridSize));
        addToObs(z1774052110, -10);
        Obstacle z1224152110 = new GroundShadow(9 * gridSize, 23 * gridSize, new Point(1 * gridSize, 3 * gridSize));
        addToObs(z1224152110, -10);
        Obstacle z1784132221 = new GroundShadowCover(9 * gridSize, 22 * gridSize, new Point(3 * gridSize, 1 * gridSize));
        addToObs(z1784132221, 100);
        Obstacle z1774662110 = new GroundShadow(7 * gridSize, 8 * gridSize, new Point(3 * gridSize, 1 * gridSize));
        addToObs(z1774662110, -10);
        Obstacle z1884132221 = new GroundShadowCover(10 * gridSize, 7 * gridSize, new Point(1 * gridSize, 2 * gridSize));
        addToObs(z1884132221, 100);
        Obstacle z1664132111 = new GroundShadowCover(7 * gridSize, 17 * gridSize, new Point(1 * gridSize, 2 * gridSize));
        addToObs(z1664132111, 100);

    }
}