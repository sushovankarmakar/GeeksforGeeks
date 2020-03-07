import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/numbers-exactly-3-divisors/

class ThreeDivisors {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = (int) Math.sqrt(Integer.parseInt(br.readLine())), countPrime=0;
			
			//if square root of number is Prime Number then that number has only 3 divisors 
			
			for (int i = n; i >=2; i--) {
				if(isPrime(i)) countPrime++;
			}
			System.out.println(countPrime);
		}
	}
	
	//checking a number is Prime or not
	static boolean isPrime(int n) {
		boolean b = true;
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
			if(n%i==0) {
				b = false; 
				break;
			}
		}
		return b;
	}
}
