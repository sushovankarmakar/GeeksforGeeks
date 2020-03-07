import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class PowerOf2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			long n = Long.parseLong(br.readLine());
			//One line answer
			/*logic: if a number is power of 2, then there is only one bit is set 
					 and the set bit is the left most bit. 
					 like 1: 1, 2: 10, 4: 1000, 8: 1000, 16: 10000 */
			//System.out.println(Long.bitCount(n)==1?"YES":"NO");
			
			
			//use of Brian Kernighan Algorithm to count the no of set bits and
			/*int count = 0;
			while(n>0) {
				n = n & (n-1);
				count++;
			}
			System.out.println( (count == 1) ? "YES" : "NO");*/
			
			//if a number is power of 2, then n&(n-1) will always be 0
			System.out.println( ( (n&(n-1)) ==0)?"YES":"NO");
		}
	}
}
