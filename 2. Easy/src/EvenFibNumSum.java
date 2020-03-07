import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

class EvenFibNumSum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			BigInteger a = new BigInteger("1"), b = new BigInteger("1"), c = new BigInteger("0"), sum = new BigInteger("0");
			
			while( c.compareTo(BigInteger.valueOf(n))==-1) {
				c = a.add(b);
				//System.out.print(c+" ");
				a = b;
				b = c; 
				if(!c.testBit(0) && (c.compareTo(BigInteger.valueOf(n))==0 || c.compareTo(BigInteger.valueOf(n))==-1)) {
					sum = sum.add(c);
				}
			}
			System.out.println(sum);
		}
	}
}
