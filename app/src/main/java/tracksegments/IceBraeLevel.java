package tracksegments;

import android.graphics.Point;
import obstacles.*;

public class IceBraeLevel extends TrackBlueprint {
    public IceBraeLevel (Point screenDims) {
        super(screenDims, screenDims.x * 64 / 36, false);
    }

    @Override
    protected void setObs () {
        int gridSize = width / 36;
        Obstacle z1555141428 = new SnowyGround(0 * gridSize, 0 * gridSize, new Point(36 * gridSize, 64 * gridSize)); //23,19
        addToObs(z1555141428, -20);
        Obstacle z1555141418 = new Water(23 * gridSize, 19 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //23,19
        addToObs(z1555141418, 0);
        Obstacle z1746322628 = new Water(13 * gridSize, 37 * gridSize, new Point(8 * gridSize, 9 * gridSize)); //13,37
        addToObs(z1746322628, 0);
        Obstacle z492906865 = new Water(5 * gridSize, 45 * gridSize, new Point(3 * gridSize, 8 * gridSize)); //5,45
        addToObs(z492906865, 0);
        Obstacle z41987133 = new Water(24 * gridSize, 10 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //24,10
        addToObs(z41987133, 0);
        Obstacle z1344153667 = new Water(20 * gridSize, 4 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //20,4
        addToObs(z1344153667, 0);
        Obstacle z901088060 = new Water(27 * gridSize, 52 * gridSize, new Point(3 * gridSize, 2 * gridSize)); //27,52
        addToObs(z901088060, 0);
        Obstacle z453764107 = new Water(33 * gridSize, 54 * gridSize, new Point(1 * gridSize, 8 * gridSize)); //33,54
        addToObs(z453764107, 0);
        Obstacle z277630036 = new Water(21 * gridSize, 5 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //21,5
        addToObs(z277630036, 0);
        Obstacle z1067673699 = new Water(1 * gridSize, 0 * gridSize, new Point(2 * gridSize, 14 * gridSize)); //1,0
        addToObs(z1067673699, 0);
        Obstacle z1722044088 = new Water(8 * gridSize, 43 * gridSize, new Point(2 * gridSize, 7 * gridSize)); //8,43
        addToObs(z1722044088, 0);
        Obstacle z1364335840 = new Water(13 * gridSize, 46 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //13,46
        addToObs(z1364335840, 0);
        Obstacle z458209718 = new Water(31 * gridSize, 59 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //31,59
        addToObs(z458209718, 0);
        Obstacle z903425002 = new Water(12 * gridSize, 39 * gridSize, new Point(1 * gridSize, 8 * gridSize)); //12,39
        addToObs(z903425002, 0);
        Obstacle z38997041 = new Water(25 * gridSize, 54 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //25,54
        addToObs(z38997041, 0);
        Obstacle z581822651 = new Water(17 * gridSize, 8 * gridSize, new Point(7 * gridSize, 5 * gridSize)); //17,8
        addToObs(z581822651, 0);
        Obstacle z460332480 = new Water(11 * gridSize, 41 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //11,41
        addToObs(z460332480, 0);
        Obstacle z1146524636 = new Water(13 * gridSize, 3 * gridSize, new Point(7 * gridSize, 3 * gridSize)); //13,3
        addToObs(z1146524636, 0);
        Obstacle z1079567948 = new Water(3 * gridSize, 47 * gridSize, new Point(1 * gridSize, 14 * gridSize)); //3,47
        addToObs(z1079567948, 0);
        Obstacle z970759791 = new Water(21 * gridSize, 23 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //21,23
        addToObs(z970759791, 0);
        Obstacle z123961153 = new Water(6 * gridSize, 53 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //6,53
        addToObs(z123961153, 0);
        Obstacle z2121652658 = new Water(4 * gridSize, 46 * gridSize, new Point(1 * gridSize, 13 * gridSize)); //4,46
        addToObs(z2121652658, 0);
        Obstacle z741040748 = new Water(28 * gridSize, 54 * gridSize, new Point(4 * gridSize, 4 * gridSize)); //28,54
        addToObs(z741040748, 0);
        Obstacle z1389598598 = new Water(34 * gridSize, 0 * gridSize, new Point(1 * gridSize, 63 * gridSize)); //34,0
        addToObs(z1389598598, 0);
        Obstacle z1982075693 = new Water(15 * gridSize, 6 * gridSize, new Point(8 * gridSize, 2 * gridSize)); //15,6
        addToObs(z1982075693, 0);
        Obstacle z746337236 = new Water(16 * gridSize, 46 * gridSize, new Point(4 * gridSize, 1 * gridSize)); //16,46
        addToObs(z746337236, 0);
        Obstacle z1185739919 = new Water(5 * gridSize, 53 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //5,53
        addToObs(z1185739919, 0);
        Obstacle z890369393 = new Water(32 * gridSize, 0 * gridSize, new Point(1 * gridSize, 4 * gridSize)); //32,0
        addToObs(z890369393, 0);
        Obstacle z817156127 = new Water(9 * gridSize, 3 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //9,3
        addToObs(z817156127, 0);
        Obstacle z602172742 = new Water(1 * gridSize, 14 * gridSize, new Point(1 * gridSize, 24 * gridSize)); //1,14
        addToObs(z602172742, 0);
        Obstacle z1156060817 = new Water(14 * gridSize, 6 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //14,6
        addToObs(z1156060817, 0);
        Obstacle z1612799757 = new Water(15 * gridSize, 8 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //15,8
        addToObs(z1612799757, 0);
        Obstacle z16631533 = new Water(21 * gridSize, 41 * gridSize, new Point(1 * gridSize, 4 * gridSize)); //21,41
        addToObs(z16631533, 0);
        Obstacle z259052296 = new Water(26 * gridSize, 54 * gridSize, new Point(2 * gridSize, 2 * gridSize)); //26,54
        addToObs(z259052296, 0);
        Obstacle z951927688 = new Water(15 * gridSize, 1 * gridSize, new Point(2 * gridSize, 2 * gridSize)); //15,1
        addToObs(z951927688, 0);
        Obstacle z374691195 = new Water(33 * gridSize, 20 * gridSize, new Point(1 * gridSize, 17 * gridSize)); //33,20
        addToObs(z374691195, 0);
        Obstacle z1635979049 = new Water(15 * gridSize, 22 * gridSize, new Point(6 * gridSize, 7 * gridSize)); //15,22
        addToObs(z1635979049, 0);
        Obstacle z2012232656 = new Water(1 * gridSize, 63 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //1,63
        addToObs(z2012232656, 0);
        Obstacle z845251570 = new Water(3 * gridSize, 0 * gridSize, new Point(1 * gridSize, 8 * gridSize)); //3,0
        addToObs(z845251570, 0);
        Obstacle z819464928 = new Water(4 * gridSize, 3 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //4,3
        addToObs(z819464928, 0);
        Obstacle z907686613 = new Water(16 * gridSize, 8 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //16,8
        addToObs(z907686613, 0);
        Obstacle z842763328 = new Water(32 * gridSize, 55 * gridSize, new Point(1 * gridSize, 6 * gridSize)); //32,55
        addToObs(z842763328, 0);
        Obstacle z1207769090 = new Water(10 * gridSize, 48 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //10,48
        addToObs(z1207769090, 0);
        Obstacle z2094777842 = new Water(28 * gridSize, 51 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //28,51
        addToObs(z2094777842, 0);
        Obstacle z1872690908 = new Water(17 * gridSize, 18 * gridSize, new Point(8 * gridSize, 1 * gridSize)); //17,18
        addToObs(z1872690908, 0);
        Obstacle z984849496 = new Water(4 * gridSize, 4 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //4,4
        addToObs(z984849496, 0);
        Obstacle z1267303026 = new Water(4 * gridSize, 0 * gridSize, new Point(11 * gridSize, 3 * gridSize)); //4,0
        addToObs(z1267303026, 0);
        Obstacle z1524616184 = new Water(14 * gridSize, 25 * gridSize, new Point(1 * gridSize, 5 * gridSize)); //14,25
        addToObs(z1524616184, 0);
        Obstacle z2114694096 = new Water(30 * gridSize, 53 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //30,53
        addToObs(z2114694096, 0);
        Obstacle z497232894 = new Water(32 * gridSize, 24 * gridSize, new Point(1 * gridSize, 7 * gridSize)); //32,24
        addToObs(z497232894, 0);
        Obstacle z1885677829 = new Water(17 * gridSize, 47 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //17,47
        addToObs(z1885677829, 0);
        Obstacle z346786882 = new Water(14 * gridSize, 35 * gridSize, new Point(6 * gridSize, 2 * gridSize)); //14,35
        addToObs(z346786882, 0);
        Obstacle z781979064 = new Water(6 * gridSize, 44 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //6,44
        addToObs(z781979064, 0);
        Obstacle z105707421 = new Water(30 * gridSize, 58 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //30,58
        addToObs(z105707421, 0);
        Obstacle z1277181632 = new Water(17 * gridSize, 2 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //17,2
        addToObs(z1277181632, 0);
        Obstacle z1787993765 = new Water(21 * gridSize, 22 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //21,22
        addToObs(z1787993765, 0);
        Obstacle z1209271683 = new Water(13 * gridSize, 36 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //13,36
        addToObs(z1209271683, 0);
        Obstacle z1678784611 = new Water(15 * gridSize, 29 * gridSize, new Point(5 * gridSize, 1 * gridSize)); //15,29
        addToObs(z1678784611, 0);
        Obstacle z985922986 = new Water(8 * gridSize, 50 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //8,50
        addToObs(z985922986, 0);
        Obstacle z1927979108 = new Water(10 * gridSize, 42 * gridSize, new Point(2 * gridSize, 6 * gridSize)); //10,42
        addToObs(z1927979108, 0);
        Obstacle z729660830 = new Water(11 * gridSize, 3 * gridSize, new Point(2 * gridSize, 2 * gridSize)); //11,3
        addToObs(z729660830, 0);
        Obstacle z217875399 = new Water(1 * gridSize, 38 * gridSize, new Point(2 * gridSize, 25 * gridSize)); //1,38
        addToObs(z217875399, 0);
        Obstacle z273303562 = new Water(16 * gridSize, 19 * gridSize, new Point(7 * gridSize, 3 * gridSize)); //16,19
        addToObs(z273303562, 0);
        Obstacle z1286783263 = new Water(26 * gridSize, 53 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //26,53
        addToObs(z1286783263, 0);
        Obstacle z1874154731 = new Water(27 * gridSize, 56 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //27,56
        addToObs(z1874154731, 0);
        Obstacle z814182190 = new Water(33 * gridSize, 0 * gridSize, new Point(1 * gridSize, 15 * gridSize)); //33,0
        addToObs(z814182190, 0);
        Obstacle z1187252184 = new SlowdownIce(6 * gridSize, 6 * gridSize, new Point(8 * gridSize, 1 * gridSize)); //6,6
        addToObs(z1187252184, 0);
        Obstacle z528006386 = new SlowdownIce(3 * gridSize, 61 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //3,61
        addToObs(z528006386, 0);
        Obstacle z1147162332 = new SlowdownIce(13 * gridSize, 9 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //13,9
        addToObs(z1147162332, 0);
        Obstacle z1029847827 = new SlowdownIce(8 * gridSize, 51 * gridSize, new Point(1 * gridSize, 4 * gridSize)); //8,51
        addToObs(z1029847827, 0);
        Obstacle z686967007 = new SlowdownIce(9 * gridSize, 50 * gridSize, new Point(1 * gridSize, 4 * gridSize)); //9,50
        addToObs(z686967007, 0);
        Obstacle z1645100802 = new SlowdownIce(12 * gridSize, 47 * gridSize, new Point(5 * gridSize, 1 * gridSize)); //12,47
        addToObs(z1645100802, 0);
        Obstacle z353471608 = new SlowdownIce(12 * gridSize, 48 * gridSize, new Point(6 * gridSize, 1 * gridSize)); //12,48
        addToObs(z353471608, 0);
        Obstacle z738320688 = new SlowdownIce(10 * gridSize, 49 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //10,49
        addToObs(z738320688, 0);
        Obstacle z1202345228 = new SlowdownIce(7 * gridSize, 53 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //7,53
        addToObs(z1202345228, 0);
        Obstacle z1350764605 = new SlowdownIce(5 * gridSize, 4 * gridSize, new Point(1 * gridSize, 5 * gridSize)); //5,4
        addToObs(z1350764605, 0);
        Obstacle z1871858955 = new SlowdownIce(6 * gridSize, 54 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //6,54
        addToObs(z1871858955, 0);
        Obstacle z1680879898 = new SlowdownIce(11 * gridSize, 48 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //11,48
        addToObs(z1680879898, 0);
        Obstacle z365270375 = new SlowdownIce(4 * gridSize, 59 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //4,59
        addToObs(z365270375, 0);
        Obstacle z1798905968 = new SlowdownIce(6 * gridSize, 7 * gridSize, new Point(9 * gridSize, 1 * gridSize)); //6,7
        addToObs(z1798905968, 0);
        Obstacle z641692879 = new SlowdownIce(6 * gridSize, 4 * gridSize, new Point(5 * gridSize, 1 * gridSize)); //6,4
        addToObs(z641692879, 0);
        Obstacle z1002591512 = new SlowdownIce(4 * gridSize, 5 * gridSize, new Point(1 * gridSize, 6 * gridSize)); //4,5
        addToObs(z1002591512, 0);
        Obstacle z435507010 = new SlowdownIce(6 * gridSize, 5 * gridSize, new Point(7 * gridSize, 1 * gridSize)); //6,5
        addToObs(z435507010, 0);
        Obstacle z185074812 = new SlowdownIce(6 * gridSize, 3 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //6,3
        addToObs(z185074812, 0);
        Obstacle z980858726 = new SlowdownIce(10 * gridSize, 8 * gridSize, new Point(5 * gridSize, 1 * gridSize)); //10,8
        addToObs(z980858726, 0);
        Obstacle z1437754329 = new SlowdownIce(3 * gridSize, 8 * gridSize, new Point(1 * gridSize, 5 * gridSize)); //3,8
        addToObs(z1437754329, 0);
        Obstacle z1616472704 = new SlowdownIce(14 * gridSize, 46 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //14,46
        addToObs(z1616472704, 0);
        Obstacle z947111945 = new SlowdownIce(12 * gridSize, 49 * gridSize, new Point(5 * gridSize, 1 * gridSize)); //12,49
        addToObs(z947111945, 0);
        Obstacle z1144748400 = new SlowdownIce(15 * gridSize, 10 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //15,10
        addToObs(z1144748400, 0);
        Obstacle z1672765444 = new SlowdownIce(5 * gridSize, 56 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //5,56
        addToObs(z1672765444, 0);
        Obstacle z971884253 = new Bridge(16 * gridSize, 13 * gridSize, new Point(10 * gridSize, 5 * gridSize)); //16,13
        addToObs(z971884253, 0);
        Obstacle z482369153 = new Bridge(21 * gridSize, 47 * gridSize, new Point(7 * gridSize, 1 * gridSize)); //21,47
        addToObs(z482369153, 0);
        Obstacle z1183576218 = new Bridge(13 * gridSize, 30 * gridSize, new Point(8 * gridSize, 5 * gridSize)); //13,30
        addToObs(z1183576218, 0);
        Obstacle z1155364458 = new Bridge(22 * gridSize, 46 * gridSize, new Point(5 * gridSize, 1 * gridSize)); //22,46
        addToObs(z1155364458, 0);
        Obstacle z752669265 = new Bridge(20 * gridSize, 48 * gridSize, new Point(9 * gridSize, 1 * gridSize)); //20,48
        addToObs(z752669265, 0);
        Obstacle z2150368 = new Bridge(23 * gridSize, 45 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //23,45
        addToObs(z2150368, 0);
        Obstacle z260689189 = new Bridge(21 * gridSize, 54 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //21,54
        addToObs(z260689189, 0);
        Obstacle z1611148544 = new Bridge(19 * gridSize, 52 * gridSize, new Point(6 * gridSize, 1 * gridSize)); //19,52
        addToObs(z1611148544, 0);
        Obstacle z1177096297 = new Bridge(24 * gridSize, 44 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //24,44
        addToObs(z1177096297, 0);
        Obstacle z1517870270 = new Bridge(19 * gridSize, 49 * gridSize, new Point(9 * gridSize, 1 * gridSize)); //19,49
        addToObs(z1517870270, 0);
        Obstacle z1417584264 = new Bridge(18 * gridSize, 50 * gridSize, new Point(9 * gridSize, 1 * gridSize)); //18,50
        addToObs(z1417584264, 0);
        Obstacle z1722014611 = new Bridge(18 * gridSize, 51 * gridSize, new Point(8 * gridSize, 1 * gridSize)); //18,51
        addToObs(z1722014611, 0);
        Obstacle z1807953799 = new Bridge(20 * gridSize, 53 * gridSize, new Point(4 * gridSize, 1 * gridSize)); //20,53
        addToObs(z1807953799, 0);
        Obstacle z915842245 = new IceWall(28 * gridSize, 24 * gridSize, new Point(1 * gridSize, 4 * gridSize)); //28,24
        addToObs(z915842245, 0);
        Obstacle z960050706 = new IceWall(2 * gridSize, 14 * gridSize, new Point(1 * gridSize, 4 * gridSize)); //2,14
        addToObs(z960050706, 0);
        Obstacle z571804444 = new IceWall(5 * gridSize, 13 * gridSize, new Point(1 * gridSize, 4 * gridSize)); //5,13
        addToObs(z571804444, 0);
        Obstacle z1000960776 = new IceWall(20 * gridSize, 46 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //20,46
        addToObs(z1000960776, 0);
        Obstacle z983345036 = new IceWall(26 * gridSize, 23 * gridSize, new Point(1 * gridSize, 4 * gridSize)); //26,23
        addToObs(z983345036, 0);
        Obstacle z1736523580 = new IceWall(26 * gridSize, 51 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //26,51
        addToObs(z1736523580, 0);
        Obstacle z287209190 = new IceWall(18 * gridSize, 48 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //18,48
        addToObs(z287209190, 0);
        Obstacle z2028827245 = new IceWall(16 * gridSize, 50 * gridSize, new Point(2 * gridSize, 2 * gridSize)); //16,50
        addToObs(z2028827245, 0);
        Obstacle z217632944 = new IceWall(29 * gridSize, 25 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //29,25
        addToObs(z217632944, 0);
        Obstacle z2046901117 = new IceWall(3 * gridSize, 34 * gridSize, new Point(3 * gridSize, 3 * gridSize)); //3,34
        addToObs(z2046901117, 0);
        Obstacle z112630952 = new IceWall(21 * gridSize, 45 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //21,45
        addToObs(z112630952, 0);
        Obstacle z1729747916 = new IceWall(28 * gridSize, 49 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //28,49
        addToObs(z1729747916, 0);
        Obstacle z557427743 = new IceWall(27 * gridSize, 50 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //27,50
        addToObs(z557427743, 0);
        Obstacle z1945200969 = new IceWall(26 * gridSize, 2 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //26,2
        addToObs(z1945200969, 0);
        Obstacle z717533926 = new IceWall(23 * gridSize, 54 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //23,54
        addToObs(z717533926, 0);
        Obstacle z466451752 = new IceWall(3 * gridSize, 13 * gridSize, new Point(1 * gridSize, 5 * gridSize)); //3,13
        addToObs(z466451752, 0);
        Obstacle z486562440 = new IceWall(25 * gridSize, 24 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //25,24
        addToObs(z486562440, 0);
        Obstacle z648129395 = new IceWall(23 * gridSize, 55 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //23,55
        addToObs(z648129395, 0);
        Obstacle z1093434779 = new IceWall(27 * gridSize, 23 * gridSize, new Point(1 * gridSize, 5 * gridSize)); //27,23
        addToObs(z1093434779, 0);
        Obstacle z1337821362 = new IceWall(10 * gridSize, 24 * gridSize, new Point(2 * gridSize, 4 * gridSize)); //10,24
        addToObs(z1337821362, 0);
        Obstacle z445051664 = new IceWall(4 * gridSize, 33 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //4,33
        addToObs(z445051664, 0);
        Obstacle z954410619 = new IceWall(25 * gridSize, 1 * gridSize, new Point(4 * gridSize, 1 * gridSize)); //25,1
        addToObs(z954410619, 0);
        Obstacle z97889252 = new IceWall(22 * gridSize, 44 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //22,44
        addToObs(z97889252, 0);
        Obstacle z866358686 = new IceWall(17 * gridSize, 49 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //17,49
        addToObs(z866358686, 0);
        Obstacle z41745555 = new IceWall(21 * gridSize, 55 * gridSize, new Point(2 * gridSize, 2 * gridSize)); //21,55
        addToObs(z41745555, 0);
        Obstacle z1881349304 = new IceWall(24 * gridSize, 53 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //24,53
        addToObs(z1881349304, 0);
        Obstacle z141445603 = new IceWall(24 * gridSize, 0 * gridSize, new Point(6 * gridSize, 1 * gridSize)); //24,0
        addToObs(z141445603, 0);
        Obstacle z1310919806 = new IceWall(12 * gridSize, 25 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //12,25
        addToObs(z1310919806, 0);
        Obstacle z1357681303 = new IceWall(19 * gridSize, 47 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //19,47
        addToObs(z1357681303, 0);
        Obstacle z1679617135 = new IceWall(29 * gridSize, 47 * gridSize, new Point(2 * gridSize, 2 * gridSize)); //29,47
        addToObs(z1679617135, 0);
        Obstacle z513286419 = new IceWall(25 * gridSize, 52 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //25,52
        addToObs(z513286419, 0);
        Obstacle z1438777355 = new IceWall(4 * gridSize, 12 * gridSize, new Point(1 * gridSize, 6 * gridSize)); //4,12
        addToObs(z1438777355, 0);
        Obstacle z1498468029 = new IceWall(23 * gridSize, 42 * gridSize, new Point(2 * gridSize, 2 * gridSize)); //23,42
        addToObs(z1498468029, 0);
        Obstacle z1679020768 = new IceWall(9 * gridSize, 26 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //9,26
        addToObs(z1679020768, 0);
    }
}
