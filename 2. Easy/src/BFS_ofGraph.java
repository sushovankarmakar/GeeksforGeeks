import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

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
