import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class MagicNumbers {

	static int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			String s[] = br.readLine().trim().split("\\s+");
			int ip[] = new int[n];
			for (int i = 0; i < ip.length; i++) {
				ip[i] = Integer.parseInt(s[i]);
 			}
			int h = hx(ip)%mod; 
			long f = fx(ip)%mod;
			/*System.out.println(h);
			System.out.println(f);*/
			System.out.println(	(int)((Math.pow(f, h))% mod) );
		}
	}

	static long fx(int[] ip) {
		long op=1;
		for (int i = 0; i < ip.length; i++) {
			op = (op*ip[i])%mod;
		}
		return op;
	}

	static int hx(int[] ip) {
		
		int result = ip[0];
		for (int i = 1; i < ip.length; i++) {
			result = gcd(result, ip[i]);
		}
		return result;
	}
	
	static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}
}
