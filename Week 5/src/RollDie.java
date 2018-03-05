import java.util.Random;

public class RollDie implements Runnable
{

    Die die = new Die();

    public static void main(String[] args)
    {
        RollDie dice = new RollDie();
        dice.run();
    }

    public void run()
    {
        Random rand = new Random();
        int numberOfRolls = rand.nextInt(20)+1;
        for(int i = 0; i < numberOfRolls; i++)
        {
            int faceValue = rand.nextInt(6)+1;
            System.out.println(faceValue);
            die.updateVal(faceValue);
            try
            {
                Thread.sleep(50*i);
            }
            catch(InterruptedException e)
            {
                System.err.println("Thread interrupted.");
            }
        }
    }

}
