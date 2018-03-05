public class ClockThread implements Runnable
{

    private Clock clock;
    private int h, m, s;

    public ClockThread(Clock clock)
    {
        this.clock = clock;
        h = 0;
        m = 0;
        s = 0;
    }

    public void updateTime(int h, int m, int s)
    {
        this.h = h;
        this.m = m;
        this.s = s;
    }

    public void run()
    {
        while(true)
        {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                System.err.println("Thread interrupted.");
            }
            s++;
            if (s >= 60)
            {
                s = 0;
                m++;
                if(m > 60)
                {
                    m = 0;
                    h++;
                    if(h > 12)
                    {
                        h = 0;
                    }
                }
            }
            clock.setTime(h, m , s);
        }
    }

}
