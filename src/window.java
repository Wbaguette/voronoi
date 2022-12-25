import javax.swing.*;
import java.awt.*;

public class window extends JFrame {
    windowPanel windowPanel;
    // Set up the window panel that will have the voronoi diagram
    window() {
        windowPanel = new windowPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add a window panel object to pack it nicely
        this.add(windowPanel);
        this.setBackground(Color.black);
        windowPanel.createPoints();
        this.setTitle("Voronoi Diagram");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
