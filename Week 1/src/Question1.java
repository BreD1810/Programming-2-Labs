//Simple submit cancel form
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Question1 extends JFrame
{

	public static void main(String[] args)
	{
		Question1 myProgram = new Question1();
	}
	
	public Question1()
	{
		super("Simple Submit Cancel Form");
		drawGUI();
	}
	
	private void drawGUI()
	{
		JPanel panel = new JPanel();
		JTextField textBox = new JTextField(20);
		JButton submit = new JButton("Submit");
		JButton cancel = new JButton("Cancel");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(panel);
		
//		panel.setLayout(new FlowLayout());
//		panel.add(textBox);
//		panel.add(submit);
//		panel.add(cancel);
		
//		panel.setLayout(new BorderLayout());
//		panel.add(textBox, BorderLayout.CENTER);
//		panel.add(submit, BorderLayout.WEST);
//		panel.add(cancel, BorderLayout.EAST);
		
		//This creates a 2x1 grid, where the lower half is a 1x2 grid.
		panel.setLayout(new GridLayout(2, 1));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 2));
		panel.add(textBox);
		panel.setBorder(new EmptyBorder(10, 20, 10, 20)); //Set borders on the panels
		panel2.setBorder(new EmptyBorder(0, 10, 0, 10));
		panel.add(panel2);
		panel2.add(submit);
		panel2.add(cancel);
		
		this.pack();
		this.setVisible(true);
	}
	
}
