import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Rotating_an_Array {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			StringBuffer sb = new StringBuffer();
			int d = Integer.parseInt(br.readLine().trim());
			int ip[] = new int[n];
			for (int i = 0; i < s.length; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			
			/* approach-1 : Using extra space
			 * int op[] = new int[n];
			for (int i = 0; i < s.length; i++) {
				int pos = (i+d)%(n);
				op[i] = ip[pos];
				sb.append(op[i]+" ");
			}*/
			
			// approach-2 : using no extra space
			for (int i = d; i < d+n; i++) {
				sb.append(ip[i%n]+" ");
			}
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
