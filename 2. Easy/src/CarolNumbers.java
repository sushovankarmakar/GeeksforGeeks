import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


//INCOMPLETE ONE

class CarolNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		//int mod = 1000000007;
		while(t-->0) {
			int n = Integer.parseInt(br.readLine()) % 1000000007;
			BigInteger one = new BigInteger("1"), two1 = new BigInteger("2"), 
					   two2 = new BigInteger("2"), base = new BigInteger("1");
			
			/*for (int i = 0; i < n; i++) {
				base = base.multiply(two1).mod(new BigInteger("1000000007"));
			}*/
			two1 = two1.pow(n).mod(new BigInteger("1000000007")).subtract(one);
			two1 = two1.multiply(two1).mod(new BigInteger("1000000007"));
			two2 = two1.subtract(two2);
			System.out.println(two2);
		}
	}
}
