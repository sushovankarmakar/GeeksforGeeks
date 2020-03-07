import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class DetectCycleInUndirectedGraph {

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
	
	static void printGraph(Graph graph) {
		for (int i = 0; i < graph.v; i++) {
			System.out.print(i);
			for (Integer n : graph.adjListArray[i]) {
				System.out.print("-> "+n);
			}
			System.out.println();
		}
	}
	
	static boolean isCyclicUtil(Graph graph,int s,boolean visited[],int parent) {
		
		visited[s] = true;
		Iterator<Integer> i = graph.adjListArray[s].iterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				if(isCyclicUtil(graph, n, visited, s)) {
					return true;
				}
			}
			else if(n!= parent) {
				return true;
			}
		}
		return false;
	}
	
	static boolean isCyclic(Graph graph) {
		boolean visited[] = new boolean[graph.v];
		
		for (int i = 0; i < graph.v; i++) {
			if(!visited[i]) {
				if(isCyclicUtil(graph,i,visited,-1)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String nm[] = br.readLine().trim().split("\\s+"), uv[] = br.readLine().trim().split("\\s+");
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
