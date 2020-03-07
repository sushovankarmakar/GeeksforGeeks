import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// if n+2 is a prime no. then n is a part of the given series, else no.

class PartOfIt {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			System.out.println((isPrime(n+2)?"Yes":"No"));
		}
	}
	
	static boolean isPrime(int n) {
		
		int range = (int)Math.sqrt(n);
		for (int i = 2; i <= range; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
}
