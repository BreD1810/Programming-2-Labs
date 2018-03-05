import java.sql.Array;

public class DynamicArray<T>
{

    private T[] array;
    private T[] tempArray;
    private int maxSize;

    public static void main(String[] args)
    {
        DynamicArray test = new DynamicArray(1, 95);
        //test.addElement("Test",0);
        //test.addElement("Test2",1);
        //test.addElement("Test3", 2);
        test.addElement("Test", 90);
        test.getElement(20);
    }

    public DynamicArray(int size, int maxSize)
    {
        this.maxSize = maxSize;
        setSize(size);
    }

    public void setSize(int size)
    {
        if(size < 0 || size > maxSize)
        {
            throw new ArrayIndexOutOfBoundsException("Trying to set size outside of the maximum index range.");
        }
        else
        {
            Class<T> type;
            array = (T[])new Object[size];
        }
    }

    public void addElement(T element, int index)
    {
        //tempArray = array.clone();
        //array = (T[])new Object[tempArray.length+1];
        //array = tempArray.clone();
        try
        {
            array[index] = element;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            tempArray = array.clone();
            array = (T[])new Object[tempArray.length+10];
            for(int i = 0; i < tempArray.length; i++)
            {
                array[i] = tempArray[i];
            }
            array[index] = element;
        }
    }

    public T getElement(int index)
    {
        if(index < 0 || index > maxSize)
        {
            throw new ArrayIndexOutOfBoundsException("Trying to access element outside of maximum index range.");
        }
        else
        {
            return array[index];
        }
    }
}
