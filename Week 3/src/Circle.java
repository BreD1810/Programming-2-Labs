import java.awt.*;

public class Circle extends Shape
{

    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        graphics.fillOval((this.getWidth()/2-50), (this.getHeight()/2)-50, 100, 100);
    }

}
