import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;


class Graph_DetectCycleInDirectedGraph {

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
		//graph.adjListArray[dest].add(src);
	}
	
	static boolean hasCycle(Graph graph) {
		Set<Integer> whiteSet = new HashSet<>();
		Set<Integer> graySet = new HashSet<>();
		Set<Integer> blackSet = new HashSet<>();
		
		for (int i = 0; i < graph.v; i++) {
			whiteSet.add(i);
		}
		
		/*for (int i = 0; i < whiteSet.size(); i++) {
			if(dfs(graph,i,whiteSet,graySet,blackSet)) {
				return true;
			}
		}*/
		
		for (int i = 0; i < graph.v; i++) {
			for (Integer a : graph.adjListArray[i]) {
				if(dfs(graph,i,whiteSet,graySet,blackSet)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	static boolean dfs(Graph graph, int i, Set<Integer> whiteset, Set<Integer> grayset, Set<Integer> blackset) {
		moveVertex(i, whiteset, grayset);
		for (Integer integer : graph.adjListArray[i]) {
			if(blackset.contains(integer)) continue;
			if(grayset.contains(integer))	return true;
			if(dfs(graph,integer,whiteset,grayset,blackset)) return true;
		}
		moveVertex(i, grayset, blackset);
		return false;
	}
	
	static void moveVertex(int i, Set<Integer> srcSet, Set<Integer> destSet) {
		srcSet.remove(i);
		destSet.add(i);
	}
	
	static void printGraph(Graph graph) {
		for (int i = 0; i < graph.v; i++) {
			System.out.print(i);
			for (Integer a : graph.adjListArray[i]) {
				System.out.print("-> "+ a);
			}
			System.out.println();	
		}
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
			
			System.out.println(hasCycle(graph)?"1":"0");
		}
	}
}
