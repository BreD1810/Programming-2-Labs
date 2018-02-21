import javax.swing.*;
import java.awt.*;

public class TickPanel extends JPanel
{

    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        graphics.setColor(Color.black);
        Graphics2D graphics2D = (Graphics2D)graphics;
        for(int i = 0; i < 60; i++) {
            graphics.drawLine(0,  0,100, 100);
            graphics2D.rotate(Math.PI/30);

            //TODO: Panel with top left corner in center of circle, then draw lines as here
        }
    }

}
