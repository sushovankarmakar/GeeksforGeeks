import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-->0) {
			String s1[] = br.readLine().trim().split("\\s+"), s2[] = br.readLine().trim().split("\\s+");;
			int n = Integer.parseInt(s1[0]), d = Integer.parseInt(s1[1]);
			int ip[] = new int[n];
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < s2.length; i++) {
				ip[i] = Integer.parseInt(s2[i]);
			}
			for (int i = d; i < (d+n); i++) {
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