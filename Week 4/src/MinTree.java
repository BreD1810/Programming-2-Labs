public class MinTree
{

    Tree tree = new Tree( 24,
            new Tree( 45,
                    null ,
                    new Tree(8, null , null) ) ,
            new Tree ( 17,
                    new Tree (74 , null , null ) ,
                    null ) );

    public static void main(String[] args)
    {
        MinTree mt = new MinTree();
        System.out.println("Minimum is: " + mt.findMin());
    }

    public int findMin()
    {
        return findMinAux(tree, tree.getVal());
    }

    private int findMinAux(Tree tree, int current)
    {
        if(tree.getVal() < current)
        {
            current = tree.getVal();
        }

        if(tree.left() == null && tree.right() == null)
        {
            return current;
        }

        int leftMin = 100;
        int rightMin = 100;

        if(tree.left() != null)
        {
            leftMin = findMinAux(tree.left(), current);
        }

        if(tree.right() != null)
        {
            rightMin = findMinAux(tree.right(), current);
        }

        if(leftMin > rightMin)
        {
            return rightMin;
        }
        else{
            return leftMin;
        }
    }

}

class Tree
{

    private int val;
    private Tree left, right;

    public Tree(int val, Tree left, Tree right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal()
    {
        return val;
    }

    public Tree left()
    {
        return left;
    }

    public Tree right()
    {
        return right;
    }
}