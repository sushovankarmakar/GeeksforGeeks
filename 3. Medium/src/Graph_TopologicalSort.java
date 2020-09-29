import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// https://practice.geeksforgeeks.org/problems/topological-sort/1
// https://www.geeksforgeeks.org/topological-sorting/
// https://www.youtube.com/watch?v=Q9PIxaNGnig&ab_channel=GeeksforGeeks (BEST explanation with code)
// https://www.youtube.com/watch?v=ddTC4Zovtbc&ab_channel=TusharRoy-CodingMadeSimple (BEST explanation)
// https://leetcode.com/tag/topological-sort/

class Graph_TopologicalSort {

	/*-- NEW VERSION with adjacency list --*/
	/* This topoSortUtil is nothing but doing DFS and then when all the neighbouring nodes are done visiting,
	then we store that node to the stack */
	/*
	Time Complexity: O(V+E).
	The below algorithm is simply DFS with an extra stack. So time complexity is the same as DFS which is.
	Space complexity: O(V).
	The extra space is needed for the stack.
	*/
	static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {

		boolean[] isVisited = new boolean[N];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			if (!isVisited[i]) {
				topoSortUtil(i, adj, isVisited, stack);
			}
		}

		int[] op = new int[N];
		for (int i = 0; i < N; i++) {
			if (!stack.isEmpty()) {
				op[i] = stack.pop();
			}
		}
		return op;
	}

	private static void topoSortUtil(int currNode, ArrayList<ArrayList<Integer>> adj,
									 boolean[] isVisited, Stack<Integer> stack) {
		isVisited[currNode] = true;

		for (Integer adjNode : adj.get(currNode)) {
			if (!isVisited[adjNode]) {
				topoSortUtil(adjNode, adj, isVisited, stack);
			}
		}
		stack.push(currNode);
	}

	/*---------------------------------------------------------------------------------------------------------*/
	/*-- OLD VERSION with adjacency array --*/
	static void topoSort(Graph graph) {
		Set<Integer> visited = new HashSet<>();
		LinkedList<Integer> sortedStack = new LinkedList<>();

		for (int i = 0; i < graph.v; i++) {
			topoSortUtil(graph, i, visited, sortedStack);
		}

		while(!sortedStack.isEmpty()) {
			System.out.print(sortedStack.pop()+" ");
		}
		System.out.println();
	}

	static void topoSortUtil(Graph graph, int v, Set<Integer> visited, LinkedList<Integer> sortedStack) {

		if(!visited.contains(v)) {
			visited.add(v);
			for (Integer adj : graph.adjListArray[v]) {
				topoSortUtil(graph, adj, visited, sortedStack);
			}
			sortedStack.push(v);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0) {
			String[] en = br.readLine().trim().split("\\s+");
			String[] uv = br.readLine().trim().split("\\s+");
			int e = Integer.parseInt(en[0]);
			int n = Integer.parseInt(en[1]);
			Graph graph = new Graph(n);
			for (int i = 0; i < uv.length; i += 2) {
				int src = Integer.parseInt(uv[i]);
				int desc = Integer.parseInt(uv[i + 1]);
				addEdges(graph, src, desc);
			}
			printList(graph);
			System.out.println();
			topoSort(graph);
		}
	}

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
}
