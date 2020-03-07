import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class TopologicalSort {

	static class Graph{
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
	
	static void addEdges(Graph graph,int src,int dest) {
		graph.adjListArray[src].add(dest);
	}
	
	static void printList(Graph graph) {
		for (int i = 0; i < graph.v; i++) {
			System.out.print(i);
			for (Integer a : graph.adjListArray[i]) {
				System.out.print("-> "+a);
			}
			System.out.println();
		}
	}
	
	static void topoSortUtil(Graph graph,int v, Set<Integer> visited, LinkedList<Integer> sortedStack) {
		
		if(!visited.contains(v)) {
			visited.add(v);
			for (Integer a : graph.adjListArray[v]) {
				topoSortUtil(graph, a, visited, sortedStack);
			}
			sortedStack.push(v);
		}
	}
	static void topoSort(Graph graph) {
		Set<Integer> visited = new HashSet<Integer>();
		LinkedList<Integer> sortedStack = new LinkedList<>();
		
		for (int i = 0; i < graph.v; i++) {
			topoSortUtil(graph, i, visited, sortedStack);
		}
		
		while(sortedStack.size() > 0) {
			System.out.print(sortedStack.pop()+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String en[] = br.readLine().trim().split("\\s+"), uv[] = br.readLine().trim().split("\\s+");
			int e = Integer.parseInt(en[0]), n = Integer.parseInt(en[1]);
			Graph graph = new Graph(n);
			for (int i = 0; i < uv.length; i+=2) {
				int src = Integer.parseInt(uv[i]);
				int desc = Integer.parseInt(uv[i+1]);
				addEdges(graph, src, desc);
			}
			printList(graph);
			System.out.println();
			topoSort(graph);
		}
	}
}
