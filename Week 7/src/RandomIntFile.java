import java.io.*;
import java.util.Random;

/**
 * Write 10000 random ints to a file using byte and char methods.
 * The byte method creates a much smaller file.
 */
public class RandomIntFile
{

    private int[] values;

    public static void main(String[] args)
    {
        RandomIntFile myProgram = new RandomIntFile();
        myProgram.values = myProgram.getRandomValues();
        myProgram.writeByteFile();
        myProgram.writeCharFile();
    }

    /**
     * Write to a file using a character method.
     */
    private void writeCharFile()
    {
        try
        {
            //Write the value to the file.
            FileWriter fw = new FileWriter("C:\\Users\\Brad\\Desktop\\RandomCharValues.txt");
            for(int value:values)
                fw.write(value + "\n");

            fw.flush();
            fw.close();
        }
        catch (IOException ioe)
        {
            System.err.println("Error writing for file.");
        }
    }

    /**
     * Write to a file using a byte method.
     */
    private void writeByteFile()
    {
        try
        {
            //Write the value to the file.
            FileOutputStream fos = new FileOutputStream("C:\\Users\\Brad\\Desktop\\RandomByteValues.txt");
            for(int value:values)
                fos.write(value);

            fos.flush();
            fos.close();
        }
        catch (IOException ioe)
        {
            System.err.println("Error writing for file.");
        }
    }

    /**
     * Generate 10000 random integer values
     * @return An array of random integer values.
     */
    private int[] getRandomValues()
    {
        //Generate the random values.
        int[] values = new int[10000];
        Random rand = new Random();
        for(int i = 0; i < 10000; i++)
        {
            values[i] = rand.nextInt(10000)+1;
        }

        return values;
    }

}
