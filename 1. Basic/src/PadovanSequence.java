import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class PadovanSequence {

	static int arr[] = new int[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= 100; i++) {
			arr[i] = 0;
		}
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(padovan(n));
		}
	}
	
	static int padovan(int n) {
		
		int mod = 1000000007;
		if(arr[n]!=0) {
			//return arr[n]%mod;
		}
		else {
			if(n==0||n==1||n==2) {
				arr[n] = 1;
				//return arr[n]%mod;
			}
			else {
				arr[n] = ((padovan(n-2)%mod) + (padovan(n-3)%mod))%mod; // (A+B)%M = (A%M + B%M)%M
				//return arr[n]%mod;  
			}
		}
		return arr[n]%mod;
	}
}
