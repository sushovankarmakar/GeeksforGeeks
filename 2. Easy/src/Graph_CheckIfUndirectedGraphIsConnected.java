import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://thecodingsimplified.com/check-if-undirected-graph-is-connected/
// https://www.geeksforgeeks.org/graph-and-its-representations/
// https://algorithms.tutorialhorizon.com/check-if-given-undirected-graph-is-connected-or-not/

public class Graph_CheckIfUndirectedGraphIsConnected {

    private static boolean isGraphConnected(Graph graph) {
        int startingNode = 0;
        dfs(graph, startingNode);

        for (int i = 0; i < graph.isVisited.length; i++) {
            if(!graph.isVisited[i]) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(Graph graph, int startingNode) {
        boolean[] isVisited = graph.isVisited;
        List<List<Integer>> adjList = graph.adjList;
        //System.out.println("DFS from node " + startingNode);

        dfsUtil(startingNode, isVisited, adjList);

        //System.out.println();
    }

    private static void dfsUtil(int node, boolean[] isVisited, List<List<Integer>> adjList) {
        isVisited[node] = true;
        //System.out.print(node + " ");

        for (Integer integer : adjList.get(node)) {
            node = integer;

            if (!isVisited[node]) {
                dfsUtil(node, isVisited, adjList);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-->0) {
            int nodes = Integer.parseInt(br.readLine().trim()); // nodes is 7
            int edges = Integer.parseInt(br.readLine().trim());
            Graph graph = new Graph(nodes);
            /*for (int i = 0; i < edges; i++) {
                String[] nodeAB = br.readLine().trim().split("\\s+");
                int nodeA = Integer.parseInt(nodeAB[0]);
                int nodeB = Integer.parseInt(nodeAB[1]);
                graph.addEdges(nodeA, nodeB);
            }*/

            graph.addEdges(0, 1);
            graph.addEdges(0, 2);
            graph.addEdges(1, 3);
            graph.addEdges(2, 4);
            graph.addEdges(3, 5);
            graph.addEdges(4, 5);
            System.out.println(isGraphConnected(graph));    // now graph is not connected

            //graph.addEdges(4, 6);     //this edge will make the graph connected
            //System.out.println(isGraphConnected(graph));    // now graph is connected

            printGraph(graph);

            //int startingNode = 0;
            //dfs(graph, startingNode);
        }
    }

    private static void printGraph(Graph graph) {
        List<List<Integer>> adjList = graph.adjList;

        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    static class Graph {
        private int nodes;
        private List<List<Integer>> adjList;
        private boolean[] isVisited;

        Graph(int nodes) {
            this.nodes = nodes;
            adjList = new ArrayList<>();
            isVisited = new boolean[nodes];

            for(int i = 0; i < nodes; i++) {
                adjList.add(i, new ArrayList<>());
            }
        }

        private void addEdges(int sourceNode, int destinationNode) {
            adjList.get(sourceNode).add(destinationNode);
            adjList.get(destinationNode).add(sourceNode);
        }
    }
}
