import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Question3 extends JFrame
{

    public static void main(String[] args)
    {
        Question3 myProgram = new Question3();
    }

    public Question3()
    {
        super("Mouse Listener");
        drawGUI();
    }

    private void drawGUI()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        this.add(panel);
        //panel.setLayout(new GridLayout(2, 1));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        //Labels at the bottom
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(1, 2));
        JLabel xLocation = new JLabel();
        JLabel yLocation = new JLabel();
        labelPanel.add(xLocation);
        labelPanel.add(yLocation);

        //Panels at the top
        JPanel[] panels = new JPanel[10];
        JPanel panelOfPanels = new JPanel();
        panelOfPanels.setLayout(null);
        panelOfPanels.setPreferredSize(new Dimension(300, 300));
        panelOfPanels.setBackground(Color.blue);
        panelOfPanels.addMouseMotionListener(new MousePositionListener(xLocation, yLocation));
        for(int i = 0; i < panels.length; i++)
        {
            panels[i] = new JPanel();
            //panels[i].setLayout(null);
            panels[i].setBounds(getRandomNumber200(), getRandomNumber200(), getRandomNumber100(), getRandomNumber100());
            panels[i].setBackground(Color.red);
            panels[i].addMouseMotionListener(new MousePositionListener(xLocation, yLocation));
            panels[i].addMouseMotionListener(new PanelDragListener());
            panelOfPanels.add(panels[i]);
        }

        //Add to the main panel
        panel.add(panelOfPanels);
        panel.add(labelPanel);
        this.pack();
        this.setVisible(true);
    }

    private int getRandomNumber200()
    {
        Random rand = new Random();
        int randomNumber = rand.nextInt(200);
        return randomNumber;
    }

    private int getRandomNumber100()
    {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100)+ 10;
        return randomNumber;
    }
}

class MousePositionListener extends MouseAdapter
{

    private JLabel xLocation;
    private JLabel yLocation;

    public MousePositionListener(JLabel xLocation, JLabel yLocation)
    {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public void mouseMoved(MouseEvent e)
    {
        Point point = e.getPoint();
        xLocation.setText(String.valueOf(point.getX()));
        yLocation.setText(String.valueOf(point.getY()));
    }

}

class PanelDragListener extends MouseAdapter
{

    public void mouseDragged(MouseEvent e)
    {
        JPanel panel = (JPanel)e.getSource();
        int xLocation = e.getX() + panel.getX();
        int yLocation = e.getY() + panel.getY();
        panel.setLocation(xLocation, yLocation);
    }
}