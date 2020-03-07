import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Iterator;

// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
// https://www.geeksforgeeks.org/iterative-depth-first-traversal/
// 

class DFS_ofGraph {

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
	
	static void addEdges(Graph graph, int src, int dest) {
		graph.adjListArray[src].add(dest);
		graph.adjListArray[dest].add(src);
	}
	
	
	// iterative solution using stack : 
	// Note that the above implementation prints only vertices that are reachable from a given vertex
	/*static void dfs(Graph graph,int s) {
		boolean visited[] = new boolean[graph.v];
		LinkedList<Integer> stack = new LinkedList<>();
		visited[s] = true;
		stack.push(s);
		
		while(!stack.isEmpty()) {
			s = stack.pop();
			System.out.print(s+" ");
			
			Iterator<Integer> i = graph.adjListArray[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					stack.push(n);
				}
			}
		}
		System.out.println();
	}*/
	
	static void dfsUtil(Graph graph,int s, boolean visited[]) {
		LinkedList<Integer> stack = new LinkedList<>();
		visited[s] = true;
		stack.push(s);
		
		while(!stack.isEmpty()) {
			s = stack.pop();
			System.out.print(s+" ");
			
			Iterator<Integer> i = graph.adjListArray[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					stack.push(n);
				}
			}
		}
	}
	
	static void dfs(Graph graph) {
		boolean visited[] = new boolean[graph.v];
		
		for (int i = 0; i < graph.v; i++) {
			if(!visited[i]) {
				dfsUtil(graph,i,visited);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+");
			Graph graph = new Graph(2*n);
			for (int i = 0; i < 2*n; i+=2) {
				int src = Integer.parseInt(ip[i]), dest = Integer.parseInt(ip[i+1]);
				addEdges(graph,src,dest);
			}
			int s = Integer.parseInt(ip[0]);
			//dfs(graph,s);
			dfs(graph);
		}
	}
}
