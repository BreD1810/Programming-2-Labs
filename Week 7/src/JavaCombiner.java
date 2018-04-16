import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

/**
 * Concatenate all java files in a supplied directory into a single java file.
 */
public class JavaCombiner
{

    public static void main(String[] args)
    {
        JavaCombiner myProgram = new JavaCombiner();
        String dirName = myProgram.getDir();
        String fileName = myProgram.getFile();
        myProgram.concatenateFiles(dirName, fileName);
        myProgram.cleanup(dirName, fileName);
    }

    /**
     * Remove public access modifiers on classes, move imports to the top of the file.
     * @param dirName The directory the file is located in.
     * @param fileName The name of the file to be cleaned up.
     */
    private void cleanup(String dirName, String fileName)
    {
        File file = new File(dirName+ "\\" + fileName + ".java");
        File newFile = new File(dirName + "\\" + fileName + ".java.new");
        BufferedReader reader;
        BufferedWriter writer;
        ArrayList<String> imports = new ArrayList<String>();
        try
        {
            writer = new BufferedWriter(new FileWriter(newFile));
            reader = new BufferedReader(new FileReader(file));
            //Store all of the imports.
            for(String line; (line=reader.readLine()) != null;)
            {
                if(line.matches("import \\S+;") && !imports.contains(line))
                    imports.add(line);
            }

            //Write the imports
            for(String importLine:imports)
            {
                System.out.println(importLine);
                writer.write(importLine + "\n");
            }

            reader.close();
            reader = new BufferedReader(new FileReader(file));
            //Write the rest of the file.
            for(String line; (line = reader.readLine()) != null;)
            {
                if(!line.matches("import \\S+;") && !line.contains("public class"))
                {
                    writer.write(line + "\n");
                }
                else if (line.contains("public class"))
                {
                    line = line.replace("public class", "class");
                    writer.write(line + "\n");
                }
            }

            reader.close();
            writer.flush();
            writer.close();

            //file.delete();
            //Files.delete(file.toPath());
            //newFile.renameTo(file);
            Files.move(newFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException ioe)
        {
            System.err.println("Error writing to file/reading from file.");
        }
    }

    /**
     * Add all contents to one file.
     * @param dirName The directory to be searched.
     * @param fileName The file name to be output to.
     */
    private void concatenateFiles(String dirName, String fileName)
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
                    br.close();
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
