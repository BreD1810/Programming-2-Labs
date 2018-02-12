//Application that counts the number of clicks on a button
//*Button to increment click count
//*Reset button

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Question1 extends JFrame
{
    
    public static void main(String[] args)
    {
        Question1 myProgram = new Question1();
    }
    
    public Question1()
    {
        super("Button Press Counter");
        drawGUI();
    }
    
    private void drawGUI()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JButton increment = new JButton("Increment");
        JButton reset = new JButton("Reset");
        JTextField textField = new JTextField("0");
        textField.setPreferredSize(new Dimension(50, 50));
        
        panel.setLayout(new FlowLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        increment.addActionListener(new IncrementButtonListener(textField));
        reset.addActionListener(new IncrementButtonListener(textField));
        
        this.add(panel);
        panel.add(textField);
        panel.add(increment);
        panel.add(reset);
        this.pack();
        this.setVisible(true);
    }
    
}

class IncrementButtonListener implements ActionListener
{
    
    JTextField textField;
    
    public IncrementButtonListener(JTextField textField)
    {
        this.textField = textField;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton)e.getSource();
        if(button.getText().equals("Increment"))
        {
            int value = Integer.valueOf(textField.getText()) + 1;
            textField.setText(String.valueOf(value));
        }
        else if(button.getText().equals("Reset"))
        {
            textField.setText("0");
        }
    }
    
}