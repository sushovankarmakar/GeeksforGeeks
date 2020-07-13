import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 13.07.2020
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
// https://www.youtube.com/watch?v=6ZRhq2oFCuo (a video explanation)

/* IDEA :
 For every vertex 'V',
 if there is an adjacent node 'U' and that node is visited but that node is not V's parent
 then there is a cycle.
 */

class Graph_DetectCycleInUndirectedGraph {

	static boolean isCyclic(Graph graph) {
		boolean[] visited = new boolean[graph.vertex];

		/*  this graph can be disconnected graph,
			so to cover all the nodes of the graph, we are running this for loop
		*/
		for (int i = 0; i < graph.vertex; i++) {
			int sourceNode = i;
			int parentNode = -1;
			if(!visited[i]) {
				if(isCyclicUtil(graph, sourceNode, visited, parentNode)) {
					return true;
				}
			}
		}
		return false;
	}

	// below function is just a modified DFS algorithm
	static boolean isCyclicUtil(Graph graph, int sourceNode, boolean[] visited, int parentNode) {
		visited[sourceNode] = true;
		for (int node : graph.adjListArray[sourceNode]) {
			if (!visited[node]) {
				if (isCyclicUtil(graph, node, visited, sourceNode)) {
					return true;
				}
			} else if (node != parentNode) {
				return true;
			}
		}
		return false;
	}

	static class Graph {
		int vertex;
		List<Integer>[] adjListArray;
		
		Graph(int vertex){
			this.vertex = vertex;
			adjListArray = new LinkedList[vertex];
			for (int i = 0; i < vertex; i++) {
				adjListArray[i] = new LinkedList<>();
			}
		}
	}
	
	static void addEdges(Graph graph, int src, int dest) {
		graph.adjListArray[src].add(dest);
		graph.adjListArray[dest].add(src);
	}
	
	static void printGraph(Graph graph) {
		for (int i = 0; i < graph.vertex; i++) {
			System.out.print(i);
			for (Integer n : graph.adjListArray[i]) {
				System.out.print("-> "+n);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String[] nm = br.readLine().trim().split("\\s+"), uv = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
			Graph graph = new Graph(n);
			for (int i = 0; i < uv.length; i+=2) {
				int src = Integer.parseInt(uv[i]), dest = Integer.parseInt(uv[i+1]);
				addEdges(graph, src, dest);
			}
			printGraph(graph);
			System.out.println((isCyclic(graph)?"1":"0"));
		}
	}
}
