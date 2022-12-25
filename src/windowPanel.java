import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.Point;
import java.util.stream.Stream;

public class windowPanel extends JPanel {

    public static final int seedsCount = 10;
    public static final int panelWidth = 1440;
    public static final int panelHeight = 900;
    public static final HashMap<Point, Color> palette = new HashMap<>();

    windowPanel() { this.setPreferredSize(new Dimension(panelWidth, panelHeight)); }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        fillPixels(g2D);
     // renderPoints(g2D);
    }

    /*
    Create "seedsCount" number of points on the window by randomly choosing an x and y coordinate for each seed
    Store points as keys in a map along with a color that is randomly generated as its value
     */
    public void createPoints() {
        Random randInt = new Random();
        for (int i = 0; i < seedsCount; i++) {
            palette.put(new Point(randInt.nextInt(panelWidth+1), randInt.nextInt(panelHeight+1)), Color.decode(randomColor()));
        }
    }

    /*
    Helper method to visualize the seeds on the window as circles
     */
    public void renderPoints(Graphics2D g2D) {
        g2D.setColor(Color.black);
        Stream<Map.Entry<Point, Color>> entryStream = palette.entrySet().stream();
        entryStream.forEach(Entry -> {
         //   g2D.setColor(Entry.getValue());
            g2D.drawOval(Entry.getKey().x, Entry.getKey().y, 5, 5);
        });
    }

    /*
    Fill pixels by calculating the square distance to the closest point, fill the pixel with color associated to pixel
     */
    public void fillPixels(Graphics2D g2D) {
        for (int i = 0; i < panelWidth; i++) {
            for (int j = 0; j < panelHeight; j++) {
                g2D.setColor(closestSeed(i, j));
                g2D.drawOval(i, j, 1, 1);
            }
        }
    }

    /*
    Using a point(x,y), find the closest seed in the diagram
    Return the color that that seed holds (the color that that pixel (point) needs to be colored with)
     */
    public Color closestSeed(int x, int y) {
        int leastSquareDistance = Integer.MAX_VALUE;
        Map.Entry<Point, Color> temp = null;

        for (Map.Entry<Point, Color> entry: palette.entrySet()) {
            int squareDistance = (entry.getKey().x - x)*(entry.getKey().x - x) + (entry.getKey().y - y)*(entry.getKey().y - y);
            if (squareDistance < leastSquareDistance) {
                leastSquareDistance = squareDistance;
                temp = entry;
            }
        }

        assert temp != null;
        return temp.getValue();
    }

    /*
    Generates a random hex code color, used for making a color palette for the seeds
     */
    public String randomColor() {
        Random randHex = new Random();
        return String.format("#%06x", randHex.nextInt(0xffffff + 1));
    }

}
