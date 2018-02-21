import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class Shape extends JPanel
{

    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        Random rand = new Random();
        float red = rand.nextFloat();
        float green = rand.nextFloat();
        float blue = rand.nextFloat();
        graphics.setColor(new Color(red, green, blue));
    }

}
