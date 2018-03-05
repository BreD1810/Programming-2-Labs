public class NumberedThread extends Thread
{

    private int number;

    public NumberedThread(int number)
    {
        this.number = number;
    }

    public void run()
    {
        System.out.println("My number is " + number);
        try
        {
            Thread.sleep(1000 + ((1/number) * 1000));
        }
        catch(InterruptedException e)
        {
            System.err.println("Thread " + number + " has been interrupted.");
        }
        System.out.println("Thread " + number + " has terminated.");
    }

}
