//Font selection menu
//*Change the font in a text box based on user selected checkboxes and radio buttons
//*When the ok button is clicked, the font is printed to the console, and the window closes.

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;


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
		
        JTextField textBox = new JTextField(20);
		JButton ok = new JButton("OK");
        ok.addActionListener(new ButtonListener(textBox));
                
		//Checkboxes
		JCheckBox bold = new JCheckBox("Bold");
		JCheckBox italic = new JCheckBox("Italic");
                
		//Add itemListeners
        bold.addItemListener(new CheckBoxListener(textBox));
        italic.addItemListener(new CheckBoxListener(textBox));
		
		//Radio buttons
		JRadioButton times = new JRadioButton("Times New Roman");
		JRadioButton helvetica = new JRadioButton("Helvetica");
		JRadioButton courier = new JRadioButton("Courier");
		//Add the radio buttons to a group so only 1 can be selected.
		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.add(times);
		radioButtons.add(helvetica);
		radioButtons.add(courier);

		//Add ItemListeners
        times.addItemListener(new RadioButtonListener(textBox));
        helvetica.addItemListener(new RadioButtonListener(textBox));
        courier.addItemListener(new RadioButtonListener(textBox));
                
		
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

/**
 * Listener for the radio buttons.
 * Changes the font when a radio button is selected.
 */
class RadioButtonListener implements ItemListener
{
    JTextField textField;
    
    public RadioButtonListener(JTextField textField)
    {
        this.textField = textField;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e)
    {
        JRadioButton radioButton = (JRadioButton)e.getSource();
        
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
            if(textField.getText().equals(""))
            {
                textField.setText(radioButton.getText());
                textField.setFont(new Font(radioButton.getText(), Font.PLAIN, 12));
            }
            else if(textField.getText().startsWith("Bold Italic"))
            {
                textField.setText("Bold Italic " + radioButton.getText());
                textField.setFont(new Font(radioButton.getText(), Font.BOLD + Font.ITALIC, 12));
            }
            else if(textField.getText().startsWith("Italic Bold"))
            {
                textField.setText("Italic Bold " + radioButton.getText());
                textField.setFont(new Font(radioButton.getText(), Font.BOLD + Font.ITALIC, 12));
            }
            else if(textField.getText().startsWith("Bold"))
            {
                textField.setText("Bold " + radioButton.getText());
                textField.setFont(new Font(radioButton.getText(), Font.BOLD, 12));
            }
            else if(textField.getText().startsWith("Italic"))
            {
                textField.setText("Italic " + radioButton.getText());
                textField.setFont(new Font(radioButton.getText(), Font.ITALIC, 12));
            }
            else
            {
               textField.setText(radioButton.getText());
               textField.setFont(new Font(radioButton.getText(), Font.PLAIN, 12));
            }
        }
    }
}

/**
 * Listener for the check boxes.
 * Changes the font to bold and/or italic when a checkbox is ticked or unticked
 */
class CheckBoxListener implements ItemListener
{
    JTextField textField;
    
    public CheckBoxListener(JTextField textField)
    {
        this.textField = textField;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e)
    {
        JCheckBox checkBox = (JCheckBox)e.getSource();
        
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
            addTag(checkBox);
        }
        else
        {
            removeTag(checkBox);
        }
    }

    //Add bold/italic
    private void addTag(JCheckBox checkBox)
    {
        textField.setText(checkBox.getText() + " " + textField.getText());
        String fontName = textField.getText().replace("Bold ", "").replace("Italic ", "");
        if(textField.getText().contains("Bold") & textField.getText().contains("Italic"))
        {
            textField.setFont(new Font(fontName, Font.BOLD + Font.ITALIC, 12));
        }
        else if(textField.getText().contains("Bold"))
        {
            textField.setFont(new Font(fontName, Font.BOLD, 12));
        }
        else if (textField.getText().contains("Italic"))
        {
            textField.setFont(new Font(fontName, Font.ITALIC, 12));
        }
    }

    //Remove bold/italic
    private void removeTag(JCheckBox checkBox)
    {
        textField.setText(textField.getText().replace(checkBox.getText() + " ", ""));
        String fontName = textField.getText().replace("Bold ", "").replace("Italic ", "");
        if(textField.getText().contains("Bold"))
        {
            textField.setFont(new Font(fontName, Font.BOLD, 12));
        }
        else if (textField.getText().contains("Italic"))
        {
            textField.setFont(new Font(fontName, Font.ITALIC, 12));
        }
        else
        {
            textField.setFont(new Font(fontName, Font.PLAIN, 12));
        }
    }
}

/**
 * Listener for the button
 * Prints the current font to the console and exits the application
 */
class ButtonListener implements ActionListener
{
    JTextField textField;
    
    public ButtonListener(JTextField textField)
    {
        this.textField = textField;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(textField.getText());
        System.exit(0);
    }
    
}