import java.util.Random;

public class PrimeApp
{

    private static IntList list = new IntList();

    public static void main(String[] args)
    {
        System.out.println(args[0] + " values " + args[1] + " threads.");
        generateList(Integer.valueOf(args[0]));
        threadThings(Integer.valueOf(args[1]));
    }

    /**
     * Generate the list of values to be checked.
     * @param noValues Number of values to be added.
     */
    private static void generateList(int noValues)
    {
        Random rand = new Random();
        for(int i = 0; i < noValues; i++)
        {
            list.add(rand.nextInt(1000) + 1);
        }
    }

    /**
     * Start a set number of threads on the same list
     * @param noThreads Number of threads to be created.
     */
    private static void threadThings(int noThreads)
    {
        for(int i = 0; i < noThreads; i++)
        {
            Thread thread = new Thread(new PrimalityTest(list));
            thread.start();
        }
    }

}
