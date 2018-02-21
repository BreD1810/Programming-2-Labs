import java.awt.*;

public class Square extends Shape
{

    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        graphics.fillRect((this.getWidth()/2)-50, (this.getHeight()/2)-50, 100, 100);
    }

}
