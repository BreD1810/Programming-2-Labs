public class ThreadNumbers extends Thread
{

    public static void main(String[] args)
    {
        NumberedThread thread1 = new NumberedThread(1);
        NumberedThread thread2 = new NumberedThread(2);
        NumberedThread thread3 = new NumberedThread(3);
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
