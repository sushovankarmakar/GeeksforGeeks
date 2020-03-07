import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

class PrintFibonacciNum {

	//static int mod = 1000000007;
	//static BigInteger op[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			//op = new BigInteger[n];
			/*fibNum(n-1);
			for (int i = 0; i < n; i++) {
				System.out.print(op[i]+" ");
			}
			*/
			BigInteger a = new BigInteger("1"), b = new BigInteger("1"), c = new BigInteger("0");
			System.out.print(a+" ");
			for (int i = 1; i < n; i++) {
				System.out.print(b+" ");
				c = a.add(b);
				//System.out.print(b+" ");
				a = b;
				b = c;
			}
			System.out.println();
		}
	}
	
	/*static BigInteger fibNum(int n) {
		if(n==0 || n==1) {
			op[n] = BigInteger.valueOf(1);
		}
		else {
			op[n] = BigInteger.valueOf(fibNum(n-1)) + BigInteger.valueOf(fibNum(n-2))) ;
		}
		return op[n];
	}*/
}
