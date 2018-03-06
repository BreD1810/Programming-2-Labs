import javax.swing.*;
import java.awt.*;

public class CircleRecursion extends JFrame
{

    public CircleRecursion()
    {
        super("Circle recursion");
        init();
    }

    public static void main(String[] args)
    {
        CircleRecursion myProgram = new CircleRecursion();
    }

    private void init()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        this.setContentPane(mainPanel);
        mainPanel.setPreferredSize(new Dimension(500, 200));

        this.pack();
        this.setVisible(true);
        drawCircle(this.getWidth()/2, this.getHeight()/2, 100, mainPanel);
    }

    private void drawCircle(int x, int y, int r, JPanel panel)
    {
        Graphics g = panel.getGraphics();
        g.setColor(new Color(0, 255, 0));
        System.out.println("x: " + x + " y: " + y + " r: " + r );
        g.drawOval(x, y, r, r);
        g.setColor(Color.red);
        g.drawOval(250, 100, 100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
