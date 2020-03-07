import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class ProductOfPrimeFactors {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int no = Integer.parseInt(br.readLine().trim());
			int range = (int)Math.sqrt(no);
			long op = 1;
			for (int i = 2; i <= range; i++) {
				if(no%i==0) {
					if(isPrime(i)) {
						op *= i;
					}
					if(isPrime(no/i) && (no/i)!=i) {
						op *= (no/i);
					}
				}
			}
			if(op==1) op = no;
			System.out.println(op);
		}
	}
	
	static boolean isPrime(int n) {
		int range = (int) Math.sqrt(n);
		for (int i = 2; i <= range; i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
