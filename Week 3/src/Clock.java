import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clock extends JFrame
{

    private ClockFace face;

    public static void main(String[] args)
    {
        Clock clock = new Clock();
    }

    public Clock()
    {
        super("Clock");
        init();
    }

    private void init()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        this.setContentPane(mainPanel);
        mainPanel.setPreferredSize(new Dimension(300, 400));

        JTextField secondText = new JTextField("00");
        JButton secondButton = new JButton("Update Seconds");
        secondButton.addActionListener(new TextChangeListener(secondText));
        JTextField minuteText = new JTextField("00");
        JButton minuteButton = new JButton("Update Minutes");
        minuteButton.addActionListener(new TextChangeListener(minuteText));
        JTextField hourText = new JTextField("00");
        JButton hourButton = new JButton("Update Hours");
        hourButton.addActionListener(new TextChangeListener(hourText));

        this.add(hourText);
        this.add(hourButton);
        this.add(minuteText);
        this.add(minuteButton);
        this.add(secondText);
        this.add(secondButton);

        face = new ClockFace();
        face.setPreferredSize(new Dimension(300, 300));

        this.add(face);

        this.pack();
        this.setVisible(true);
    }

    private void setTime(int h, int m, int s)
    {
        face.setHours(h);
        face.setMinutes(m);
        face.setSeconds(s);
        //Paint again
        face.repaint();
    }



    class TextChangeListener implements ActionListener
    {

        JTextField textField;

        public TextChangeListener(JTextField textField)
        {
            this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton)e.getSource();
            if(button.getText().contains("Seconds"))
            {
                setTime(face.getHours(), face.getMinutes(), Integer.valueOf(textField.getText()));
            }
            else if (button.getText().contains("Minutes"))
            {
                setTime(face.getHours(), Integer.valueOf(textField.getText()), face.getSeconds());
            }
            else if(button.getText().contains("Hours"))
            {
                setTime(Integer.valueOf(textField.getText()), face.getMinutes(), face .getSeconds());
            }
        }
    }

}

