//Create a nested layout,
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Question2 extends JFrame 
{

	public static void main(String[] args)
	{
		Question2 myProgram = new Question2();
	}
	
	public Question2()
	{
		super("Font Chooser");
		drawGUI();
	}
	
	private void drawGUI()
	{
		JPanel panel = new JPanel();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(panel);
		
		//Checkboxes
		JCheckBox bold = new JCheckBox("Bold");
		JCheckBox italic = new JCheckBox("Italic");
		
		//Radio buttons
		JRadioButton times = new JRadioButton("Times");
		JRadioButton helvetica = new JRadioButton("Helvetica");
		JRadioButton courier = new JRadioButton("Courier");
		//Add the radio buttons to a group so only 1 can be selected.
		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.add(times);
		radioButtons.add(helvetica);
		radioButtons.add(courier);
		
		JTextField textBox = new JTextField(20);
		JButton ok = new JButton("OK");
		
		//Checkboxes panel
		JPanel checkBoxes = new JPanel();
		checkBoxes.setLayout(new BoxLayout(checkBoxes, BoxLayout.PAGE_AXIS));
		checkBoxes.add(bold);
		checkBoxes.add(italic);
		
		//Radio button panel
		JPanel radioButtonPanel = new JPanel();
		radioButtonPanel.setLayout(new BoxLayout(radioButtonPanel, BoxLayout.PAGE_AXIS));
		radioButtonPanel.add(times);
		radioButtonPanel.add(helvetica);
		radioButtonPanel.add(courier);
		
		//Textbox panel
		JPanel textBoxPanel = new JPanel();
		textBoxPanel.setLayout(new GridLayout(3, 1));
		textBoxPanel.add(new Container());
		textBoxPanel.add(textBox);
		
		
		//panel.setLayout(new GridLayout(1, 4));
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		panel.add(checkBoxes);
		panel.add(radioButtonPanel);
		panel.add(textBoxPanel);
		panel.add(ok);
		panel.setBorder(new EmptyBorder(10, 20, 10, 20));
		
		this.pack();
		this.setVisible(true);
		
	}
	
}
