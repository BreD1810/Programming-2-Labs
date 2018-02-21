import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class ColourChanger extends JFrame
{

    Shape[] shapes = new Shape[3];

    public static void main(String[] args)
    {
        ColourChanger myProgram = new ColourChanger();
    }
    
    public ColourChanger()
    {
        super("Colour Changer");
        init();
    }
    
    private void init()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        this.setContentPane(mainPanel);
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setPreferredSize(new Dimension(300, 300));
        mainPanel.setBackground(Color.white);

        JPanel circle1 = new Circle();
        circle1.addMouseListener(new ShapeListener(circle1));
        JPanel circle2 = new Circle();
        circle2.addMouseListener(new ShapeListener(circle2));
        JPanel square1 = new Square();
        square1.addMouseListener(new ShapeListener(square1));
        JPanel square2 = new Square();
        square2.addMouseListener(new ShapeListener(square2));

        mainPanel.setLayout(new GridLayout(2, 2));
        mainPanel.add(circle1);
        mainPanel.add(circle2);
        mainPanel.add(square1);
        mainPanel.add(square2);
        
        //Set the window to visible.
        this.pack();
        this.setVisible(true);
    }
    
}

class ShapeListener extends MouseAdapter
{
    JPanel panel;

    public ShapeListener(JPanel panel)
    {
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if((e.getX() >= (panel.getWidth()/2)-50 && e.getX()<= (panel.getWidth()/2) + 50) && (e.getY() >= (panel.getHeight()/2)-50 && e.getY() <= (panel.getHeight()/2)+50))
        {
            panel.repaint();
        }
    }
}
