import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 13.07.2020
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
// https://www.youtube.com/watch?v=6ZRhq2oFCuo (a video explanation)
// https://www.youtube.com/watch?v=n_t0a_8H8VY

/* IDEA :
 For every vertex 'V',
 if there is an adjacent node 'U' and that node is visited but that node is not V's parent
 then there is a cycle.
 */

class Graph_DetectCycleInUndirectedGraph {

	private static boolean isCyclic(Graph graph) {
		boolean[] isVisited = new boolean[graph.vertex];

		/*  this graph can be disconnected graph,
			so to cover all the nodes of the graph, we are running this for loop
		*/
		for (int i = 0; i < graph.vertex; i++) {
			int sourceNode = i;
			int parentNode = -1;
			if(!isVisited[sourceNode]) {
				if(isCyclicUtil(graph, isVisited, sourceNode, parentNode)) {
					return true;
				}
			}
		}
		return false;
	}

	// below function is just a modified DFS algorithm
	private static boolean isCyclicUtil(Graph graph, boolean[] isVisited, int sourceNode, int parentNode) {
		isVisited[sourceNode] = true;
		for (int node : graph.adjListArray[sourceNode]) {
			if (!isVisited[node]) {
				if (isCyclicUtil(graph, isVisited, node, sourceNode)) {
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
