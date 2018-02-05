import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Question3 extends JFrame
{

	public static void main(String[] args)
	{
		Question3 myProgram = new Question3();
	}
	
	public Question3() 
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
		//checkBoxes.add(Box.createRigidArea(new Dimension(0, 20)));
		checkBoxes.add(italic);
		
		//ComboBox
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem(new String("Times"));
		comboBox.addItem(new String("Helvetica"));
		comboBox.addItem(new String("Courier"));
		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.setLayout(new GridLayout(3, 1));
		comboBoxPanel.add(new Container());
		comboBoxPanel.add(comboBox);
		
		//Textbox panel
		JPanel textBoxPanel = new JPanel();
		textBoxPanel.setLayout(new BoxLayout(textBoxPanel, BoxLayout.PAGE_AXIS));
		textBoxPanel.add(Box.createRigidArea(new Dimension(0, 25)));
		textBoxPanel.add(textBox);
		textBoxPanel.add(Box.createRigidArea(new Dimension(0, 25)));
		
		
		//panel.setLayout(new GridLayout(1, 4));
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		panel.add(checkBoxes);
		panel.add(comboBoxPanel);
		panel.add(textBoxPanel);
		panel.add(ok);
		panel.setBorder(new EmptyBorder(10, 20, 10, 20));
		
		this.pack();
		this.setVisible(true);
	}
	
}
