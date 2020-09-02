import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://leetcode.com/problems/clone-graph/
// https://www.geeksforgeeks.org/clone-an-undirected-graph/ (Good tutorial)
// https://github.com/bephrem1/backtobackswe/blob/master/Graphs/CloneAGraph/CloneAGraph.java
// https://www.youtube.com/watch?v=vma9tCQUXk8 (BEST Video explanation)

public class Graph_CloneConnectedUndirectedGraph {

    /* below code is simple BFS only*/
    private static GraphNode getClonedGraph(GraphNode startingNode) {
        if (startingNode == null) return null;  /* If the start node is null then we cannot do any cloning */

        Map<GraphNode, GraphNode> vertexMap = new HashMap<>();    /* vertexMap maps the original node reference to its clone */
        Queue<GraphNode> queue = new LinkedList<>();        /* queue for Breadth First Search */

        vertexMap .put(startingNode, new GraphNode(startingNode.value));
        queue.add(startingNode);    /* Add the start node to the queue. Give the start node a clone in the vertexMap */

        /*
         * The breadth first search continues until we have processed all vertices in
         * the original graph. We know this is done when the queue is empty
         */

        while (!queue.isEmpty()) {
            GraphNode currNode = queue.poll();  /* We grab a node. We will express all of the edges coming off of this node. */

            for (GraphNode neighbour : currNode.neighbours) {   /* Iterate over all adjacent neighbours */

                /* Has this neighbor been given a clone? */
                if (!vertexMap .containsKey(neighbour)) {

                    /*
                     * No? Give it a mapping and add the original neighbor to the search queue so we
                     * can express its edges later
                     */
                    vertexMap .put(neighbour, new GraphNode(neighbour.value));
                    queue.add(neighbour);
                }

                /*
                 * Draw the edge from currVertex's clone to neighbor's clone. Do you see how our
                 * hashtable makes this quick access possible
                 */
                vertexMap .get(currNode).neighbours.add(vertexMap .get(neighbour));
            }
        }

        return vertexMap.get(startingNode); /* Return the clone of the start. This is the entry point for the cloned graph section.*/
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            GraphNode actualStartingNode = buildGraph();
            System.out.println("BFS traversal of a graph before cloning");
            bfs(actualStartingNode);
            GraphNode clonedStartingNode = getClonedGraph(actualStartingNode);
            System.out.println("BFS traversal of a graph after cloning");
            bfs(clonedStartingNode);
        }
    }

    private static void bfs(GraphNode startingNode) {

        Queue<GraphNode> queue = new LinkedList<>();
        Map<GraphNode, Boolean> visited = new HashMap<>();

        queue.add(startingNode);
        visited.put(startingNode, true);

        while (!queue.isEmpty()) {
            GraphNode currNode = queue.poll();
            System.out.println("Value of the Node : " + currNode.value);
            System.out.println("Address of the Node : " + currNode);

            for(GraphNode neighbour : currNode.neighbours) {
                if (visited.get(neighbour) == null)  {
                    queue.add(neighbour);
                    visited.put(neighbour, true);
                }
            }
        }
        System.out.println();
    }

    private static GraphNode buildGraph() {

         /*
            Note : All the edges are Undirected
            Given Graph:
            1--2
            |  |
            4--3
        */

        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);

        List<GraphNode> neighbours = new ArrayList<>();
        neighbours.add(node2);
        neighbours.add(node4);
        node1.neighbours = neighbours;

        neighbours = new ArrayList<>();
        neighbours.add(node1);
        neighbours.add(node3);
        node2.neighbours = neighbours;

        neighbours = new ArrayList<>();
        neighbours.add(node2);
        neighbours.add(node4);
        node3.neighbours = neighbours;

        neighbours = new ArrayList<>();
        neighbours.add(node1);
        neighbours.add(node3);
        node4.neighbours = neighbours;

        return node1;
    }

    static class GraphNode {
        private int value;
        private List<GraphNode> neighbours;

        GraphNode(int value) {
            this.value = value;
            this.neighbours = new ArrayList<>();
        }
    }
}
