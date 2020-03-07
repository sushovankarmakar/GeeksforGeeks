import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/c-program-cyclically-rotate-array-one/

class CyclicalRotateArrByOne {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			StringBuffer sb = new StringBuffer();
			int ip[] = new int[n];
			for (int i = 0; i < n; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			// as we are cyclically rotating array by one, so we are going traversing the array from end and swapping values.
			for (int i = n-1; i > 0; i--) {
				int temp = ip[i];
				ip[i] = ip[(i+1)%n];
				ip[(i+1)%n] = temp;
			}
			for (int i = 0; i < ip.length; i++) {
				sb.append(ip[i]+" ");
			}
			System.out.println(sb);
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
