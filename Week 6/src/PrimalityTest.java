public class PrimalityTest implements Runnable
{

    private IntList list;

    public PrimalityTest(IntList list)
    {
        this.list = list;
    }

    public void run()
    {
        //Infinitely loop through all of the values until interrupted
        while(true)
        {
            //Get the value
            Integer value = list.get();

            //If the thread is interrupted, break out of the run.
            if(Thread.interrupted())
            {
                break;
            }

            //Check the value is prime
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
