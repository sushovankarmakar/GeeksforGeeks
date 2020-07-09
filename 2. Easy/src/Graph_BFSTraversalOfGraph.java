import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
// https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
// https://www.youtube.com/watch?v=60yo4vvRU5s

class Graph_BFSTraversalOfGraph {

	private static List<Integer> bfs(List<List<Integer>> adjList, int noOfVertexes) {
		boolean[] isVisited = new boolean[noOfVertexes];
		LinkedList<Integer> queue = new LinkedList<>();
		List<Integer> listOfNodes = new ArrayList<>();

		int startingNode = 0;
		isVisited[startingNode] = true;
		queue.add(startingNode);

		while(!queue.isEmpty()) {
			startingNode = queue.poll();
			listOfNodes.add(startingNode);

			for (int node : adjList.get(startingNode)) {
				if (!isVisited[node]) {
					isVisited[node] = true;
					queue.add(node);
				}
			}
		}
		return listOfNodes;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String[] nm = br.readLine().trim().split("\\s+");
			int noOfVertexes = Integer.parseInt(nm[0]);
			int noOfEdges = Integer.parseInt(nm[1]);

			String[] edges = br.readLine().trim().split("\\s+");
			List<List<Integer>> adjList = getAdjacencyList(noOfVertexes, edges);

			List<Integer> result = bfs(adjList, noOfVertexes);
			print(result);
		}
	}

	private static List<List<Integer>> getAdjacencyList(int noOfVertexes, String[] edges) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < noOfVertexes; i++) {
			adjList.add(i, new ArrayList<>());
		}
		for (int i = 0; i < edges.length; i+=2) {
			int sourceNode = Integer.parseInt(edges[i]);
			int destinationNode = Integer.parseInt(edges[i+1]);
			adjList.get(sourceNode).add(destinationNode);	// it is a directed graph
		}
		return adjList;
	}

	private static void print(List<Integer> result) {
		StringBuilder sb = new StringBuilder();
		for (int node : result) {
			sb.append(node + " ");
		}
		System.out.println();
	}
}
