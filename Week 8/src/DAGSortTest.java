import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

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
     * Test for an empty array input - no nodes at all.
     * Should return an empty array.
     */
    @Test
    public void emptyEdges() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[0][];
        int[] expected = new int[0];
        int[] result = sorter.sortDAG(edges);
        assertArrayEquals("Empty", expected, result);
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
     * Test for a loop (which is a cycle). A CycleDetectedException should be thrown.
     */
    @Test(expected = CycleDetectedException.class)
    public void loop() throws CycleDetectedException, InvalidNodeException
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
     * Test a completely reversed graph.
     * This should return the the nodes in reverse order.
     */
    @Test
    public void reverseGraph() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{}, {0}, {1}};
        int[] expected = new int[]{2, 1, 0};
        int[] result = sorter.sortDAG(edges);
        assertArrayEquals("Linear Graph", expected, result);
    }

    /**
     * Test for a seperated graph (0 -> 1, 2 -> 3).
     * The program should return the 2 connected pairs.
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
     */
    @Test
    public void tree() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{1, 2, 3}, {}, {}, {}};
        int[] result = sorter.sortDAG(edges);
        assertTrue("Tree", checkCorrect(result));
    }

    /**
     * Test for a reversed tree (all nodes pointing to a single node.
     * Added a child to the root node also.
     */
    @Test
    public void reverseTree() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{4}, {0}, {0}, {0}, {}};
        int[] result = sorter.sortDAG(edges);
        assertTrue("Reverse Tree", checkCorrect(result));
    }

    /**
     * Test for when the 0th node has a node pointing to it.
     * This should return 3 as the first element.
     */
    @Test
    public void zeroParent() throws CycleDetectedException, InvalidNodeException
    {
        edges = new int[][]{{1}, {2}, {}, {0}};
        int[] result = sorter.sortDAG(edges);
        assertTrue("Zero has a parent", checkCorrect(result));
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
     * Test for a large tree.
     */
    @Test
    public void largeTree() throws CycleDetectedException, InvalidNodeException
    {
        Random rand = new Random();
        edges = new int[1000][];
        //Generate a tree with 1000 nodes.
        for(int i = 0; i < 999; i++)
        {
            //Each node can have a max of 50 connections
            int connectionNumber = rand.nextInt(999 - i);
            edges[i] = new int[connectionNumber];
            for(int j=0; j<connectionNumber; j++)
            {
                //Can be connected to any node from 0-999
                int node = rand.nextInt(999 -i) + (i+1);
                edges[i][j] = node;
            }
            edges[999] = new int[]{};
        }

        int[] result = sorter.sortDAG(edges);
        assertTrue("Large Tree", checkCorrect(result));
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

        for(int i=result.length-1; i>=0; i--)
        {
            if(checkedNodes.contains(result[i]) || result[i]<0 || result[i] >= edges.length)
                return false;
            for(int node : edges[result[i]])
            {
                if(!checkedNodes.contains(node))
                    return false;
            }
            checkedNodes.add(result[i]);
        }
        return true;
    }

}
