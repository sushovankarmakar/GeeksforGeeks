import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

// solved it correctly but while submitting I got wrong answer 
// 10 16
// 6 1 1 4 3 7 2 7 3 3 9 2 4 4 4 9 9 3 8 3 2 9 5 4 3 9 4 9 5 5 7 3
// so, submitted another solution found in comment section

class SCC_TarjansAlgo {

	static class Graph{
		int v;
		LinkedList<Integer> adjListArray[];
		Graph(int v){
			this.v = v;
			adjListArray = new LinkedList[v];
			
			for (int i = 0; i < v; i++) {
				adjListArray[i] = new LinkedList<Integer>();
			}
		}
	}
	
	static void addEdges(Graph graph, int src, int dest) {
		graph.adjListArray[src].add(dest);
	}
	
	static void printList(Graph graph) {
		for (int i = 0; i < graph.v; i++) {
			System.out.print(i);
			for (Integer adj : graph.adjListArray[i]) {
				System.out.print("-> "+adj);
			}
			System.out.println();
		}
	}

	
	static int time = 0;
	static StringBuilder sb = new StringBuilder();
	static void scc(Graph graph) {
		Map<Integer,Integer> visitedTime = new HashMap<>(), lowTime = new HashMap<>();
		LinkedList<Integer> stack = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		
		for (int i = 0; i < graph.v; i++) {
			if(!visited.contains(i)) {
				sccUtil(graph,i,visitedTime,lowTime,stack,visited);
			}
		}
		
	}
	
	static void sccUtil(Graph graph, int v, Map<Integer, Integer> visitedTime, Map<Integer, Integer> lowTime,
			LinkedList<Integer> stack, Set<Integer> visited) {
		visited.add(v);
		stack.push(v);
		visitedTime.put(v, time);
		lowTime.put(v, time);
		time++;
		for (Integer adj : graph.adjListArray[v]) {
			if(!visited.contains(adj)) {
				sccUtil(graph,adj,visitedTime,lowTime,stack,visited);
			}
			if(stack.contains(adj)) {
				int minTime = Math.min(lowTime.get(adj), lowTime.get(v));
				lowTime.put(v, minTime);
			}
		}
		
		if(visitedTime.get(v)==lowTime.get(v)) {
			
			for (int node = stack.pop(); ; node = stack.pop()) {
				//System.out.print(node);
				sb.append(node);
				if(node == v) break;
				//System.out.print(" ");
				sb.append(" ");
			}
			//System.out.print(",");
			sb.append(",");
		}
		/*System.out.println(visitedTime);
		System.out.println(lowTime);*/
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String nm[] = br.readLine().trim().split("\\s+"), uv[] = br.readLine().trim().split("\\s+");
			int vertices = Integer.parseInt(nm[0]), edges = Integer.parseInt(nm[1]);
			Graph graph = new Graph(vertices);
			for (int i = 0; i < uv.length; i+=2) {
				int src = Integer.parseInt(uv[i]), dest = Integer.parseInt(uv[i+1]);
				addEdges(graph,src,dest);
			}
			printList(graph);
			scc(graph);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
