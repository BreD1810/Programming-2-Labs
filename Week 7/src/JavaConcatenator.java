import java.io.*;

/**
 * Concatenate all java files in a supplied directory into a single java file.
 */
public class JavaConcatenator
{

    public static void main(String[] args)
    {
        JavaConcatenator myProgram = new JavaConcatenator();
        String dirName = myProgram.getDir();
        String fileName = myProgram.getFile();
        myProgram.concatenate(dirName, fileName);
    }

    /**
     * Add all contents to one file.
     * @param dirName The directory to be searched.
     * @param fileName The file name to be output to.
     */
    private void concatenate(String dirName, String fileName)
    {
        File directory = new File(dirName);
        BufferedWriter bw;
        BufferedReader br;

        try
        {
            bw = new BufferedWriter(new FileWriter(dirName+ "\\" + fileName + ".java"));

            //Search all of the files in the directory.
            for (File file:directory.listFiles())
            {
                //If they are java files
                if(!file.isDirectory() && (file.getName().contains(".java")))
                {
                    //Write every line to the new file.
                    System.out.println("Reading " + file.getName());
                    br = new BufferedReader(new FileReader(file));
                    for(String line; (line=br.readLine()) != null;)
                    {
                        bw.write(line + "\n");
                    }
                }
            }
            bw.flush();
            bw.close();
        }
        catch (IOException ioe)
        {
            System.err.println("Error writing to file.");
        }

    }

    /**
     * Get the file to be written to.
     * @return The file name.
     */
    private String getFile()
    {
        String fileName = null;
        System.out.println("Please enter the filename you want.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            fileName = br.readLine();
        }
        catch (IOException ioe)
        {
            System.err.println("Error reading from console.");
        }
        return fileName;
    }

    /**
     * Get the directory to be used.
     * @return The directory name.
     */
    private String getDir()
    {
        String directory = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean continueLoop = true;

        while (continueLoop)
        {
            System.out.println("Please enter the directory that you wish to access.");

            try
            {
                directory = br.readLine();
            }
            catch (IOException ioe)
            {
                System.err.println("Error reading console input.");
            }

            //Ensure the slashes are correct.
            directory = directory.replace("\\", "\\\\");
            directory = directory.replace("/", "\\\\");

            File file = new File(directory);
            if(!file.isDirectory())
            {
                System.out.println("This is not a valid directory.");
            }
            else
            {
                System.out.println("You have entered a valid directory.");
                continueLoop = false;
            }
        }

        return directory;
    }

}
