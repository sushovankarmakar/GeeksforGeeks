import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// incomplete

// https://practice.geeksforgeeks.org/problems/squares-in-reactangle/0

class SquaresInReactangle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			String ip[] = br.readLine().trim().split("\\s+");
			int mod = 1000000007;
			long a = Long.parseLong(ip[0])%mod, b = Long.parseLong(ip[1])%mod;
			if(a < b) {
				long temp = a;
				a = b;
				b = temp;
			}
			
			long boxes = (a*b)%mod;
			System.out.println("boxes "+boxes);
			int op = 0;
			long min = (a > b) ? b : a;
			
			while(boxes > 1) {
				System.out.println("min "+min);
				
				long no = ((min % mod)*(min % mod))% mod;
				
				op += boxes/(no);
				System.out.println("op "+op);
				
				boxes %= (no);
				System.out.println("boxes "+boxes);
				
				b = (a%b);
				a = min;
				
				min = (a > b) ? b : a;
			}
			System.out.println(op);
		}
	}
}
