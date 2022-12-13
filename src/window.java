import javax.swing.*;

public class window extends JFrame {
    windowPanel windowPanel;
    window() {
        windowPanel = new windowPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(windowPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
