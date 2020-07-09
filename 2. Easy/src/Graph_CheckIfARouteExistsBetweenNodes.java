import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/
// https://github.com/golumall/Graph-Connectivity/blob/master/Check%20If%20there%20is%20a%20path%20between%20two%20vertices%20DFS.java

public class Graph_CheckIfARouteExistsBetweenNodes {
    boolean result;
    boolean[] isVisited;

    private boolean routeBetweenNodes(int source, int destination, int n, List<List<Integer>> edges) {
        isVisited = new boolean[n+1];

        List<List<Integer>> adjList = getAdjacencyList(n, edges);   //converting edges list into adjacency list

        result = false;
        isPath(source, destination, adjList);
        return result;
    }

    private List<List<Integer>> getAdjacencyList(int n, List<List<Integer>> edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int source = edge.get(0);
            int destination = edge.get(1);
            addEdges(source, destination, adjList);
        }
        return adjList;
    }

    private void addEdges(int source, int destination, List<List<Integer>> adjList) {
        adjList.get(source).add(destination);   // it is a directed graph
    }

    private void isPath(int src, int dest, List<List<Integer>> adjList) {
        isVisited[src] = true;
        for(int node : adjList.get(src)) {

            if(node == dest) {
                result = true;
                return;
            }

            if(!isVisited[node]) {
                isPath(node, dest, adjList);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int p = 0 ; p < t ; p++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            List<List<Integer>> edges = new ArrayList<>();

            // here we get the edges list, we need to convert it into adjacency list later on
            for(int i=0;i<m;i++){
                edges.add(new ArrayList<>());
                edges.get(i).add(scanner.nextInt());
                edges.get(i).add(scanner.nextInt());
            }
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            Graph_CheckIfARouteExistsBetweenNodes answer = new Graph_CheckIfARouteExistsBetweenNodes();
            boolean result = answer.routeBetweenNodes(src, dest, n, edges);
            System.out.println((result) ? "yes" : "no");
        }
        scanner.close();
    }
}
