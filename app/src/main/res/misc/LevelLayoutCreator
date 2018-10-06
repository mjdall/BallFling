import java.util.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;

class Pair<T, U> {
  T x;
  U y;
  public Pair (T x, U y) {
    this.x = x;
    this.y = y;
  }
}

class LevelLayoutCreator {
  public static void main (String[] args) {
    String filename = args[0] + ".bmp";
    File bmpFile = new File(filename);
    if (!bmpFile.exists()) {
      System.out.print("File doesn't exist");
      System.exit(1);
    }

    try {
      BufferedImage image = ImageIO.read(bmpFile);
      int imgWidth = image.getWidth();
      int imgHeight = image.getHeight();
      Map<Integer, List<Pair<Integer, Integer>>> obstacles = new HashMap<>();

      for (int y = 0; y < imgHeight; y ++) {
        for (int x = 0; x < imgWidth; x++) {
          int newColour = image.getRGB(x, y);
          if (newColour == -1) continue;
          List<Pair<Integer, Integer>> list = obstacles.getOrDefault(newColour, new ArrayList<>());
          Pair<Integer, Integer> coords = new Pair<>(x, y);
          list.add(coords);
          obstacles.put(newColour, list);
        }
      }

      System.out.println("package tracksegments;\n\nimport android.graphics.Point;\nimport obstacles.*;\n");
      System.out.format("public class %s extends TrackBlueprint {\n", args[0]);
      System.out.format("\tpublic %s (Point screenDims) {\n", args[0]);
      System.out.format("\t\tsuper(screenDims, screenDims.x * %d / %d, false);\n\t}\n\n", imgHeight, imgWidth);
      System.out.print("\t@Override\n\tprotected void setObs () {\n");
      System.out.format("\t\tint gridSize = width / %d;\n", imgWidth);
      for (List<Pair<Integer, Integer>> box : obstacles.values()) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = 0, maxY = 0;
        for (Pair<Integer, Integer> p : box) {
          minX = Math.min(p.x, minX);
          minY = Math.min(p.y, minY);
          maxX = Math.max(p.x + 1, maxX);
          maxY = Math.max(p.y + 1, maxY);
        }
        System.out.format("\t\tObstacle z%s = new Wall(%d * gridSize, %d * gridSize, new Point(%d * gridSize, %d * gridSize));\n\t\taddToObs(z%s, 0);\n",
         Math.abs(box.hashCode()), minX, minY, maxX-minX, maxY-minY, Math.abs(box.hashCode()));
      }
      System.out.println("\t}\n}");

    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }

  }
}
