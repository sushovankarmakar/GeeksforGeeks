import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/quickly-find-multiple-left-rotations-of-an-array/

class QuickLeftRotation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String s1[] = br.readLine().trim().split("\\s+"), s2[] = br.readLine().trim().split("\\s+");
			StringBuffer sb = new StringBuffer();
			int n = Integer.parseInt(s1[0]), k = Integer.parseInt(s1[1]), jump = (k%n);
			int ip[] = new int[n];
 			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s2[i]);
			}
 			for (int i = 0; i < n; i++) {
				sb.append(ip[ (i+jump)% n]+" ");
			}
 			
 			// approach-2 : using no extra space
 			/*for (int i = d; i < d+n; i++) {
 					sb.append(ip[i%n]+" ");
 			}*/
 			System.out.println(sb);
 			sb.setLength(0);
		}
	}
}

/*Small trick for rotating arrays:
i = ith iteration
D = number of elements to rotate
N = size of array

To handle large D values, before rotating use-
if(D>N)
D %= N;

For left rotate-
arr[i] = arr[(i+D)%N]

For right rotate-
arr[i] = arr[(i+N-D)%N]*/
