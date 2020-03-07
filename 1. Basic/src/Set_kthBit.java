import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/set-k-th-bit-given-number/

class Set_kthBit {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String s[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(s[0]) , k = Integer.parseInt(s[1]);
			/* 1. Left shift given number 1 by k-1 to create 
			   	  a number that has only set bit as k-th bit.
			      temp = (1<<k)
			    
			   2. Then bitwise OR operation between n and temp  (n|temp)
			 */
			System.out.println( n | (1<<k) );
		}
	}
}
