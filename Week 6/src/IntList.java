import java.util.ArrayList;

public class IntList
{

    private ArrayList<Integer> list = new ArrayList<Integer>();

    /**
     * Add an element to the list.
     * @param o The element to be added.
     */
    public synchronized void add(Integer o)
    {
        list.add(o);
    }

    /**
     * Return the first value in the list, and remove it.
     * @return The first value.
     */
    public synchronized Integer get()
    {
        //Only 1 thread can do this at a time because of synchronised
        //Interrupt the thread if empty
        if(list.isEmpty())
        {
            Thread.currentThread().interrupt();
            return null;
        }

        //otherwise, return the value
        int value = list.get(0);
        list.remove(0);
        return value;
    }

    /**
     * Check if the list is empty.
     */
    public synchronized boolean isEmpty()
    {
        return list.isEmpty();
    }

}
