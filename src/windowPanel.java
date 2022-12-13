import javax.swing.*;
import java.awt.*;

public class windowPanel extends JPanel {
    windowPanel() {
        this.setPreferredSize(new Dimension(1440, 900));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        g2D.drawLine(0, 0, 1440, 900);
    }

}
