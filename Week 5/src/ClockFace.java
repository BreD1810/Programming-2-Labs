import javax.swing.*;
import java.awt.*;

public class ClockFace extends JPanel
{

    private int seconds, minutes, hours;

    public void setSeconds(int s)
    {
        seconds = s;
    }

    public void setMinutes(int m)
    {
        minutes = m;
    }

    public void setHours(int h)
    {
        hours = h;
    }

    public int getSeconds()
    {
        return seconds;
    }

    public int getMinutes()
    {
        return minutes;
    }

    public int getHours()
    {
        return hours;
    }

    @Override
    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        graphics.setColor(Color.white);
        graphics.fillOval(this.getWidth()/2-125, this.getHeight()/2-125, 250, 250);
        Graphics2D graphics2D = (Graphics2D)graphics;

        graphics.setColor(Color.black);

        //Draw the center dot
        graphics.drawLine(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2, this.getHeight()/2);

        //Draw the tick markers
        for(int i = 0; i < 60; i++) {
            //graphics.drawLine(0,  0,100, 100);
            if(i%5==0)
            {
                graphics.drawLine(this.getWidth()/2, this.getHeight()/2-105, this.getWidth()/2, this.getHeight()/2-125);
            }
            else
            {
                graphics.drawLine(this.getWidth()/2, this.getHeight()/2-115, this.getWidth()/2, this.getHeight()/2-125);
            }
            graphics2D.rotate(Math.PI/30, this.getWidth()/2, this.getHeight()/2);
        }

        //Set hand width
        graphics2D.setStroke(new BasicStroke(3));

        //Draw the second hand
        graphics.setColor(Color.red);
        graphics2D.rotate((Math.PI/30)*seconds, this.getWidth()/2, this.getHeight()/2);
        graphics.drawLine(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2, this.getHeight()/2-100);
        graphics2D.rotate(-((Math.PI/30)*seconds), this.getWidth()/2, this.getHeight()/2);

        //Draw the minute hand
        graphics.setColor(Color.blue);
        graphics2D.rotate(((Math.PI/30)*minutes), this.getWidth()/2, this.getHeight()/2);
        graphics.drawLine(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2, this.getHeight()/2 - 70);
        graphics2D.rotate(-((Math.PI/30)*minutes), this.getWidth()/2, this.getHeight()/2);

        //Draw the hour hand
        graphics.setColor(Color.green);
        graphics2D.rotate(((Math.PI/6)*hours), this.getWidth()/2, this.getHeight()/2);
        graphics.drawLine(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2, this.getHeight()/2 - 40);
    }

}
