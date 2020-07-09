import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 09.07.2020
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


// below is the OLD IMPLEMENTATION
/*
class BFS_ofGraph {

	static class Graph {
		int v;
		LinkedList<Integer> adjListArray[];
		Graph(int v){
			this.v = v;
			adjListArray = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adjListArray[i] = new LinkedList<>();
			}
		}
	}

	static void addEdges(Graph graph, int src, int dest) {
		graph.adjListArray[src].add(dest);
		graph.adjListArray[dest].add(src);
	}

	static void bfs(Graph graph,int s) {
		boolean visited[] = new boolean[graph.v];
		LinkedList<Integer> queue = new LinkedList<>();
		visited[s] = true;
		queue.add(s);

		while(!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s+" ");

			Iterator<Integer> i = graph.adjListArray[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+");
			Graph graph = new Graph(2*n);
			for (int i = 0; i < 2*n; i+=2) {
				//System.out.println(i);
				int src = Integer.parseInt(ip[i]);
				int dest = Integer.parseInt(ip[i+1]);
				addEdges(graph, src, dest);
			}
			bfs(graph,Integer.parseInt(ip[0]));
		}
	}
}
*/
