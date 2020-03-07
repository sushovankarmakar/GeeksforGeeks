import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class KthSmallestElement {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String ip[] = br.readLine().trim().split("\\s+");
			int k = Integer.parseInt(br.readLine().trim());
			
			// By default min-Heap is implemented by PriorityQueue class in java.
			
			PriorityQueue<Integer> pqueue = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				pqueue.add(Integer.parseInt(ip[i]));
			}
			
			while(k-->1) {
				pqueue.poll();
			}
			System.out.println(pqueue.poll());
		}
	}
}
