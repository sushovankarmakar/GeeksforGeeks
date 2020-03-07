import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/check-bits-number-set/

class CheckSetBits {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine().trim());
			
			/*
			//Integer.bitCount counts the number of set bits of a binary representation of number
			if(Integer.bitCount(n)==Integer.toBinaryString(n).length()) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}*/
			
			if( (n & (n+1)) == 0 ) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
}
