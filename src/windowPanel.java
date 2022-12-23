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
        createPoints();
        renderPoints(g2D);
        fillPixels(g2D);
    }

    /*
    Create "seedsCount" number of points on the window by randomly choosing an x and y coordinate for each seed
    Array of "Points" (X Y pairs) stores the seeds
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
        g2D.setColor(Color.cyan);
        Stream<Map.Entry<Point, Color>> keyStream = palette.entrySet().stream();
        keyStream.forEach(Entry -> {
            g2D.setColor(Entry.getValue());
            g2D.drawOval(Entry.getKey().x, Entry.getKey().y, 5, 5);
        });
    }

    /*
    Fill pixels by calculating the distance to the closest point, fill the pixel with color associated to pixel
     */
    public void fillPixels(Graphics2D g2D) {

    }

    /*
    Generates a random hex code color
     */
    public String randomColor() {
        Random randHex = new Random();
        return String.format("#%06x", randHex.nextInt(0xffffff + 1));
    }


}
