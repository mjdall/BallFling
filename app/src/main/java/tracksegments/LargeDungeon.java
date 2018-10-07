package tracksegments;

import android.graphics.Point;
import obstacles.*;

public class LargeDungeon extends TrackBlueprint {
    public LargeDungeon (Point screenDims) {
        super(screenDims, screenDims.x * 96 / 27, false);
    }

    @Override
    protected void setObs () {
        int gridSize = width / 27;
        Obstacle z1660224195 = new Wall(0 * gridSize, 22 * gridSize, new Point(1 * gridSize, 55 * gridSize)); //0,22
        addToObs(z1660224195, 0);
//        Obstacle z1706975409 = new Wall(1 * gridSize, 25 * gridSize, new Point(25 * gridSize, 54 * gridSize)); //1,25
//        addToObs(z1706975409, 0);
        Obstacle z651261696 = new Wall(26 * gridSize, 56 * gridSize, new Point(1 * gridSize, 21 * gridSize)); //26,56
        addToObs(z651261696, 0);
        Obstacle z1212796495 = new Wall(1 * gridSize, 68 * gridSize, new Point(11 * gridSize, 2 * gridSize)); //1,68
        addToObs(z1212796495, 0);
        Obstacle z2078612921 = new Wall(1 * gridSize, 92 * gridSize, new Point(5 * gridSize, 1 * gridSize)); //1,92
        addToObs(z2078612921, 0);
        Obstacle z535288244 = new Wall(21 * gridSize, 92 * gridSize, new Point(5 * gridSize, 1 * gridSize)); //21,92
        addToObs(z535288244, 0);
        Obstacle z413659582 = new Wall(4 * gridSize, 64 * gridSize, new Point(11 * gridSize, 1 * gridSize)); //4,64
        addToObs(z413659582, 0);
        Obstacle z599666674 = new Wall(1 * gridSize, 22 * gridSize, new Point(5 * gridSize, 3 * gridSize)); //1,22
        addToObs(z599666674, 0);
        Obstacle z999661755 = new SlowdownIce(23 * gridSize, 73 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //23,73
        addToObs(z999661755, 0);
        Obstacle z1793329587 = new Wall(19 * gridSize, 78 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //19,78
        addToObs(z1793329587, 0);
        Obstacle z1969494826 = new Wall(22 * gridSize, 15 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //22,15
        addToObs(z1969494826, 0);
        Obstacle z2118697195 = new Wall(3 * gridSize, 74 * gridSize, new Point(4 * gridSize, 1 * gridSize)); //3,74
        addToObs(z2118697195, 0);
        Obstacle z1228363804 = new SlowdownIce(3 * gridSize, 72 * gridSize, new Point(4 * gridSize, 1 * gridSize)); //3,72
        addToObs(z1228363804, 0);
        Obstacle z1334729981 = new SlowdownIce(18 * gridSize, 78 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //18,78
        addToObs(z1334729981, 0);
        Obstacle z725035850 = new Wall(15 * gridSize, 64 * gridSize, new Point(1 * gridSize, 4 * gridSize)); //15,64
        addToObs(z725035850, 0);
        Obstacle z1527397973 = new SlowdownIce(21 * gridSize, 72 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //21,72
        addToObs(z1527397973, 0);
        Obstacle z1607460049 = new SlowdownIce(3 * gridSize, 73 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //3,73
        addToObs(z1607460049, 0);
        Obstacle z1228924654 = new Wall(19 * gridSize, 40 * gridSize, new Point(7 * gridSize, 6 * gridSize)); //19,40
        addToObs(z1228924654, 0);
        Obstacle z1541072907 = new Wall(17 * gridSize, 57 * gridSize, new Point(4 * gridSize, 3 * gridSize)); //17,57
        addToObs(z1541072907, 0);
        Obstacle z1699811894 = new Wall(21 * gridSize, 74 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //21,74
        addToObs(z1699811894, 0);
        Obstacle z1642932528 = new Wall(17 * gridSize, 80 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //17,80
        addToObs(z1642932528, 0);
        Obstacle z660792521 = new Wall(24 * gridSize, 14 * gridSize, new Point(2 * gridSize, 2 * gridSize)); //24,14
        addToObs(z660792521, 0);
        Obstacle z462480636 = new Wall(16 * gridSize, 58 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //16,58
        addToObs(z462480636, 0);
        Obstacle z125993773 = new Wall(1 * gridSize, 0 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //1,0
        addToObs(z125993773, 0);
        Obstacle z1192108111 = new SlowdownIce(19 * gridSize, 77 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //19,77
        addToObs(z1192108111, 0);
        Obstacle z442041598 = new Wall(4 * gridSize, 45 * gridSize, new Point(4 * gridSize, 4 * gridSize)); //4,45
        addToObs(z442041598, 0);
        Obstacle z685643625 = new Wall(24 * gridSize, 90 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //24,90
        addToObs(z685643625, 0);
        Obstacle z1716721723 = new Wall(21 * gridSize, 39 * gridSize, new Point(5 * gridSize, 1 * gridSize)); //21,39
        addToObs(z1716721723, 0);
        Obstacle z1653033174 = new Wall(0 * gridSize, 88 * gridSize, new Point(7 * gridSize, 1 * gridSize)); //0,88
        addToObs(z1653033174, 0);
        Obstacle z1557553988 = new SlowdownIce(3 * gridSize, 63 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //3,63
        addToObs(z1557553988, 0);
        Obstacle z764089668 = new Wall(4 * gridSize, 73 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //4,73
        addToObs(z764089668, 0);
        Obstacle z1415361476 = new Wall(20 * gridSize, 73 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //20,73
        addToObs(z1415361476, 0);
        Obstacle z1887400049 = new SlowdownIce(3 * gridSize, 64 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //3,64
        addToObs(z1887400049, 0);
        Obstacle z1179776469 = new Wall(20 * gridSize, 77 * gridSize, new Point(7 * gridSize, 1 * gridSize)); //20,77
        addToObs(z1179776469, 0);
        Obstacle z1288141901 = new Wall(18 * gridSize, 79 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //18,79
        addToObs(z1288141901, 0);
        Obstacle z870544302 = new Wall(20 * gridSize, 84 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //20,84
        addToObs(z870544302, 0);
        Obstacle z1846801405 = new Wall(0 * gridSize, 77 * gridSize, new Point(7 * gridSize, 1 * gridSize)); //0,77
        addToObs(z1846801405, 0);
        Obstacle z943011017 = new Wall(7 * gridSize, 83 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //7,83
        addToObs(z943011017, 0);
        Obstacle z2019641247 = new Wall(2 * gridSize, 90 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //2,90
        addToObs(z2019641247, 0);
        Obstacle z1533724469 = new Wall(20 * gridSize, 88 * gridSize, new Point(7 * gridSize, 1 * gridSize)); //20,88
        addToObs(z1533724469, 0);
        Obstacle z1392739371 = new Wall(19 * gridSize, 17 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //19,17
        addToObs(z1392739371, 0);
        Obstacle z1254526301 = new Wall(18 * gridSize, 18 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //18,18
        addToObs(z1254526301, 0);
        Obstacle z1917925237 = new Wall(15 * gridSize, 68 * gridSize, new Point(11 * gridSize, 2 * gridSize)); //15,68
        addToObs(z1917925237, 0);
        Obstacle z1600329395 = new SlowdownIce(17 * gridSize, 78 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //17,78
        addToObs(z1600329395, 0);
        Obstacle z434176605 = new Wall(21 * gridSize, 20 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //21,20
        addToObs(z434176605, 0);
        Obstacle z2096057976 = new Wall(18 * gridSize, 41 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //18,41
        addToObs(z2096057976, 0);
        Obstacle z1689843987 = new SlowdownIce(7 * gridSize, 77 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //7,77
        addToObs(z1689843987, 0);
        Obstacle z486918998 = new Wall(10 * gridSize, 6 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //10,6
        addToObs(z486918998, 0);
        Obstacle z2069266948 = new Wall(6 * gridSize, 18 * gridSize, new Point(1 * gridSize, 7 * gridSize)); //6,18
        addToObs(z2069266948, 0);
        Obstacle z1814013530 = new Wall(0 * gridSize, 14 * gridSize, new Point(1 * gridSize, 6 * gridSize)); //0,14
        addToObs(z1814013530, 0);
        Obstacle z1555845291 = new Wall(8 * gridSize, 78 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //8,78
        addToObs(z1555845291, 0);
        Obstacle z838188175 = new Wall(10 * gridSize, 73 * gridSize, new Point(7 * gridSize, 1 * gridSize)); //10,73
        addToObs(z838188175, 0);
        Obstacle z1735028887 = new Wall(20 * gridSize, 65 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //20,65
        addToObs(z1735028887, 0);
        Obstacle z392292447 = new Wall(25 * gridSize, 0 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //25,0
        addToObs(z392292447, 0);
        Obstacle z625213193 = new Wall(8 * gridSize, 18 * gridSize, new Point(10 * gridSize, 1 * gridSize)); //8,18
        addToObs(z625213193, 0);
        Obstacle z290068360 = new Wall(18 * gridSize, 54 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //18,54
        addToObs(z290068360, 0);
        Obstacle z256730126 = new Wall(4 * gridSize, 90 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //4,90
        addToObs(z256730126, 0);
        Obstacle z1199280647 = new Wall(22 * gridSize, 90 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //22,90
        addToObs(z1199280647, 0);
        Obstacle z1715590229 = new Wall(0 * gridSize, 0 * gridSize, new Point(1 * gridSize, 11 * gridSize)); //0,0
        addToObs(z1715590229, 0);
        Obstacle z1133858368 = new Wall(6 * gridSize, 84 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //6,84
        addToObs(z1133858368, 0);
        Obstacle z1767781924 = new Wall(1 * gridSize, 60 * gridSize, new Point(19 * gridSize, 1 * gridSize)); //1,60
        addToObs(z1767781924, 0);
        Obstacle z1875257449 = new SlowdownIce(12 * gridSize, 68 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //12,68
        addToObs(z1875257449, 0);
        Obstacle z1006685094 = new Wall(21 * gridSize, 58 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //21,58
        addToObs(z1006685094, 0);
        Obstacle z1667043539 = new Water(0 * gridSize, 87 * gridSize, new Point(6 * gridSize, 1 * gridSize)); //0,87
        addToObs(z1667043539, 0);
        Obstacle z889577428 = new Wall(22 * gridSize, 60 * gridSize, new Point(1 * gridSize, 6 * gridSize)); //22,60
        addToObs(z889577428, 0);
        Obstacle z1932178084 = new Wall(5 * gridSize, 46 * gridSize, new Point(22 * gridSize, 1 * gridSize)); //5,46
        addToObs(z1932178084, 0);
        Obstacle z128526657 = new Wall(15 * gridSize, 59 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //15,59
        addToObs(z128526657, 0);
        Obstacle z1771201231 = new Wall(3 * gridSize, 11 * gridSize, new Point(7 * gridSize, 2 * gridSize)); //3,11
        addToObs(z1771201231, 0);
        Obstacle z500193994 = new SlowdownIce(3 * gridSize, 65 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //3,65
        addToObs(z500193994, 0);
        Obstacle z2094777842 = new Wall(6 * gridSize, 87 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //6,87
        addToObs(z2094777842, 0);
        Obstacle z1209051301 = new Wall(20 * gridSize, 16 * gridSize, new Point(6 * gridSize, 4 * gridSize)); //20,16
        addToObs(z1209051301, 0);
        Obstacle z1580395670 = new Wall(5 * gridSize, 47 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //5,47
        addToObs(z1580395670, 0);
        Obstacle z1383349416 = new Wall(18 * gridSize, 49 * gridSize, new Point(1 * gridSize, 5 * gridSize)); //18,49
        addToObs(z1383349416, 0);
        Obstacle z1321640625 = new Wall(7 * gridSize, 3 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //7,3
        addToObs(z1321640625, 0);
        Obstacle z1356868644 = new Wall(7 * gridSize, 23 * gridSize, new Point(17 * gridSize, 2 * gridSize)); //7,23
        addToObs(z1356868644, 0);
        Obstacle z489641181 = new Wall(9 * gridSize, 80 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //9,80
        addToObs(z489641181, 0);
        Obstacle z705714117 = new Wall(5 * gridSize, 54 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //5,54
        addToObs(z705714117, 0);
        Obstacle z240650568 = new Wall(22 * gridSize, 59 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //22,59
        addToObs(z240650568, 0);
        Obstacle z483422920 = new Wall(19 * gridSize, 83 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //19,83
        addToObs(z483422920, 0);
        Obstacle z2088051274 = new Water(20 * gridSize, 87 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //20,87
        addToObs(z2088051274, 0);
        Obstacle z301577073 = new Wall(21 * gridSize, 87 * gridSize, new Point(6 * gridSize, 1 * gridSize)); //21,87
        addToObs(z301577073, 0);
        Obstacle z1239731108 = new Wall(7 * gridSize, 18 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //7,18
        addToObs(z1239731108, 0);
        Obstacle z557041943 = new Wall(23 * gridSize, 22 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //23,22
        addToObs(z557041943, 0);
        Obstacle z1802285572 = new Wall(8 * gridSize, 80 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //8,80
        addToObs(z1802285572, 0);
        Obstacle z950050653 = new Water(3 * gridSize, 90 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //3,90
        addToObs(z950050653, 0);
        Obstacle z997110539 = new Wall(8 * gridSize, 82 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //8,82
        addToObs(z997110539, 0);
        Obstacle z202034731 = new Water(7 * gridSize, 73 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //7,73
        addToObs(z202034731, 0);
        Obstacle z885951254 = new Wall(0 * gridSize, 13 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //0,13
        addToObs(z885951254, 0);
        Obstacle z413972392 = new Wall(24 * gridSize, 20 * gridSize, new Point(2 * gridSize, 4 * gridSize)); //24,20
        addToObs(z413972392, 0);
        Obstacle z1577341808 = new Wall(15 * gridSize, 43 * gridSize, new Point(4 * gridSize, 3 * gridSize)); //15,43
        addToObs(z1577341808, 0);
        Obstacle z762218417 = new Wall(14 * gridSize, 22 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //14,22
        addToObs(z762218417, 0);
        Obstacle z85331690 = new Wall(15 * gridSize, 70 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //15,70
        addToObs(z85331690, 0);
        Obstacle z1349414269 = new Wall(8 * gridSize, 79 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //8,79
        addToObs(z1349414269, 0);
        Obstacle z779742451 = new Wall(7 * gridSize, 22 * gridSize, new Point(15 * gridSize, 1 * gridSize)); //7,22
        addToObs(z779742451, 0);
        Obstacle z249515802 = new Wall(18 * gridSize, 82 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //18,82
        addToObs(z249515802, 0);
        Obstacle z946557743 = new Wall(1 * gridSize, 42 * gridSize, new Point(18 * gridSize, 1 * gridSize)); //1,42
        addToObs(z946557743, 0);
        Obstacle z2086853432 = new Wall(23 * gridSize, 38 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //23,38
        addToObs(z2086853432, 0);
        Obstacle z1517499208 = new Wall(4 * gridSize, 5 * gridSize, new Point(2 * gridSize, 4 * gridSize)); //4,5
        addToObs(z1517499208, 0);
        Obstacle z1070605166 = new Water(0 * gridSize, 78 * gridSize, new Point(6 * gridSize, 9 * gridSize)); //0,78
        addToObs(z1070605166, 0);
        Obstacle z1682470657 = new SlowdownIce(14 * gridSize, 66 * gridSize, new Point(1 * gridSize, 6 * gridSize)); //14,66
        addToObs(z1682470657, 0);
        Obstacle z750044106 = new Wall(25 * gridSize, 13 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //25,13
        addToObs(z750044106, 0);
        Obstacle z331844650 = new Wall(12 * gridSize, 22 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //12,22
        addToObs(z331844650, 0);
        Obstacle z1698419664 = new Water(7 * gridSize, 79 * gridSize, new Point(1 * gridSize, 4 * gridSize)); //7,79
        addToObs(z1698419664, 0);
        Obstacle z356473416 = new Wall(10 * gridSize, 22 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //10,22
        addToObs(z356473416, 0);
        Obstacle z2136344623 = new Wall(16 * gridSize, 22 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //16,22
        addToObs(z2136344623, 0);
        Obstacle z110992500 = new Wall(7 * gridSize, 78 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //7,78
        addToObs(z110992500, 0);
        Obstacle z814397446 = new Wall(5 * gridSize, 49 * gridSize, new Point(1 * gridSize, 5 * gridSize)); //5,49
        addToObs(z814397446, 0);
        Obstacle z972765909 = new Wall(18 * gridSize, 22 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //18,22
        addToObs(z972765909, 0);
        Obstacle z1651945043 = new Wall(8 * gridSize, 22 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //8,22
        addToObs(z1651945043, 0);
        Obstacle z341913240 = new Wall(20 * gridSize, 22 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //20,22
        addToObs(z341913240, 0);
        Obstacle z1202513530 = new SlowdownIce(10 * gridSize, 79 * gridSize, new Point(7 * gridSize, 2 * gridSize)); //10,79
        addToObs(z1202513530, 0);
        Obstacle z1836716258 = new Wall(18 * gridSize, 47 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //18,47
        addToObs(z1836716258, 0);
        Obstacle z1781256170 = new Wall(21 * gridSize, 21 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //21,21
        addToObs(z1781256170, 0);
        Obstacle z1154663669 = new Wall(19 * gridSize, 63 * gridSize, new Point(1 * gridSize, 3 * gridSize)); //19,63
        addToObs(z1154663669, 0);
        Obstacle z356395872 = new Wall(1 * gridSize, 12 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //1,12
        addToObs(z356395872, 0);
        Obstacle z1463757776 = new Wall(0 * gridSize, 12 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //0,12
        addToObs(z1463757776, 0);
        Obstacle z547204820 = new Wall(0 * gridSize, 11 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //0,11
        addToObs(z547204820, 0);
        Obstacle z714416244 = new Wall(7 * gridSize, 19 * gridSize, new Point(12 * gridSize, 3 * gridSize)); //7,19
        addToObs(z714416244, 0);
        Obstacle z1804377294 = new Wall(5 * gridSize, 2 * gridSize, new Point(2 * gridSize, 2 * gridSize)); //5,2
        addToObs(z1804377294, 0);
        Obstacle z1580532489 = new Wall(24 * gridSize, 24 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //24,24
        addToObs(z1580532489, 0);
        Obstacle z80905340 = new Wall(19 * gridSize, 20 * gridSize, new Point(2 * gridSize, 2 * gridSize)); //19,20
        addToObs(z80905340, 0);
        Obstacle z1512121500 = new Wall(26 * gridSize, 0 * gridSize, new Point(1 * gridSize, 46 * gridSize)); //26,0
        addToObs(z1512121500, 0);
        Obstacle z1411852185 = new Wall(3 * gridSize, 6 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //3,6
        addToObs(z1411852185, 0);
        Obstacle z1137304549 = new Wall(9 * gridSize, 74 * gridSize, new Point(9 * gridSize, 1 * gridSize)); //9,74
        addToObs(z1137304549, 0);
        Obstacle z753977143 = new Water(7 * gridSize, 74 * gridSize, new Point(14 * gridSize, 1 * gridSize)); //7,74
        addToObs(z753977143, 0);
        Obstacle z513145535 = new Wall(19 * gridSize, 47 * gridSize, new Point(1 * gridSize, 9 * gridSize)); //19,47
        addToObs(z513145535, 0);
        Obstacle z1911883829 = new Wall(18 * gridSize, 62 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //18,62
        addToObs(z1911883829, 0);
        Obstacle z138632365 = new Wall(0 * gridSize, 20 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //0,20
        addToObs(z138632365, 0);
        Obstacle z403077058 = new SlowdownIce(17 * gridSize, 61 * gridSize, new Point(3 * gridSize, 1 * gridSize)); //17,61
        addToObs(z403077058, 0);
        Obstacle z1578069626 = new Water(20 * gridSize, 78 * gridSize, new Point(1 * gridSize, 6 * gridSize)); //20,78
        addToObs(z1578069626, 0);
        Obstacle z1476394230 = new Wall(13 * gridSize, 45 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //13,45
        addToObs(z1476394230, 0);
        Obstacle z1702486499 = new Wall(18 * gridSize, 73 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //18,73
        addToObs(z1702486499, 0);
        Obstacle z1007603050 = new Water(17 * gridSize, 73 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //17,73
        addToObs(z1007603050, 0);
        Obstacle z1435515811 = new Wall(11 * gridSize, 53 * gridSize, new Point(1 * gridSize, 5 * gridSize)); //11,53
        addToObs(z1435515811, 0);
        Obstacle z45489461 = new Wall(11 * gridSize, 58 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //11,58
        addToObs(z45489461, 0);
        Obstacle z2068126871 = new Water(18 * gridSize, 80 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //18,80
        addToObs(z2068126871, 0);
        Obstacle z814702039 = new Wall(14 * gridSize, 44 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //14,44
        addToObs(z814702039, 0);
        Obstacle z1001513761 = new Wall(20 * gridSize, 47 * gridSize, new Point(7 * gridSize, 9 * gridSize)); //20,47
        addToObs(z1001513761, 0);
        Obstacle z1251863520 = new Wall(6 * gridSize, 5 * gridSize, new Point(2 * gridSize, 1 * gridSize)); //6,5
        addToObs(z1251863520, 0);
        Obstacle z322288349 = new Wall(20 * gridSize, 60 * gridSize, new Point(2 * gridSize, 5 * gridSize)); //20,60
        addToObs(z322288349, 0);
        Obstacle z354308720 = new Water(23 * gridSize, 90 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //23,90
        addToObs(z354308720, 0);
        Obstacle z820413439 = new Wall(22 * gridSize, 78 * gridSize, new Point(5 * gridSize, 9 * gridSize)); //22,78
        addToObs(z820413439, 0);
        Obstacle z499732187 = new Wall(22 * gridSize, 20 * gridSize, new Point(2 * gridSize, 2 * gridSize)); //22,20
        addToObs(z499732187, 0);
        Obstacle z790489627 = new Water(19 * gridSize, 79 * gridSize, new Point(1 * gridSize, 4 * gridSize)); //19,79
        addToObs(z790489627, 0);
        Obstacle z922872597 = new Wall(25 * gridSize, 37 * gridSize, new Point(1 * gridSize, 1 * gridSize)); //25,37
        addToObs(z922872597, 0);
        Obstacle z1131769173 = new Water(21 * gridSize, 78 * gridSize, new Point(1 * gridSize, 9 * gridSize)); //21,78
        addToObs(z1131769173, 0);
        Obstacle z1345416875 = new SlowdownIce(9 * gridSize, 78 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //9,78
        addToObs(z1345416875, 0);
        Obstacle z386864328 = new SlowdownIce(13 * gridSize, 67 * gridSize, new Point(1 * gridSize, 4 * gridSize)); //13,67
        addToObs(z386864328, 0);
        Obstacle z1738403997 = new Wall(14 * gridSize, 11 * gridSize, new Point(7 * gridSize, 2 * gridSize)); //14,11
        addToObs(z1738403997, 0);
        Obstacle z65381535 = new Wall(18 * gridSize, 56 * gridSize, new Point(8 * gridSize, 1 * gridSize)); //18,56
        addToObs(z65381535, 0);
        Obstacle z266829590 = new Wall(10 * gridSize, 12 * gridSize, new Point(4 * gridSize, 1 * gridSize)); //10,12
        addToObs(z266829590, 0);
        Obstacle z707169847 = new Wall(10 * gridSize, 11 * gridSize, new Point(4 * gridSize, 1 * gridSize)); //10,11
        addToObs(z707169847, 0);
        Obstacle z1482401014 = new Water(6 * gridSize, 78 * gridSize, new Point(1 * gridSize, 6 * gridSize)); //6,78
        addToObs(z1482401014, 0);
        Obstacle z1588520096 = new Wall(6 * gridSize, 6 * gridSize, new Point(4 * gridSize, 4 * gridSize)); //6,6
        addToObs(z1588520096, 0);
        Obstacle z584322135 = new Wall(11 * gridSize, 51 * gridSize, new Point(1 * gridSize, 2 * gridSize)); //11,51
        addToObs(z584322135, 0);
    }
}
