import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class SCC_KosarajuAlgo {

	static class Graph{
		int v;
		LinkedList<Integer> adjListArray[];
		Graph(int v){
			this.v = v;
			adjListArray = new LinkedList[v];
			for (int i = 1; i < v; i++) {
				adjListArray[i] = new LinkedList<>();
			}
		}
	}
	
	static void addEdges(Graph graph,int src, int dest) {
		graph.adjListArray[src].add(dest);
	}
	
	static void printList(Graph graph) {
		for (int i = 1; i < graph.v; i++) {
			System.out.print(i);
			for (Integer a : graph.adjListArray[i]) {
				System.out.print("-> "+a);
			}
			System.out.println();
		}
	}

	
	static int scc(Graph graph) {
		Set<Integer> visited = new HashSet<Integer>();
		LinkedList<Integer> stack = new LinkedList<Integer>();
		
		for (int i = 1; i < graph.v; i++) {
			sccUtil(graph,i,visited,stack);
		}
		
		/*while(stack.size() > 0) {
			System.out.print(stack.pop()+" ");
		}
		System.out.println();*/
		
		visited.clear();
		
		// reversing the edges
		Graph revGraph = reverseGraph(graph);
		//printList(revGraph);
		
		int noOfScc = 0;
		while(stack.size() > 0) {
			int a = stack.pop();
			if(!visited.contains(a)) {
				sccUtilForRevGraph(revGraph, a, visited);
				noOfScc++;
			}
		}
		return noOfScc;
	}
	
	static void sccUtil(Graph graph, int v, Set<Integer> visited, LinkedList<Integer> stack) {
		if(!visited.contains(v)) {
			visited.add(v);
			for (Integer a : graph.adjListArray[v]) {
				sccUtil(graph,a,visited,stack);
			}
			stack.push(v);
		}
	}
	
	static void sccUtilForRevGraph(Graph revGraph, int v, Set<Integer> visited) {
		if(!visited.contains(v)) {
			visited.add(v);
			for (Integer a : revGraph.adjListArray[v]) {
				sccUtilForRevGraph(revGraph, a, visited);
			}
		}
	}
	
	static Graph reverseGraph(Graph graph) {
		Graph revGraph = new Graph(graph.v);
		for (int i = 1; i < graph.v; i++) {
			for (Integer a : graph.adjListArray[i]) {
				int src = a;
				int dest = i;
				addEdges(revGraph, src, dest);
			}
		}
		return revGraph;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String nm[] = br.readLine().trim().split("\\s+"), uv[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
			Graph graph = new Graph(n+1);
			for (int i = 0; i < uv.length; i+=2) {
				int src = Integer.parseInt(uv[i]), dest = Integer.parseInt(uv[i+1]);;
				addEdges(graph, src, dest);
			}
			printList(graph);
			System.out.println(scc(graph));
		}
	}
}
