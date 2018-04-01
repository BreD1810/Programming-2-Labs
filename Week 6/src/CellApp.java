/**
 * This originally breaks because t1 locks on c1, t2 locks on c2. Therefore, they do not block.
 */

class Cell {
    private static int counter=0;
    private int value, id;
    private static Object lock = new Object();

    public Cell(int v)
    {
        value=v;
        id=counter++;
    }

     int getValue()
    {
        synchronized (lock)
        {
            return value;
        }
    }

    void setValue(int v)
    {
        synchronized (lock)
        {
            value = v;
        }
    }

    void swapValue(Cell other)
    {
        synchronized (lock)
        {
            int t = getValue();
            int v = other.getValue();
            setValue(v);
            other.setValue(t);
        }
    }
}

class swapThread extends Thread
{
    Cell cell, othercell;
    public swapThread(Cell c, Cell oc){cell=c; othercell=oc;}
    public void run(){cell.swapValue(othercell);}
}

public class CellApp {

    public static void main(String[] args)
    {
        Cell c1 = new Cell(15);
        Cell c2 = new Cell(23);
        System.out.println("Original c1: " + c1.getValue() + " Original c2: " + c2.getValue());

        Thread t1 = new swapThread(c1,c2);
        Thread t2 = new swapThread(c2,c1);

        t1.start(); t2.start();
        System.out.println("New c1: " + c1.getValue()+ " New c2: " + c2.getValue());
    }
}