import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class DAGSortTest
{

    private int[][] edges;
    private DAGSort sorter;

    /**
     * Reset the edges and tester before running a test.
     */
    @Before
    public void setUp()
    {
        edges = null;
        sorter = new DAGSort();
    }

    /**
     * Test for a null input. A NullPointerException should be thrown.
     */
    @Test(expected = NullPointerException.class)
    public void nullInput() throws CycleDetectedException, InvalidNodeException
    {
        sorter.sortDAG(edges);
    }

    /**
     * Test for a null node. A NullPointerException should be thrown.
     */
    @Test(expected = NullPointerException.class)
    public void nullNodeValue() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{1}, null};
        sorter.sortDAG(edges);
    }

    /**
     * Test for a negative node value. An InvalidNodeException should be thrown.
     */
    @Test(expected = InvalidNodeException.class)
    public void invalidNodeNegative() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{-1, 1}, {1, 2}};
        sorter.sortDAG(edges);
    }

    /**
     * Test for connecting to a missing node. An InvalidNodeException should be thrown.
     */
    @Test(expected = InvalidNodeException.class)
    public void invalidNodeMissing() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{1, 2}};
        sorter.sortDAG(edges);
    }

    /**
     * Test for a cycle. A CycleDetectedException should be thrown.
     */
    @Test(expected = CycleDetectedException.class)
    public void cycle() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{0, 1}, {1, 0}};
        sorter.sortDAG(edges);
    }

    /**
     * Test for a loop. A CycleDetectedException should be thrown.
     */
    @Test(expected = CycleDetectedException.class)
    public void loopCycle() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{0}};
        sorter.sortDAG(edges);
    }

    /**
     * Test for a single node. The node itself should be returned.
     */
    @Test
    public void singleton() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{}};
        int[] expected = new int[]{0};
        int[] result = sorter.sortDAG(edges);
        assertArrayEquals("Singleton", expected, result);
    }

    /**
     * Test for multiple nodes with no connections.
     * This returns a list of the nodes. This is because of the required initial for loop in the algorithm.
     */
    @Test
    public void noConnections() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{}, {}, {}};
        int[] result = sorter.sortDAG(edges);
        assertTrue("Multiple nodes with no connections", checkCorrect(result));
    }

    /**
     * Test for a linear graph. 0 -> 1 -> 2/
     * The program should return 0, 1, 2.
     */
    @Test
    public void linearGraph() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{1}, {2}, {}};
        int[] result = sorter.sortDAG(edges);
        assertTrue("Linear Graph", checkCorrect(result));
    }

    /**
     * Test for a seperated graph (0 -> 1, 2 -> 3).
     * The program should return the 2 connected pairs in reverse order.
     */
    @Test
    public void seperatedGraph() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{1}, {}, {3}, {}};
        int[] result = sorter.sortDAG(edges);
        assertTrue("Seperated graph", checkCorrect(result));
    }

    /**
     * Test for all nodes being connected to a single node, like a tree.
     * This should return the root node, followed by the child nodes in reverse order.
     * @throws CycleDetectedException
     * @throws InvalidNodeException
     */
    @Test
    public void tree() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{1, 2, 3}, {}, {}, {}};
        int[] result = sorter.sortDAG(edges);
        assertTrue("Tree", checkCorrect(result));
    }

    /**
     * Test a normal graph - taken from the Wikipedia article
     */
    @Test
    public void normalGraph() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{1}, {2, 5, 7}, {}, {1, 4}, {5}, {}, {4, 7}, {}};
        int[] result = sorter.sortDAG(edges);
        assertTrue("Normal Graph", checkCorrect(result));
    }

    /**
     * Check if the result is valid.
     */
    private boolean checkCorrect(int[] result)
    {
        //If the lengths are different, it's wrong
        if(result.length != edges.length)
            return false;
        ArrayList<Integer> checkedNodes = new ArrayList<Integer>();
        for(int currentResult: result)
        {
            //If the node is repeated, it's wrong.
            if(checkedNodes.contains(currentResult))
                return false;
            for(int node : checkedNodes)
            {
                if(node == currentResult)
                    return false;
            }
            checkedNodes.add(currentResult);
        }
        return true;
    }

    //TODO: No cycle = works (orders properly).
    //TODO: Random order
    //TODO: 0 has a parent.
    //TODO: Check the graph is valid rather than if it is correct.
}
