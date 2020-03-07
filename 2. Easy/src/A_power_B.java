import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class A_power_B {

	static int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			//int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
			long a = Long.parseLong(s[0]), b = Long.parseLong(s[1]);
			long result = power(a,b);
			System.out.println(result);
		}
	}

	/*static long power(long a, long b) {
		
		long temp = 1;
		if(b==0) return 1;
		temp = power(a,b/2);
		if( (b&1)==0 ) return (temp*temp)%mod;  //check for even
		else 		   return (a*((temp*temp)%mod))%mod;
	}*/
	
	static long power(long a,long b) {
		long result = 1;
		while(b>0) {
			
			if( (b&1)==1 ) result = (result*a)%mod;
			
			b = b>>1;  // b = b/2
			a = (a*a)%mod;   // a = a^2
		}
		return result;
	}
}
