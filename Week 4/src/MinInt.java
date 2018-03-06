/**
 * MinInt - Return the minimum integer in an array using recursion.
 */
public class MinInt
{

    private int[] arr = {24,52,74,9,34,23,64,34};

    public static void main(String[] args)
    {
        MinInt m = new MinInt();
        System.out.println("Minimum is: " + m.findMin());
    }

    private int findMin()
    {
        //Call the auxiliary function
        return findMinAux(arr.length-1, arr.length-1);
    }

    private int findMinAux(int index, int minIndex)
    {
        //If it's not the first element in the array...
        if(index > 0)
        {
            if(arr[index] < arr[minIndex])
            {
                //If the minimum is updated, change the minIndex
                return findMinAux(index-1, index);
            }
            else
            {
                //Otherwise, increase the list with detemined minimum's size
                return findMinAux(index-1, minIndex);
            }
        }
        //If it's the first element in the array, return the minimum value
        return arr[minIndex];
    }
}