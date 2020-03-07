import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Collections;

class k_largest_elements {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String ip1[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(ip1[0]);
			int k = Integer.parseInt(ip1[1]);
			String ip2[] = br.readLine().trim().split("\\s+");
			
			//solution using max heapify method 
			int[] s = new int[n];
			for (int i = 0; i < n; i++) {
				s[i] = Integer.parseInt(ip2[i]);
			}
			build_max_heapify(s);
			
			for (int i = 0; i < k; i++) {
				int max = heap_extract_max(s);
				System.out.print(max+" ");
			}
			System.out.println();
		}
	}
	
	

	static void build_max_heapify(int[] s) {
		int len = s.length-1;
		for (int i = (len/2); i >= 0; i--) {
			max_heapify(s, i,len);
		}
	}

	static void max_heapify(int s[], int i, int len) {
		int l = 2*i+1; 
		int r = 2*i + 2;
		int largest=0;
	
		if( (l <= len) && (s[l] > s[i]) ) {
			largest = l;
		}
		else largest = i;
		
		if( (r <= len) && (s[r] > s[largest]) ) {
			largest = r;
		}	
		if(largest != i) {
			exchange(s, largest, i);
			max_heapify(s, largest, len);
		}
	}

	static void exchange(int s[], int x, int y) {
		int temp = s[x];
		s[x] = s[y];
		s[y] = temp;
	}
	
	static int heap_extract_max(int[] s) {
		
		if(s.length < 1) return -1;
		
		int max = s[0];
		int len = s.length-1;
		s[0]= s[len];
		max_heapify(s, 0, len--);
		return max;
	}
}



//solution with sorting the whole array in descending order
/*Integer[] s = new Integer[n];
for (int i = 0; i < n; i++) {
	s[i] = Integer.parseInt(ip2[i]);
}
Arrays.sort(s,Collections.reverseOrder());

for (int i = 0; i < k; i++) {
	System.out.print(s[i]+" ");
}
System.out.println();
*/