import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;


class MinSpanningTree {

	static class Pair {
		int dest, weight;
		Pair(int dest,int weight){
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	static class Graph{
		int v;
		LinkedList<Pair> adjListArray[];
		Graph(int v){
			this.v  = v;
			adjListArray = new LinkedList[v];
			for (int i = 1; i < v; i++) {
				adjListArray[i] = new LinkedList<>(); 
			}
		}
	}
	
	static void addEdges(Graph graph,int src,int dest,int weight) {
		Pair pair1 = new Pair(dest,weight);
		Pair pair2 = new Pair(src,weight);
		graph.adjListArray[src].add(pair1);
		graph.adjListArray[dest].add(pair2);
	}
	
	static void printList(Graph graph) {
		for (int i = 1; i < graph.v; i++) {
			System.out.print(i);
			for (Pair p : graph.adjListArray[i]) {
				System.out.print("-> "+p.dest+" "+p.weight+" ");
			}
			System.out.println();
		}
	}
	
	static class Node {
		int vertex, key , parent;
	}
	
	static class comparator implements java.util.Comparator<Node> {

		@Override
		public int compare(Node node1, Node node2) {
			return (node1.key - node2.key);
		}
	}
	
	static void prims_mst(Graph graph) {
		
		boolean mstSet[] = new boolean[graph.v];
		Node node[] = new Node[graph.v];
		for (int i = 1; i < graph.v; i++) {
			node[i] = new Node();
			node[i].vertex = i;		node[i].key = Integer.MAX_VALUE;	node[i].parent = -1;
			
		}
		
		node[1].key = 0;
		mstSet[1] = true;
		
		PriorityQueue<Node> pQueue = new PriorityQueue<>(graph.v, new comparator());
		for (int i = 1; i < graph.v; i++) {
			pQueue.add(node[i]);
		}
		
		/*for (int i = 1; i < node.length; i++) {
			System.out.println(node[i].vertex +" "+node[i].key+" "+node[i].parent);
		}*/
		
		
		while(pQueue.size() > 0) {
			 
			Node node0 = pQueue.poll();
			mstSet[node0.vertex] = true;
			//System.out.println("Vertex "+ node0.vertex);
			for (Pair p : graph.adjListArray[node0.vertex]) {
				//System.out.println("Dest "+ p.dest);
				
				//If V is in PriorityQueue 
				if(mstSet[p.dest]== false) {
					
					if(node[p.dest].key > p.weight) {
						pQueue.remove(node[p.dest]);
						node[p.dest].key = p.weight;	
						pQueue.add(node[p.dest]);
						node[p.dest].parent = node0.vertex;
						
						/*for (int i = 1; i < node.length; i++) {
							System.out.println(node[i].vertex +" "+node[i].key+" "+node[i].parent);
						}
						System.out.println("-----");*/
					}
				}
			}
		}
		
		/*for (int i = 1; i < node.length; i++) {
			System.out.println(node[i].vertex +" "+node[i].key+" "+node[i].parent);
		}*/
		
		int count = 0;
		for (int i = 1; i < graph.v; i++) {
			if(node[i].key != Integer.MAX_VALUE) {
				count += node[i].key;
			}
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ne[] = br.readLine().trim().split("\\s+"), ip[] = br.readLine().trim().split("\\s+");
			int vertices = Integer.parseInt(ne[0]), edges = Integer.parseInt(ne[1]);
			Graph graph = new Graph(vertices+1);
			for (int i = 0; i < ip.length; i+=3) {
				int src = Integer.parseInt(ip[i]), dest = Integer.parseInt(ip[i+1]), weight = Integer.parseInt(ip[i+2]);
				addEdges(graph,src,dest,weight);
			}
			printList(graph);
			prims_mst(graph);
		}
	}
}
