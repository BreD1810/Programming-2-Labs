import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Die extends JFrame 
{
 
    private int number = 0;
    
    public static void main(String[] args)
    {
        Die myProgram = new Die();
    }
    
    public Die()
    {
        super("Dice Program");
        init();
    }
    
    //Draw the GUI components
    private void init()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        this.setContentPane(mainPanel);
     
        JPanel diceFace = new JPanel();
        //diceFace.setLayout(new GridLayout(3, 3));
        Graphics graphics = diceFace.getGraphics();
        diceFace.setPreferredSize(new Dimension(325, 300));
        diceFace.setBackground(Color.white);
        JTextField textField = new JTextField(10);
        JButton enterButton = new JButton("Set value");
        
        //Add functionality to the button
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                updateVal(Integer.valueOf(textField.getText()));
            }
        });
        
        //Add content to the panel
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(diceFace);
        mainPanel.add(textField);
        mainPanel.add(enterButton);
        
        //Draw the window
        this.pack();
        this.setVisible(true);
    }
    
    public void updateVal(int i)
    {
        //Update the value and then repaint the screen
        number = i;
        repaint();
    }
    
    @Override
    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        
        //Clear the dice face
        graphics.setColor(Color.white);
        //Left side
        graphics.fillOval(50, 50, 50, 50);
        graphics.fillOval(50, 150, 50, 50);
        graphics.fillOval(50, 250, 50, 50);
        //Middle
        graphics.fillOval(150, 150, 50, 50);
        //Right
        graphics.fillOval(250, 50, 50, 50);
        graphics.fillOval(250, 150, 50, 50);
        graphics.fillOval(250, 250, 50, 50);

        graphics.setColor(Color.black);
        
        //Draw the dots
        switch(number)
        {
            case 0:
                break;
            case 1:
                graphics.fillOval(150, 150, 50, 50);
                break;
            case 2:
                graphics.fillOval(50, 50, 50, 50);
                graphics.fillOval(250, 250, 50, 50);
                break;
            case 3:
                graphics.fillOval(50, 250, 50, 50);
                graphics.fillOval(150, 150, 50, 50);
                graphics.fillOval(250, 50, 50, 50);
                break;
            case 4:
                graphics.fillOval(50, 50, 50, 50);
                graphics.fillOval(50, 250, 50, 50);
                graphics.fillOval(250, 50, 50, 50);
                graphics.fillOval(250, 250, 50, 50);
                break;
            case 5:
                graphics.fillOval(50, 50, 50, 50);
                graphics.fillOval(50, 250, 50, 50);
                graphics.fillOval(150, 150, 50, 50);
                graphics.fillOval(250, 50, 50, 50);
                graphics.fillOval(250, 250, 50, 50);
                break;
            case 6:
                graphics.fillOval(50, 50, 50, 50);
                graphics.fillOval(50, 150, 50, 50);
                graphics.fillOval(50, 250, 50, 50);
                graphics.fillOval(250, 50, 50, 50);
                graphics.fillOval(250, 150, 50, 50);
                graphics.fillOval(250, 250, 50, 50);
                break;
        }
        
    }
}
