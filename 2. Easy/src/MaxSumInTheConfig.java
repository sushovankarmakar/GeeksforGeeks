import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//INCOMPLETE

class MaxSumInTheConfig {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < n ; i++) {
				ip[i] = Integer.parseInt(s[i]);
			}
			System.out.println(max_sum(ip, n));
		}
	}
	
	static int max_sum(int ip[], int n) {
		int max = Integer.MIN_VALUE , maxPos=-1, sum=0;
		for (int i = 0; i < n; i++) {
			if(max < ip[i] ) {
				max = ip[i];
				maxPos = i;
			}
		}
		int jump = n - maxPos - 1;
		for (int i = 0; i < n-1; i++) {
			int temp = ip[i];
			ip[i] = ip[(i+jump)%n];
			ip[(i+jump)%n] = temp;
		}
		
		for (int i = 0; i < ip.length; i++) {
			sum += (ip[i]*i);
			//System.out.print(ip[i]+" ");
		}
		//System.out.println();
		return sum;
	}
	
}
