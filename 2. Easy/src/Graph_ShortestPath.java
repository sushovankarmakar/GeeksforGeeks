import java.util.*;

// 10.07.2020
// https://www.geeksforgeeks.org/shortest-path-unweighted-graph/ (my solution is almost similar, but not exactly similar)
// https://www.youtube.com/watch?v=60yo4vvRU5s&t=479s (my solution is following this approach)
// Find the shortest path between 2 nodes in an undirected unweighted graph (crio.do)

public class Graph_ShortestPath {

    public static List<Integer> shortestPath(int n, List<List<Integer>> edges, int sourceNode, int destinationNode){

        List<List<Integer>> adjList = getAdjacencyList(n, edges);   //converting edge list into adjacency list
        int[] distanceFromRoot = bfs(n, adjList, sourceNode);   // storing the distance of each node from sourceNode using bfs

        /*for (int i: distanceFromRoot) {
            System.out.print(i + " ");
        }
        System.out.println();*/

        // we start from the destination node, use the distance array and goes up to the source node
        List<Integer> answer = new ArrayList<>();
        answer.add(destinationNode);
        int currNode = destinationNode;

        for (int i = 0; i <= distanceFromRoot[destinationNode]; i++) {
            for (int node : adjList.get(currNode)) {
                if(distanceFromRoot[node] == distanceFromRoot[currNode]-1) {
                    answer.add(node);
                    currNode = node;
                    break;
                }
            }
        }

        // below commented code don't work
        /*for(int i = 0; i < adjList.get(currNode).size(); i++) {
            int node = adjList.get(currNode).get(i);

            if(distanceFromRoot[node] == currDistance - 1) {
                answer.add(node);
                currNode = node;
                currDistance = distanceFromRoot[currNode];
            }
            if(currDistance == 0) break;
        }
        answer.add(sourceNode);*/

        Collections.reverse(answer);
        return answer;
    }

    private static int[] bfs(int n, List<List<Integer>> adjList, int sourceNode) {
        boolean[] isVisited = new boolean[n+1];
        int[] distanceFromRoot = new int[n+1];
        LinkedList<Integer> queue = new LinkedList<>();

        isVisited[sourceNode] = true;
        queue.offer(sourceNode);
        distanceFromRoot[sourceNode] = 0;

        while(!queue.isEmpty()) {
            sourceNode = queue.poll();

            for(int node : adjList.get(sourceNode)) {
                if(!isVisited[node]) {
                    isVisited[node] = true;
                    queue.offer(node);
                    distanceFromRoot[node] = distanceFromRoot[sourceNode] + 1;
                }
            }
        }
        return distanceFromRoot;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> edges = new ArrayList<>();

        for(int i=0; i<m; i++){
            edges.add(new ArrayList<>());
            edges.get(i).add(sc.nextInt());
            edges.get(i).add(sc.nextInt());
        }

        int source = sc.nextInt();
        int destination = sc.nextInt();

        List<Integer> ans = shortestPath(n, edges, source, destination);

        for (int i : ans) {
            System.out.println(i);
        }
    }

    private static List<List<Integer>> getAdjacencyList(int n, List<List<Integer>> edges) {
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

    private static void addEdges(int source, int destination, List<List<Integer>> adjList) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);   // it is a undirected graph
    }
}

