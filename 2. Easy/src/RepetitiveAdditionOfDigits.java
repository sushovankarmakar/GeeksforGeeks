import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class RepetitiveAdditionOfDigits {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			int d = 0;
			while(n!=0) {
				d = n % 10;
				sum += d;
				n /= 10;
				
				if((sum > 9) & (n==0)) {
					n = sum;
					sum = 0;
				}
			}
			System.out.println(sum);
		}
	}
}


//one line solution
// If N is multiple of 9 then the answer is 9 else answer is N mod 9 
/*
if (n == 0) 
    return 0;
    return (n % 9 == 0) ? 9 : (n % 9);
 */
    