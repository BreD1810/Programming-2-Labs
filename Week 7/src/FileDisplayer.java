import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Display the contents of a selected file.
 */
public class FileDisplayer extends JFrame
{

    public static void main(String[] args)
    {
        FileDisplayer myProgram = new FileDisplayer();
    }

    public FileDisplayer()
    {
        super("File Displayer");
        init();
    }

    /**
     * Initialise the GUI components.
     */
    private void init()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        setContentPane(mainPanel);

        //Create the textarea with 10 lines, and scroll bar.
        JTextArea textArea = new JTextArea(10, 1);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

        //Select the file the user wants to view when the button is pressed.
        JButton selectFile = new JButton("Select File");
        selectFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(mainPanel);
                File file = fileChooser.getSelectedFile();
                displayFile(file, textArea);
            }
        });

        mainPanel.setLayout(new GridLayout(2, 1));
        mainPanel.add(scrollPane);
        mainPanel.add(selectFile);

        pack();
        setVisible(true);
    }

    /**
     * Display the contents of the selected file in the JTextArea
     * @param file The file to be displayed.
     * @param textArea The text area the file is to be displayed in.wd
     */
    private void displayFile(File file, JTextArea textArea)
    {
        textArea.setText("");
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader(file));
            for(String line; (line=br.readLine()) != null;)
            {
                textArea.setText(textArea.getText() + line + "\n");
            }

        }
        catch (IOException ioe)
        {
            System.err.println("Error reading file.");
        }
        finally
        {
            try
            {
                if (br != null)
                    br.close();
            }
            catch(IOException ioe) { }
        }

        this.repaint();
    }

}
