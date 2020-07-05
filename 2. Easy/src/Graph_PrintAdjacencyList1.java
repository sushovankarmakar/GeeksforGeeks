import java.util.ArrayList;
import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1
// https://www.geeksforgeeks.org/graph-and-its-representations/

public class Graph_PrintAdjacencyList1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();

            for(int i = 0; i < nov; i++) {
                list.add(i, new ArrayList<>());
            }

            for(int i = 0; i < edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            printGraph(list, nov);
        }
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj, int v) {
        for(int i = 0; i < v; i++) {
            System.out.print(i);
            for(int j : adj.get(i)) {
                System.out.print( "-> " + j);
            }
            System.out.println();
        }
    }
}
