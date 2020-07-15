import java.util.Scanner;

// 15.07.2020
// https://practice.geeksforgeeks.org/problems/bipartite-graph/1
// https://www.youtube.com/watch?v=MtFPqCcsoeA (Good video explanation)
// https://www.geeksforgeeks.org/bipartite-graph/

public class Graph_CheckIsBipartiteGraph {

    private static boolean isBipartite(int[][] adjMatrix, int vertex) {
        boolean[] isVisited = new boolean[vertex];
        int[] colorOfNodes = new int[vertex];

        int startingNode = 0;   // we are starting with node 0 and color 0
        int color = 0; // there are only two color : 0 and 1

        // this graph can disconnected also, check for all the nodes of the graph
        for(int i = 0; i < vertex; i++) {
            if(!isVisited[i]) {
                startingNode = i;
                if(!isBipartiteUtil(startingNode, color, isVisited, colorOfNodes, adjMatrix)) {
                    return false;
                }
            }
        }
        return true;
    }

    // this below function is just another dfs.
    private static boolean isBipartiteUtil(int currentNode, int color, boolean[] isVisited, int[] colorOfNodes,
                                           int[][] adjMatrix) {
        isVisited[currentNode] = true;
        colorOfNodes[currentNode] = color;

        for (int j = 0; j < adjMatrix[currentNode].length; j++) {
            if(adjMatrix[currentNode][j] == 1) {

                if(!isVisited[j]) {     // if neighbourNode is not visited yet, then traverse the node with opposite color
                    if(!isBipartiteUtil(j, color ^1, isVisited, colorOfNodes, adjMatrix)) {
                        return false;
                    }
                }
                // if neighbourNode is already visited and currentNode and neighbourNode have same color, bipartite graph can't be possible, so return false
                else if(colorOfNodes[currentNode] == colorOfNodes[j]) {
                    return false;
                }
            }
        }
        return true; // done checking all the neighbourNodes of currentNode, all neighbourNodes have opposite color, so it is bipartite graph, return true
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--> 0){
            int vertex = sc.nextInt();
            int[][] adjMatrix = new int[vertex][vertex];
            for(int i = 0; i < vertex; i++) {
                for(int j = 0; j < vertex; j++) {
                    adjMatrix[i][j] = sc.nextInt();
                }
            }
            System.out.println(isBipartite(adjMatrix, vertex) ? "1" : "0");
        }
    }
}
