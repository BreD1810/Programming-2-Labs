import java.util.List;
import java.util.Random;
import java.util.Vector;

public class PrimalityTest implements Runnable
{

    private List<Integer> myValues;

    public static void main(String[] args)
    {
        Vector<Integer> values = generateVector();

        // 	subList(int fromIndex, int toIndex)
        //Returns a view of the portion of this List between fromIndex, inclusive, and toIndex, exclusive.
        //????????
        Thread tester1 = new Thread(new PrimalityTest(values.subList(0, 10)));
        Thread tester2 = new Thread(new PrimalityTest(values.subList(10, 20)));
        Thread tester3 = new Thread(new PrimalityTest(values.subList(20, 30)));
        Thread tester4 = new Thread(new PrimalityTest(values.subList(30, 40)));
        Thread tester5 = new Thread(new PrimalityTest(values.subList(40, 50)));
        Thread tester6 = new Thread(new PrimalityTest(values.subList(50, 60)));
        Thread tester7 = new Thread(new PrimalityTest(values.subList(60, 70)));
        Thread tester8 = new Thread(new PrimalityTest(values.subList(70, 80)));
        Thread tester9 = new Thread(new PrimalityTest(values.subList(80, 90)));
        Thread tester10 = new Thread(new PrimalityTest(values.subList(90, 100)));

        tester1.start();
        tester2.start();
        tester3.start();
        tester4.start();
        tester5.start();
        tester6.start();
        tester7.start();
        tester8.start();
        tester9.start();
        tester10.start();
    }

    public PrimalityTest(List<Integer> list)
    {
        myValues = list;
    }

    private static Vector<Integer> generateVector()
    {
        Random rand = new Random();
        Vector<Integer> values = new Vector<Integer>();
        for(int i = 0; i < 100; i++)
        {
            values.add(rand.nextInt(1000)+1);
        }
        return values;
    }

    public void run()
    {
        for(Integer value:myValues)
        {
            if(checkPrime(value))
            {
                System.out.println("Int " + value + " is prime.");
            }
            else
            {
                System.out.println("Int " + value + " is not prime.");
            }
        }
    }

    private boolean checkPrime(int n) {
        int primes55[] = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,
                53,59,61,67,71,73,79,83,89,97,101,103,107,
                109,113,127,131,137,139,149,151,157,163,
                167,173,179, 181,191,193,197,199,211,223,
                227,229,233,239,241,251,257};

        for(int i=0;i < 55;i++) {
            if (n % primes55[i] == 0) {
                if (n == primes55[i]) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }

        int maxtest = n/16;

        for(int i=259; i < maxtest; i+=2)
            if (n % i == 0)
                return false;

        return true;
    }

}
