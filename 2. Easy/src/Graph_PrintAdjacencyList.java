import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

// https://practice.geeksforgeeks.org/problems/print-adjacency-list/0
// https://www.geeksforgeeks.org/graph-and-its-representations/

class Graph_PrintAdjacencyList {

	static class Graph {
		int v;
		LinkedList<Integer>[] adjListArray;
		Graph(int v){
			this.v = v;
			adjListArray = new LinkedList[v];
			
			for (int i = 0; i < v; i++) {
				adjListArray[i] = new LinkedList<>();
			}
		}
	}
	
	static void addEdge(Graph graph, int src,int dest) {
		graph.adjListArray[src].add(dest);
		graph.adjListArray[dest].add(src);
	}
	
	static void printGraph(Graph graph) {
		for (int i = 0; i < graph.v; i++) {
			System.out.print(i);
			for (Integer adj : graph.adjListArray[i]) {
				System.out.print("-> " + adj);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String[] ve = br.readLine().trim().split("\\s+");
			int v = Integer.parseInt(ve[0]), e = Integer.parseInt(ve[1]);
			Graph graph = new Graph(v);
			while(e-->0) {
				String[] ip = br.readLine().trim().split("\\s+");
				int src = Integer.parseInt(ip[0]), dest = Integer.parseInt(ip[1]); 
				addEdge(graph, src, dest);
			}
			printGraph(graph);
		}
	}
}
